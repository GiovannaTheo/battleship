package battleship.gui.main.game;

import battleship.gui.boats.BoatRotator;
import battleship.gui.boats.BoatSelector;
import battleship.gui.grid.GridOpponent;
import battleship.gui.grid.GridUser;
import battleship.gui.main.buttonactions.AbandonAction;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class GameView extends JPanel {

    private final static BoatSelector boatSelector = new BoatSelector();
    private final static BoatRotator boatRotator = new BoatRotator();

    private final static GridOpponent gridOpponent = new GridOpponent();
    private final static GridUser gridUser = new GridUser();

    private static final JButton exitButton = new JButton(new battleship.gui.main.buttonactions.ExitAction("Exit"));
    private static final JButton abandonButton = new JButton(new AbandonAction("Abandon"));

    GameView() {
        // Set layout
        this.setLayout(new MigLayout("debug","[][grow][]"));

        // Add components
        this.add(exitButton," growx, w 20%");
        this.add(gridOpponent,"span 2 3 20%, grow, wrap, h 40%");
        this.add(abandonButton,"growx, wrap, w 20%");
        this.add(boatRotator, "w 20%, grow, wrap, h 25%");
        this.add(boatSelector, "span 1 2 20%, grow, wrap, h 50%");
        this.add(gridUser, "w 20%, grow, wrap, h 40%");


    }


    public static BoatSelector getBoatSelector() {
        return boatSelector;
    }

    public static BoatRotator getBoatRotator() {
        return boatRotator;
    }

    public static GridOpponent getGridOpponent() {
        return gridOpponent;
    }

    public static GridUser getGridUser() {
        return gridUser;
    }

    public static JButton getExitButton() {
        return exitButton;
    }

    public static JButton getAbandonButton() {
        return abandonButton;
    }
}
