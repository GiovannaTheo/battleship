package battleship.gui.main.buttonactions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class ExitAction extends AbstractAction {

    public ExitAction(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
