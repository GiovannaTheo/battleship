package battleship.gui.main;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

/**
 * This class transforms a image file into a swing image component
 */

import battleship.app.GameState;
import battleship.boats.Boat;
import battleship.boats.Orientation;
import battleship.gui.boats.BoatRotator;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.jetbrains.annotations.Contract;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class BoatImageComponent extends JPanel {

    private BufferedImage image;

    // Boat associated to this image
    private Boat associatedBoat;

    public BoatImageComponent(String path, final Boat associatedBoat, MouseAdapter mouseListener) {
        this.associatedBoat = associatedBoat;

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Click handler: depends on the class that uses BoatImageComponent
        addMouseListener(mouseListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Rotate image to horizontal
        AffineTransform at = new AffineTransform();
        at.translate(getWidth() / 2, getHeight() / 2);
        at.rotate(this.getRotationAngle(associatedBoat.getOrientation()));
        at.translate(-image.getWidth()/2, -image.getHeight()/2);


        try {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.getOpacity()));

            g2d.drawImage(this.image,at,null);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    @Contract(pure = true)
    private Boat getAssociatedBoat() {
        return associatedBoat;
    }

    // Returns the angle to rotate the image of, considering its orientation
    private Double getRotationAngle(Orientation orientation) {
        switch (orientation) {
            case RIGHT:
                return Math.PI/2;

            case LEFT:
                return -Math.PI/2;

            case DOWN:
                return Math.PI;

            case UP:
                return 0d;
        }

        return 0d;
    }

    // Image is not opaque only if it is selected
    private float getOpacity() {
        if (this.getAssociatedBoat().isSelected()) {
            return 1f;
        } else {
            return 0.5f;
        }
    }



}
