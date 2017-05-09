package battleship.gui.grid;

import battleship.app.GameState;

import battleship.boats.Boat;
import battleship.grid.Coordinates;

import battleship.grid.*;
import battleship.gui.boats.BoatImageComponent;
import battleship.gui.main.game.GameView;
import battleship.gui.main.game.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import static battleship.gui.main.game.GameView.*;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class GridUser extends JPanel {

    protected int columnCount = 11; //Size of the grid
    protected int rowCount = 10;
    protected java.util.List<Cell> grid;
    protected Point selectedCell; //Selected cell that needs to be filled

    public GridUser() {

        grid = new ArrayList<>(columnCount * rowCount);

        // Init dimensions to 0 (real values are initialized in mouseClicked handler

        MouseAdapter mouseHandlerClick;
        mouseHandlerClick = new MouseAdapter() {

            //Redefines handler of event "MouseClicked"

            @Override
            public void mouseClicked(MouseEvent e) {

                int width = getWidth();
                int height = getHeight();

                int cellWidth = width / columnCount;
                int cellHeight = height / rowCount;

                selectedCell = null; //Init

                if (e.getX() >= ((width - (columnCount * cellWidth)) / 2) && e.getY() >= ((height - (rowCount * cellHeight)) / 2)) {

                    int column = (e.getX() - ((width - (columnCount * cellWidth)) / 2)) / cellWidth;
                    int row = (e.getY() - ((height - (rowCount * cellHeight)) / 2)) / cellHeight;

                    if (column >= 0 && row >= 0 && column < columnCount && row < rowCount) {

                        selectedCell = new Point(column, row); //Mouse is over a certain cell

                    }

                }

                Graphics g = getGraphics();
                paintComponent(g); // Updates the panel

            }
        };
        addMouseListener(mouseHandlerClick); //Puts the handler defined above in the MouseListener
    }

    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;

        int xOffset = (width - (columnCount * cellWidth)) / 2;
        int yOffset = (height - (rowCount * cellHeight)) / 2;

        if (grid.isEmpty()) { //Create a cell that are added to the set grid
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Cell cell = new Cell(
                            xOffset + (col * cellWidth),
                            yOffset + (row * cellHeight),
                            cellWidth,
                            cellHeight);
                    if (row != 10){
                        grid.add(cell);
                        cell.setCoord(new Coordinates(col, row)); //Set coord of each cell
                    }
                }
            }
        }

        if (selectedCell != null && selectedCell.x != 10) { //If we clicked on one cell, colors it

            // If user is still placing the boats


            int index = selectedCell.x + (selectedCell.y * columnCount);
            Cell cell = grid.get(index);

            g.setColor(Color.RED);


            Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());

            if (GameState.getPlayer().isPlaying) { //If user pressed "Start" then he is allowed to mark the squares
                if (square.hasBoat){ //If there's a boat on the square
                    //g.fillRect((int)cell.getX(), (int)cell.getY(), cellWidth, cellHeight); //Fill it
                    g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4), cellWidth/4, cellWidth/4);
                }


                // If user wants to place a boat
                Boat selectedBoat = GameState.getPlayer().getSelectedBoat();
                if (selectedBoat != null) {
                    this.addBoat(selectedBoat, cell);
                }
            }
        }

        g.setColor(Color.BLACK);

        for (Cell cell : grid) {
            double x = cell.getX(); //Gets coords of the cell
            double y = cell.getY();
            if (cell.getCoord().getX() != 10) {
                g.drawRect((int) x, (int) y, cellWidth, cellHeight); //Draws outlines of a Cell
            }else{
                switch (cell.getCoord().getY()) {
                    case 0:
                        g.drawString("0", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 1:
                        g.drawString("1", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 2:
                        g.drawString("2", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 3:
                        g.drawString("3", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 4:
                        g.drawString("4", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 5:
                        g.drawString("5", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 6:
                        g.drawString("6", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 7:
                        g.drawString("7", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 8:
                        g.drawString("8", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    case 9:
                        g.drawString("9", (int) cell.getCenterX(), (int) cell.getCenterY());
                        break;
                    default:
                        break;
                }
            }
        }

        g.dispose(); //Freeing materials used
    }


    // Add a boat with head at headCell to the grid
    private void addBoat(Boat boatToAdd, Cell headCell) {
        try {
            Logger.getGlobal().info("adding boat");
            // Get boat image
            BoatImageComponent boatImage = boatToAdd.getVisualForm(null);
            boatImage.setLayout(null);
            // Add boat to mainView
            this.getParent().add(boatImage);
            // Size of the boat
            boatImage.setSize(new Dimension((int)headCell.getWidth()*boatToAdd.getLength(), (int)headCell.getHeight()/2));
            // Location
            boatImage.setLocation((int) headCell.getX(), (int) headCell.getY());

            // Removes selected boat
            GameState.getPlayer().getBoats().remove(boatToAdd);

            // When boat is placed, selectedBoat becomes either the
            // first boat in the list, or null
            if (GameState.getPlayer().getBoats().isEmpty()) {
                GameState.getPlayer().setSelectedBoat(null);
            } else {
                GameState.getPlayer().setSelectedBoat(GameState.getPlayer().getBoats().get(0));
            }

            // Update views
            getBoatRotator().repaint();
            getBoatSelector().repaint();


            Logger.getGlobal().warning("Number of boats left: "+Integer.toString(GameState.getPlayer().getBoats().size()));


        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
