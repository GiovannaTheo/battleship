package Battleship.App;

import Battleship.Boats.Orientation;
import Battleship.Grid.Coordinates;
import Battleship.Grid.OpponentGrid;
import Battleship.Grid.UserGrid;
import Battleship.Boats.Boat;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.HashMap;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
public class Player {

    private UserGrid userBoard;

    // String is the name the user will give to his boats
    private HashMap<String, Boat> boats = new HashMap<String, Boat>();

    private OpponentGrid opponentBoard;

    /*
        Methods
    */

    public Player() {
        //TODO
    }

    public Boat selectBoat() {
        // TODO
        return null;
    }

    public void placeBoat(Boat boat, Coordinates coord, Orientation orientation) {
        // TODO
    }

    public void receiveAttack(Coordinates coord) {
        // TODO
    }

    public void targetSquare(Coordinates coord) {
        // TODO
    }


    /*
        Getters and setters
    */
    public UserGrid getUserBoard() {
        return userBoard;
    }

    public void setUserBoard(UserGrid userBoard) {
        this.userBoard = userBoard;
    }

    public HashMap<String, Boat> getBoats() {
        return boats;
    }

    public void setBoats(HashMap<String, Boat> boats) {
        this.boats = boats;
    }

    public OpponentGrid getOpponentBoard() {
        return opponentBoard;
    }

    public void setOpponentBoard(OpponentGrid opponentBoard) {
        this.opponentBoard = opponentBoard;
    }


}
