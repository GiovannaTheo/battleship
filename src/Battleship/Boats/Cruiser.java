package Battleship.Boats;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class Cruiser extends Boat {

    public Cruiser() {
        this.setHitpoints(this.getLength());
    }

    @Override
    public int getLength() {
        return 4;
    }
}
