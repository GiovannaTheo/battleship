//DRAWGRID - OK

package battleship.gui.grid;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.util.*;

public class DrawGrid extends JPanel {

    protected int columnCount = 11; //Size of the grid
    protected int rowCount = 10;
    protected java.util.List<Cell> grid;
    protected Point selectedCell; //Selected cell that needs to be filled

    public DrawGrid() {

        grid = new ArrayList<>(columnCount * rowCount);
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
}