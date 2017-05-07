package battleship.app;

import battleship.boats.*;
import battleship.grid.Coordinates;
import battleship.grid.OpponentGrid;
import battleship.grid.UserGrid;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

public final class Player {

    private static UserGrid userGrid;
    private static OpponentGrid opponentGrid;

    // Lists of user's boats
    private static List<Boat> boats;

    // Name of selected boat
    @Nullable
    private static Boat selectedBoat;

    /*
        Methods
    */

    private Player() {

        boats = new ArrayList<>();

        Player.userGrid = new UserGrid();
        Player.opponentGrid = new OpponentGrid();

        // Add the five available boats to the user's boats

        Player.boats.add(new AircraftCarrier());
        Player.boats.add(new Cruiser());
        Player.boats.add(new Cruiser());
        Player.boats.add(new TorpedoBoat());
        Player.boats.add(new TorpedoBoat());

        // Default selected boat (selected by the actual user)
        Player.selectedBoat = Player.getBoats().get(0);
    }

    public static void selectBoat() {
        // TODO: call Player.setSelectedBoat on the mouse selected boat
    }

    public static void placeBoat(Coordinates coord, Orientation orientation) {
        // TODO: place the boat on the gui


        // Delete boat from boats list
        Player.getBoats().remove(selectedBoat);

        // When boat is placed, selectedBoat becomes either the
        // first boat in the list, or null
        if (Player.getBoats().isEmpty()) {
            Player.setSelectedBoat(null);
        } else {
            Player.setSelectedBoat(Player.getBoats().get(0));
        }

    }

    public static void receiveAttack(Coordinates coord) {
        // Checks if there is a boat at these coordinates
        try {
            if(Player.getuserGrid().getSquareByCoordinate(coord).hasBoat) {
                // Find the boat that is at coord
                for (Boat boat : Player.getBoats()) {
                    if (boat.isAtCoordinates(coord)) {
                        boat.inflictDamage();
                    }
                }
            }
            // Mark on GUI that square has been shot
            Player.getuserGrid().markSquare(coord);

        } catch (NullPointerException e) {
            // Potential issue with coordinates
            e.printStackTrace();
        }
    }

    public static void targetSquare(Coordinates coord) {
        Player.getopponentGrid().markSquare(coord);
    }


    /*
        Getters and setters
    */

    public static UserGrid getuserGrid() {
        return userGrid;
    }

    public static void setuserGrid(UserGrid userGrid) {
        Player.userGrid = userGrid;
    }

    public static OpponentGrid getopponentGrid() {
        return opponentGrid;
    }

    public static void setopponentGrid(OpponentGrid opponentGrid) {
        Player.opponentGrid = opponentGrid;
    }

    public static List<Boat> getBoats() {
        return boats;
    }

    public static void setBoats(ArrayList<Boat> boats) {
        Player.boats = boats;
    }

    public static Boat getSelectedBoat() {
        return selectedBoat;
    }

    public static void setSelectedBoat(Boat selectedBoat) {
        Player.selectedBoat = selectedBoat;
    }
}
