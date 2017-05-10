package battleship.gui.main.game;

import battleship.gui.main.game.GameView;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class MainView extends JPanel {

    private static final GameView gameView = new GameView();

    private final JLabel letters = new JLabel("                                                                            A                 B                  C                   D                  E                  F                G                  H                  I                   J");
    private static JLabel instructions;


    public MainView() {

        // Set layout
        this.setLayout(new MigLayout("fillx","[][grow][]"));

        // Define instruction label constraints
        CC instructionLabelConstraint = new CC();
        instructionLabelConstraint.alignX("center").spanX();

        // Init instructions label
       instructions = new JLabel("Select and place your boats");

        // Add components to our MainView
        this.add(instructions, instructionLabelConstraint);
        this.add(letters,"w 100%-30, center, grow, wrap, h 8%");
        this.add(gameView, "span 2 3 100%-30, center, grow, wrap, h 92%");

    }

    public static GameView getGameView() {
        return gameView;
    }

    public JLabel getLetters() {
        return letters;
    }

    public static JLabel getInstructions() {
        return instructions;
    }
}

