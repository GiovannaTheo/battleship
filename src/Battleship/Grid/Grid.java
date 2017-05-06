package Battleship.Grid;

import java.util.ArrayList;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public abstract class Grid {

    // 2-dimensional array of squares
    private Square[][] squares;


    public Grid() {

        squares = new Square[10][10];
        // squares init
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                squares[i][j] = new Square(new Coordinates(i, j));
            }
        }
    }

    // Behavior is defined in subclasses
    public abstract void markSquare(Coordinates coord);


    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Square getSquareByCoordinate(Coordinates coord) {
        return this.squares[coord.getX()][coord.getY()];
    }

}
