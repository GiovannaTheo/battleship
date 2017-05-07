

/** VERSION 2 - BUTTONS */

package Battleship.gui;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
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
                frame.add(new drawGrid());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

/*

package Battleship.gui;



        import Battleship.App.*;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;



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
        setVisible(true);
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


