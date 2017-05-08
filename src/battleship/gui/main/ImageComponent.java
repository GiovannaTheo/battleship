package battleship.gui.main;

/**
 * Created by arthurdeschamps on 07.05.17.
 */

/**
 * This class transforms a image file into a swing image component
 */

import battleship.boats.Boat;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImageComponent extends JPanel {

    private BufferedImage image;

    // Boat associated to this image
    private Boat associatedBoat;

    public ImageComponent(String path, Boat associatedBoat) {
        this.associatedBoat = associatedBoat;

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.getAssociatedBoat().isSelected()) {
            // Different styling for selected boat
            this.setOpaque(true);
        }

        // Rotate image to horizontal
        AffineTransform at = new AffineTransform();
        at.translate(getWidth() / 2, getHeight() / 2);
        at.rotate(Math.PI/2);
        at.translate(-image.getWidth()/2, -image.getHeight()/2);


        try {
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(this.image,at,null);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    public Boat getAssociatedBoat() {
        return associatedBoat;
    }
}
