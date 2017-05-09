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
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;

import battleship.gui.boats.BoatRotator;
import battleship.gui.boats.BoatSelector;
import battleship.gui.grid.DrawGridOpponent;
import battleship.gui.grid.DrawGridUser;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.layout.CC;
import org.jetbrains.annotations.Contract;

public class MainView extends JFrame {

    // Components
    private static BoatSelector boatSelector;
    private static BoatRotator boatRotator;

    // Timer for frame refreshing
    private Timer timer;

    public MainView(){

        super("MigLayout Basic");

        // Components initialization
        this.setBoatSelector(new BoatSelector());
        this.setBoatRotator(new BoatRotator());


        setTitle("Battleship - WarZone");
        setSize(300,300);
        setLocationRelativeTo(null); //Center
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(startPanel()); //Set panel
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
            setSize(1200,800); //Set size for new panel
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); //Center
            setContentPane(FullPanel()); //Set main panel
        }
    }

    public class Exit extends AbstractAction {

        public Exit(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e) {
            GameState.abandon();
        }
    }

    //Designing the board

    private JPanel startPanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); //To center the start button
        JButton b1 = new JButton(new Start("Start"));
        panel.add(b1, gbc); //Adds button and centers it
        return panel;

    }

    private JPanel mainPanel(){ //Set main panel

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("", "[][grow][]"));

        JButton b1 = new JButton(new Exit("Exit"));
        panel.add(b1, " growx, w " + this.getWidth()/5);

        //Opponent grid
        DrawGridOpponent opponentGrid = new DrawGridOpponent();
        panel.add(opponentGrid, "span 2 3 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);

        JButton b2 = new JButton(new Abandon("Abandon"));
        panel.add(b2, "growx, wrap, w " + this.getWidth()/5);


        panel.add(MainView.getBoatRotator(), "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/4);


        //JLabel boatOrientation = new JLabel("Boat select should be here");
        panel.add(MainView.getBoatSelector(), "span 1 2 " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        //UserGrid
        DrawGridUser userGrid = new DrawGridUser();
        panel.add(userGrid, "w " + this.getWidth()/5 + ", grow, wrap, h " + this.getWidth()/3);

        return panel;
    }

    private JPanel FullPanel(){ //Contains explanations and indexes

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("", "[][grow][]"));

        CC componentConstraints = new CC();
        componentConstraints.alignX("center").spanX(); //To center the text below

        JLabel explanations = new JLabel("Explanations here");
        panel.add(explanations, componentConstraints);


        JLabel jump = new JLabel("");
        panel.add(jump, componentConstraints);

        JLabel letters = new JLabel("                                                                            A                 B                  C                   D                  E                  F                G                  H                  I                   J");
        panel.add(letters, "w " + (this.getWidth()-30) + ",center,  grow, wrap, h " + this.getWidth()/13);

        //Mainpanel
        panel.add(mainPanel(), "span 2 3 " + (this.getWidth() - 30) +  ",center,  grow, wrap, h " + this.getHeight());

        return panel;

    }

    @Contract(pure = true)
    public static BoatSelector getBoatSelector() {
        return boatSelector;
    }

    private void setBoatSelector(BoatSelector boatSelector) {
        MainView.boatSelector = boatSelector;
    }


    @Contract(pure = true)
    public static BoatRotator getBoatRotator() {
        return boatRotator;
    }

    private void setBoatRotator(BoatRotator boatRotator) {
        MainView.boatRotator = boatRotator;
    }

}



