package Battleship.gui;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainView {

    public MainView() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private int columnCount = 10;
        private int rowCount =10;
        private List<Rectangle> cells;
        private Point selectedCell;

        public TestPane() {

            cells = new ArrayList<>(columnCount * rowCount);
            MouseAdapter mouseHandler;
            mouseHandler = new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    Point point = e.getPoint();

                    int width = getWidth();
                    int height = getHeight();

                    int cellWidth = width / columnCount;
                    int cellHeight = height / rowCount;

                    selectedCell = null;

                    if (e.getX() >= ((width - (columnCount * cellWidth)) / 2) && e.getY() >= ((height - (rowCount * cellHeight)) / 2)) {

                        int column = (e.getX() - ((width - (columnCount * cellWidth)) / 2)) / cellWidth;
                        int row = (e.getY() - ((height - (rowCount * cellHeight)) / 2)) / cellHeight;

                        if (column >= 0 && row >= 0 && column < columnCount && row < rowCount) {

                            selectedCell = new Point(column, row);

                        }

                    }
                    repaint();
                }
            };
            addMouseMotionListener(mouseHandler);
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
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            int cellWidth = width / columnCount;
            int cellHeight = height / rowCount;

            int xOffset = (width - (columnCount * cellWidth)) / 2;
            int yOffset = (height - (rowCount * cellHeight)) / 2;

            if (cells.isEmpty()) {
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

            if (selectedCell != null) {

                int index = selectedCell.x + (selectedCell.y * columnCount);
                Rectangle cell = cells.get(index);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fill(cell);

            }

            g2d.setColor(Color.GRAY);
            for (Rectangle cell : cells) {
                g2d.draw(cell);
            }

            g2d.dispose();
        }
    }
}

/** VERSION 2 - BUTTONS */

/*
public class MainView extends JFrame{


    public MainView() {
        super();
        build();
    }



    private void build(){ //Set windows

        setTitle("Battleship - WarZone");
        setSize(1200,800);
        setLocationRelativeTo(null); //Center
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(button());
    }



    public class Abandon extends AbstractAction { //Actions for buttons
        public Abandon(String texte) {
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {



            if (JOptionPane.showConfirmDialog(null, "Are you sure you wanna quit like a lil' coward?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                GameState.abandon(); //Quit the game
            }

        }
    }

    public class Start extends AbstractAction {
        public Start(String texte){
            super(texte);
        }


        public void actionPerformed(ActionEvent e) {
            Player user = new Player(); //Start the game by creating a new player
        }
    }

    private JPanel button(){ //Set buttons in pannel

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton b1 = new JButton(new Start("Start"));
        panel.add(b1);

        JButton b2 = new JButton(new Abandon("Abandon"));
        panel.add(b2);

        return panel;
    }

}

*/
