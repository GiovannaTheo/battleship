package battleship.gui.grid;

import battleship.app.GameState;

import battleship.grid.Coordinates;

import battleship.grid.*;

import java.awt.*;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class DrawGridUser extends DrawGrid {

    public DrawGridUser(){
        super();
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
                    grid.add(cell);
                    cell.setCoord(new Coordinates(row, col)); //Set coord of each cell
                }
            }
        }

        if (selectedCell != null) { //If we clicked on one cell, colors it

            int index = selectedCell.x + (selectedCell.y * columnCount);
            Cell cell = grid.get(index);

            g.setColor(Color.RED);

            System.out.println("coord x: " + cell.getCoord().getX() + " coord y: " + cell.getCoord().getY());

            Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());

            if (GameState.getPlayer().isPlaying) { //If user pressed "Start" then he is allowed to mark the squares
                if (square.hasBoat){ //If there's a boat on the square
                    g.fillRect((int)cell.getX(), (int)cell.getY(), cellWidth, cellHeight); //Fill it
                }
            }
        }

        g.setColor(Color.BLACK);
        for (Cell cell : grid) {
            double x = cell.getX(); //Gets coords of the cell
            double y = cell.getY();
            g.drawRect((int) x, (int) y, cellWidth, cellHeight); //Draws outlines of a Cell
        }

        g.dispose(); //Freeing materials used
    }
}
