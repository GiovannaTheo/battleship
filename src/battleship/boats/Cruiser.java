package battleship.boats;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

public class Cruiser extends Boat {

    public Cruiser() {
        super(4);

        final String imagePath = "assets/SeaWarfareSet/Cruiser/ShipCruiserHull.png";
        this.setImagePath(imagePath);
    }

}
