package Battleship.Grid;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class Square {

    private Coordinates coord;
    private Boolean isEmpty;
    private Boolean hasBoat;
    private Boolean isMarked;

    public Square(Coordinates coord) {
        this.coord = coord;
        this.isEmpty = true;
        this.hasBoat = false;
        this.isMarked = false;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Boolean getHasBoat() {
        return hasBoat;
    }

    public void setHasBoat(Boolean hasBoat) {
        this.hasBoat = hasBoat;
    }

    public Boolean getMarked() {
        return isMarked;
    }

    public void setMarked(Boolean marked) {
        isMarked = marked;
    }
}
