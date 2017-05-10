package battleship.gui.main.buttonactions;

import battleship.app.GameState;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class AbandonAction extends AbstractAction {


    public AbandonAction(String name) {
        super(name);
    }

    public void actionPerformed(ActionEvent e) {

        if (JOptionPane.showConfirmDialog(null, "Are you sure you wanna quit like a lil' coward?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            GameState.abandon(); //Quit the game
        }

    }
}
