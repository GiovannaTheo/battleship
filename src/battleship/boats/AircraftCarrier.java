package battleship.boats;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class AircraftCarrier extends Boat {

    public AircraftCarrier() {
        super(5);

        final String imagePath = "assets/SeaWarfareSet/Carrier/ShipCarrierHull.png";
        this.setImagePath(imagePath);
    }

}
