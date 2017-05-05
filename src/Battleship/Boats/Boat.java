package Battleship.Boats;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public abstract class Boat {

    private int hitpoints;
    private Orientation orientation;

    /*
     Methods
    */

    public Boat(int length) {
        // Default boat orientation
        this.setOrientation(Orientation.UP);
        this.setHitpoints(length);
    }

    public void inflictDamage() {
        this.setHitpoints(this.getHitpoints()-1);
    }

    public abstract int getLength();


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

}
