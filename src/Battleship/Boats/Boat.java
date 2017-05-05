package Battleship.Boats;

import Battleship.Grid.Coordinates;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public abstract class Boat {

    private int hitpoints;
    private Orientation orientation;
    private Coordinates headPosition;

    /*
     Methods
    */

    public Boat(int length) {
        // Default boat orientation
        this.setOrientation(Orientation.UP);
        this.setHitpoints(length);

        // (-1,-1) means the boat is not yet on positioned on the board
        this.headPosition = new Coordinates(-1,-1);
    }

    public void inflictDamage() {
        this.setHitpoints(this.getHitpoints()-1);
    }

    public Boolean isAtCoordinates(Coordinates coord) {
        /*
        TODO: determine if boat is on the coordinate (with its orientation and headposition)
         */


        return false;
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
}
