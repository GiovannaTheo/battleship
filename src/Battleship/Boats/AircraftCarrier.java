package Battleship.Boats;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class AircraftCarrier extends Boat {

    public AircraftCarrier() {
        this.setHitpoints(this.getLength());
    }


    @Override
    public int getLength() {
        return 5;
    }
}
