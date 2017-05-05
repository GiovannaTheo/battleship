package Battleship.Boats;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class TorpedoBoat extends Boat {

    public TorpedoBoat() {
        super(this.getLength());
    }

    @Override
    public int getLength() {
        return 3;
    }
}
