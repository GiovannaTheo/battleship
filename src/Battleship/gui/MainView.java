

/** VERSION 2 - BUTTONS */

package Battleship.gui;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import Battleship.App.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.*;
import java.awt.event.*;

import net.miginfocom.swing.MigLayout;

public class MainView extends JFrame{

    public MainView(){
        super("MigLayout Basic");
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

    //Designing the board

    private JPanel button(){ //Set buttons in pannel

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("debug, fillx", "[][grow][]"));

        JButton b1 = new JButton(new Start("Start"));
        panel.add(b1, "growx, w " + this.getWidth()/5);

        JLabel oppGrid = new JLabel("Opponent grid should be here");
        panel.add(oppGrid, "span 2 3 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        JButton b2 = new JButton(new Abandon("Abandon"));
        panel.add(b2, "growx, wrap, w " + this.getWidth()/5);

        JLabel boatSelect = new JLabel("Boat orientation select should be here");
        panel.add(boatSelect, "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        JLabel userGrid = new JLabel("Boat select should be here");
        panel.add(userGrid, "span 1 2 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        JLabel boatOrientation = new JLabel("UserGrid should be here");
        panel.add(boatOrientation, "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        return panel;
    }

}






