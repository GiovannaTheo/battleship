package battleship.gui.boats;

import battleship.app.GameState;
import battleship.gui.main.game.GameView;
import battleship.gui.main.game.MainFrame;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by arthurdeschamps on 08.05.17.
 */
public class BoatRotator extends JPanel {

    // Rotation buttons
    private JPanel rotateButtons;

    public BoatRotator() {

        JButton rotateLeftButton = new JButton("Rotate left");
        rotateLeftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameState.getPlayer().getSelectedBoat().rotateLeft();
                GameView.getBoatRotator().repaint();
            }
        });
        JButton rotateRightButton = new JButton("Rotate right");
        rotateRightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameState.getPlayer().getSelectedBoat().rotateRight();
                GameView.getBoatRotator().repaint();
            }
        });

        this.rotateButtons = new JPanel(new GridLayout(1,2));
        this.rotateButtons.add(rotateLeftButton);
        this.rotateButtons.add(rotateRightButton);
        this.rotateButtons.setMaximumSize(new Dimension(this.getWidth()/10,this.getHeight()/4));

        this.setLayout(new GridLayout(2,1));


        if (this.getBoatImage() != null) {
            this.add(this.getBoatImage());
            this.add(this.rotateButtons);
        }

    }

    @Nullable
    private BoatImageComponent getBoatImage() {
        if (GameState.getPlayer().getSelectedBoat() != null)
            return GameState.getPlayer().getSelectedBoat().getVisualForm(null);
        return null;
    }

    private void addComponents() {
        try {
            if (this.getBoatImage() != null && this.rotateButtons != null) {
                this.add(getBoatImage());
                this.add(this.rotateButtons);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void repaint() {
        // Removes current image to get the current selected boat image and add it
        this.removeAll();
        this.addComponents();
        this.revalidate();
        super.repaint();
    }



}
