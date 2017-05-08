package battleship.gui.boats;

import battleship.app.GameState;
import battleship.boats.Boat;
import battleship.gui.main.BoatImageComponent;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * Created by arthurdeschamps on 08.05.17.
 */
public class BoatRotator extends JPanel {



    public BoatRotator() {
        super();

        // To fit the parent component
        final Dimension max = new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);


        this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        this.setPreferredSize(max);

        if (this.getBoatImage() != null)
            this.add(this.getBoatImage());

    }

    private BoatImageComponent getBoatImage() {
        if (GameState.getPlayer().getSelectedBoat() != null)
            return GameState.getPlayer().getSelectedBoat().getVisualForm(null);
        return null;
    }

    @Override
    public void repaint() {
        this.removeAll();
        this.add(this.getBoatImage());
        this.revalidate();
        super.repaint();
    }


}
