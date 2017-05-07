package battleship.gui.boats;

import battleship.app.Player;
import battleship.boats.Boat;
import battleship.gui.main.MainView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by arthurdeschamps on 07.05.17.
 */

/**
 * Boat selector GUI component
 */

public class BoatSelector extends JPanel {

    public BoatSelector(Player player) {

        super();

        // Box layout with top to bottom components
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        // Adds boat image representation to the selector
        for(Boat boat : player.getBoats()) {
            // Adds the swing image component representing the boat to the BoatSelector component
            this.add(boat.getVisualForm());
        }

    }
}
