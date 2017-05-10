package battleship.gui.main.buttonactions;

import battleship.app.GameState;
import battleship.app.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class StartAction extends AbstractAction {

    public StartAction(){
        super("Start");
    }

    public void actionPerformed(ActionEvent e) {
        // TODO: init boats view, etc
        Main.initGame();

    }
}
