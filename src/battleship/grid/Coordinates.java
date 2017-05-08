package battleship.grid;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class Coordinates {

    int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }



    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;

        try {
            Coordinates coord = (Coordinates) o;
            return (coord.getX() == this.getX() && coord.getY() == this.getY());
        } catch (ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
