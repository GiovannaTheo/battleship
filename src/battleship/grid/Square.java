package battleship.grid;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class Square {

    private Coordinates coord;
    public Boolean isEmpty;
    public Boolean hasBoat;
    public Boolean hasBeenShot;

    public Square(Coordinates coord) {
        this.coord = coord;
        this.isEmpty = true;
        this.hasBoat = false;
        this.hasBeenShot = false;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }


}
