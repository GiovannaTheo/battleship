package battleship.gui.main.start;

import battleship.gui.main.buttonactions.StartAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class StartView extends JPanel {

    private final static JButton startButton = new JButton(new StartAction());
    public StartView() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add components
        this.add(startButton, gbc);
    }
}
