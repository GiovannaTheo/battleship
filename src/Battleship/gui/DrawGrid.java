package Battleship.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.util.*;

public class DrawGrid extends JPanel {

        private int columnCount = 10; //Size of the grid
        private int rowCount = 10;
        private java.util.List<Rectangle> cells;
        private Point selectedCell; //Selected cell that needs to be filled

        public DrawGrid()  {

            cells = new ArrayList<>(columnCount * rowCount);
            MouseAdapter mouseHandler;
            mouseHandler = new MouseAdapter() {

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
                    paintComponent(g); //Updates the panel

                }
            };

            addMouseListener(mouseHandler); //Puts the handler defined above in the MouseListener
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        @Override
        public void invalidate() {
            cells.clear();
            selectedCell = null;
            super.invalidate();
        }

        @Override
        protected void paintComponent(Graphics g) {

            int width = getWidth();
            int height = getHeight();

            int cellWidth = width / columnCount;
            int cellHeight = height / rowCount;

            int xOffset = (width - (columnCount * cellWidth)) / 2;
            int yOffset = (height - (rowCount * cellHeight)) / 2;

            if (cells.isEmpty()) { //Create a cell that are added to the set cells
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        Rectangle cell = new Rectangle(
                                xOffset + (col * cellWidth),
                                yOffset + (row * cellHeight),
                                cellWidth,
                                cellHeight);
                        cells.add(cell);
                    }
                }
            }

            if (selectedCell != null) { //If we clicked on one cell, colors it

                int index = selectedCell.x + (selectedCell.y * columnCount);
                Rectangle cell = cells.get(index);
                g.setColor(Color.LIGHT_GRAY);
                double x = cell.getX(); //Gets coords of the selected cell
                double y = cell.getY();
                System.out.println("coord x: " + x + " coord y: " + y);

                if (MainView.hasPlayer == 0) { //If user pressed "Start" then he is allowed to mark the squares
                    g.fillRect((int) x, (int) y, cellWidth, cellHeight); //Fill it
                }
            }

            g.setColor(Color.BLACK);
            for (Rectangle cell : cells) {
                double x = cell.getX(); //Gets coords of the cell
                double y = cell.getY();
                g.drawRect((int)x, (int)y, cellWidth, cellHeight); //Draws outlines of a rectangle
            }

            g.dispose(); //Freeing materials used
        }
    }
