package battleship.grid;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class UserGrid extends Grid {

    public void markSquare(Coordinates coord) {
        /*
         Mark square as "has been shot". Behavior changes rather
         the square has a boat onto itself or not.
         */
        Square square = this.getSquareByCoordinate(coord);
        square.hasBeenShot = true;

    }
}
