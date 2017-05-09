package battleship.gui.boats;

import battleship.app.GameState;
import battleship.app.Player;
import battleship.boats.Boat;
import battleship.boats.Orientation;
import battleship.gui.main.BoatImageComponent;
import battleship.gui.main.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

/**
 * Boat selector GUI component
 */

public class BoatSelector extends JPanel {

    public BoatSelector() {

        super();

        // Box layout with top to bottom components
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        // Adds boat image representation to the selector
        for(final Boat boat : GameState.getPlayer().getBoats()) {
            // Adds the swing image component representing the boat to the BoatSelector component
            boat.setOrientation(Orientation.RIGHT);

            // Add the component to BoatSelector with a listener to update selected boat onclick
            this.add(boat.getVisualForm(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    GameState.getPlayer().setSelectedBoat(boat);
                    // Repaints entire frame
                    MainView.getBoatRotator().repaint();
                    repaint();
                }
            }));
        }

    }

    @Override
    public void repaint() {
        for(final Boat boat : GameState.getPlayer().getBoats()) {
            boat.setOrientation(Orientation.RIGHT);
        }
        super.repaint();
    }
}
