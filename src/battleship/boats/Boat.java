package battleship.boats;

import battleship.app.GameState;
import battleship.grid.Coordinates;
import battleship.gui.boats.BoatImageComponent;

import java.awt.event.MouseAdapter;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public abstract class Boat {

    private int hitpoints;
    private int length;
    private Orientation orientation;
    private Coordinates headPosition;
    private String imagePath;

    /*
     Methods
    */

    public Boat(int length) {
        // Default boat orientation
        this.setOrientation(Orientation.UP);
        this.setHitpoints(length);

        this.length = length;

        // (-1,-1) means the boat is not yet positioned on the board
        this.headPosition = new Coordinates(-1,-1);

    }

    public void inflictDamage() {
        this.setHitpoints(this.getHitpoints()-1);
    }

    public Boolean isAtCoordinates(Coordinates coord) {
        // Verify if boat is out of game
        if (this.getHeadPosition().getY() < 0 || this.getHeadPosition().getX() < 0)
            return false;
        // If coord is the boat's head, then the boat is at coord
        Coordinates currentPos = this.getHeadPosition();
        if (currentPos.equals(coord))
            return true;

        // Check the other "parts" of the boat
        for (int i = 1; i < this.getLength(); i++) {
            currentPos = getNextPosition(currentPos, this.getOrientation());
            if (currentPos.equals(coord)) {
                return true;
            }
        }

        return false;
    }


    // Returns the position next to the given coordinates, given an orientation
    // (we actually go in the opposite sense of the orientation)

    private Coordinates getNextPosition(Coordinates currentPosition, Orientation orientation) {
        switch (orientation) {
            case UP:
                return new Coordinates(currentPosition.getX(), currentPosition.getY()-1);

            case DOWN:
                return new Coordinates(currentPosition.getX(),currentPosition.getY()+1);

            case LEFT:
                return new Coordinates(currentPosition.getX()+1,currentPosition.getY());

            case RIGHT:
                return new Coordinates(currentPosition.getX()-1,currentPosition.getY());

            default:
                return currentPosition;
        }
    }

    // Renders object as boat image
    public BoatImageComponent getVisualForm(MouseAdapter mouseListener) {
        return  new BoatImageComponent(this.getImagePath(), this, mouseListener);
    }

    public String getPath(){
        return this.getImagePath();
    }

    public Boolean isSelected() {
        return (GameState.getPlayer().getSelectedBoat() != null && GameState.getPlayer().getSelectedBoat().equals(this));
    }

    public void rotateRight() {
        switch (this.getOrientation()) {
            case UP:
                this.setOrientation(Orientation.RIGHT);
                break;

            case DOWN:
                this.setOrientation(Orientation.LEFT);
                break;

            case LEFT:
                this.setOrientation(Orientation.UP);
                break;

            case RIGHT:
                this.setOrientation(Orientation.DOWN);
                break;
        }
    }



    /*
    Getters and setters
     */

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Coordinates getHeadPosition() {
        return headPosition;
    }

    public void setHeadPosition(Coordinates headPosition) {
        this.headPosition = headPosition;
    }

    public int getLength() {
        return length;
    }

    protected String getImagePath() {
        return imagePath;
    }

    protected void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
