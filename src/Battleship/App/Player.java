package Battleship.App;

import Battleship.Boats.*;
import Battleship.Grid.Coordinates;
import Battleship.Grid.OpponentGrid;
import Battleship.Grid.UserGrid;

import com.sun.istack.internal.Nullable;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

public class Player {

    private UserGrid userBoard;
    private OpponentGrid opponentBoard;

    // Lists of user's boats
    private ArrayList<Boat> boats;

    // Name of selected boat
    @Nullable
    private Boat selectedBoat;

    /*
        Methods
    */

    public Player() {
        this.userBoard = new UserGrid();
        this.opponentBoard = new OpponentGrid();

        // Add the five available boats to the user's boats
        this.boats.add(new AircraftCarrier());
        this.boats.add(new Cruiser());
        this.boats.add(new Cruiser());
        this.boats.add(new TorpedoBoat());
        this.boats.add(new TorpedoBoat());

        // Default selected boat (selected by the actual user)
        this.selectedBoat = this.getBoats().get(0);
    }

    public void selectBoat() {
        // TODO: call this.setSelectedBoat on the mouse selected boat
    }

    public void placeBoat(Boat boat, Coordinates coord, Orientation orientation) {
        // TODO: place the boat on the gui

        // Delete boat from boats list
        this.getBoats().remove(selectedBoat);

        // When boat is placed, selectedBoat becomes either the
        // first boat in the list, or null
        if (this.getBoats().isEmpty()) {
            this.setSelectedBoat(null);
        } else {
            this.setSelectedBoat(this.getBoats().get(0));
        }

    }

    public void receiveAttack(Coordinates coord) {
        // Checks if there is a boat at these coordinates
        try {
            if(this.getUserBoard().getSquareByCoordinate(coord).hasBoat) {
                // Find the boat that is at coord
                for (Boat boat : this.getBoats()) {
                    if (boat.isAtCoordinates(coord)) {
                        boat.inflictDamage();
                    }
                }
            }
            // Mark on GUI that square has been shot
            this.getUserBoard().markSquare(coord);

        } catch (NullPointerException e) {
            // Potential issue with coordinates
            e.printStackTrace();
        }
    }

    public void targetSquare(Coordinates coord) {
        this.getOpponentBoard().markSquare(coord);
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

    public OpponentGrid getOpponentBoard() {
        return opponentBoard;
    }

    public void setOpponentBoard(OpponentGrid opponentBoard) {
        this.opponentBoard = opponentBoard;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }

    public Boat getSelectedBoat() {
        return selectedBoat;
    }

    public void setSelectedBoat(Boat selectedBoat) {
        this.selectedBoat = selectedBoat;
    }
}
