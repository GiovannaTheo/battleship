package battleship.app;

import battleship.boats.*;
import battleship.grid.Coordinates;
import battleship.grid.OpponentGrid;
import battleship.grid.UserGrid;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class Player {

    private UserGrid userGrid;
    private OpponentGrid opponentGrid;

    // If players is actually in-game
    public Boolean isPlaying;

    // Lists of user's boats
    private List<Boat> boats;

    // Name of selected boat
    @Nullable
    private Boat selectedBoat;

    /*
        Methods
    */

    public Player() {

        boats = new ArrayList<>();

        this.userGrid = new UserGrid();
        this.opponentGrid = new OpponentGrid();
        this.isPlaying = false;

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

    public void placeBoat(Coordinates coord, Orientation orientation) {
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
            if(this.getuserGrid().getSquareByCoordinate(coord).hasBoat) {
                // Find the boat that is at coord
                for (Boat boat : this.getBoats()) {
                    if (boat.isAtCoordinates(coord)) {
                        boat.inflictDamage();
                    }
                }
            }
            // Mark on GUI that square has been shot
            this.getuserGrid().markSquare(coord);

        } catch (NullPointerException e) {
            // Potential issue with coordinates
            e.printStackTrace();
        }
    }

    public void targetSquare(Coordinates coord) {
        this.getopponentGrid().markSquare(coord);
    }


    /*
        Getters and setters
    */

    public UserGrid getuserGrid() {
        return userGrid;
    }

    public void setuserGrid(UserGrid userGrid) {
        this.userGrid = userGrid;
    }

    public OpponentGrid getopponentGrid() {
        return opponentGrid;
    }

    public void setopponentGrid(OpponentGrid opponentGrid) {
        this.opponentGrid = opponentGrid;
    }

    public List<Boat> getBoats() {
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
