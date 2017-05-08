

//MainView - OK

package battleship.gui.main;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

import battleship.app.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.*;
import java.awt.event.*;

import battleship.gui.boats.BoatSelector;
import battleship.gui.grid.DrawGridOpponent;
import battleship.gui.grid.DrawGridUser;
import net.miginfocom.swing.MigLayout;

public class MainView extends JFrame {

    // Components
    private BoatSelector boatSelector;

    public MainView(){

        super("MigLayout Basic");

        // Components initialization
        this.setBoatSelector(new BoatSelector(GameState.getPlayer()));

        setTitle("battleship - WarZone");
        setSize(1200,800);
        setLocationRelativeTo(null); //Center
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel()); //Set panel
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
            // TODO: init boats view, etc
            GameState.getPlayer().isPlaying = true;
        }
    }

    //Designing the board

    private JPanel mainPanel(){ //Set main panel

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("", "[][grow][]"));

        JButton b1 = new JButton(new Start("Start"));
        panel.add(b1, "growx, w " + this.getWidth()/5);

        //Opponent grid
        DrawGridOpponent opponentGrid = new DrawGridOpponent();
        panel.add(opponentGrid, "span 2 3 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        JButton b2 = new JButton(new Abandon("Abandon"));
        panel.add(b2, "growx, wrap, w " + this.getWidth()/5);

        JLabel boatOrientation = new JLabel("Boat orientation select should be here");
        panel.add(boatOrientation, "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        //JLabel boatOrientation = new JLabel("Boat select should be here");
        panel.add(this.getBoatSelector(), "span 1 2 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        //UserGrid
        DrawGridUser userGrid = new DrawGridUser();
        panel.add(userGrid, "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        return panel;
    }


    public BoatSelector getBoatSelector() {
        return boatSelector;
    }

    public void setBoatSelector(BoatSelector boatSelector) {
        this.boatSelector = boatSelector;
    }

}
