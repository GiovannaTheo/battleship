package battleship.grid;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class OpponentGrid extends Grid {

    @Override
    public void markSquare(Coordinates coord) {

        // Mark square as "has been shot" on the opponent grid
        Square square = this.getSquareByCoordinate(coord);
        square.hasBeenShot = true;

        // TODO: Ask to user if his opponent has been touched on one of his boats
        Boolean boatTouched;

        boatTouched = true; // TODO: ask user

        if (boatTouched) {
            //TODO: opponent's boat damaged (GUI)
        } else {
            //TODO: no boat damage (GUI)
        }
    }
}
