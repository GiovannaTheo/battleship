package battleship.gui.boats;

import battleship.app.Player;
import battleship.boats.Boat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by arthurdeschamps on 07.05.17.
 */
public class BoatSelector extends JPanel {


    public BoatSelector(Player player) {

        super();

        // Adds boat image representation to the selector
        for(Boat boat : player.getBoats()) {
            this.add(boat.getVisualForm());
        }

    }
}
