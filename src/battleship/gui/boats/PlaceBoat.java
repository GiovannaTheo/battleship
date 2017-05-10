package battleship.gui.boats;

import battleship.app.GameState;
import battleship.boats.Boat;
import battleship.grid.*;
import battleship.gui.grid.Cell;

import java.awt.*;

/**
 * Created by Theo on 09/05/2017.
 */

public class PlaceBoat {

    public PlaceBoat(){

    }

    //Sorry 'bout this shitty code bellow, but it was the only way we could figure out in a limited amount of time to
    //handle all possible conflicts placing boats....

    public void placeUp(Boat boatToAdd, Cell cell, Graphics g){

        int index = boatToAdd.getLength();

        if ((cell.getCoord().getX() != 10) && (cell.getCoord().getY() + index <= 10)){ //so we don't write on numbers

            Square square1 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());
            Square square2 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()+1));
            Square square3 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()+2));

            switch (index){

                case 5:

                    Square square4 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()+3));
                    Square square5 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()+4));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square4.hasBoat == false && square5.hasBoat == false){
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 + cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 + 2*cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 + 3*cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 + 4*cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square4.hasBoat = true;
                        square5.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }

                case 4:
                    Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()+3));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square.hasBoat == false){
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4 + cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4 + 2*cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4 + 3*cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }

                case 3:

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false){
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4 + cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);
                        g.fillOval((int)(cell.getX() + cell.getWidth() / 2.75), (int)(cell.getY() + cell.getHeight() / 4 + 2*cell.getHeight()), (int)cell.getWidth()/4, (int)cell.getWidth()/4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;

                        break;

                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }
                default:
                    break;

            }
        }else{
            GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats

        }
    }

    public void placeDown(Boat boatToAdd, Cell cell, Graphics g){

        int index = boatToAdd.getLength();

        if ((cell.getCoord().getX() != 10) && (cell.getCoord().getY() - index >= -1)) {

            Square square1 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());
            Square square2 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()-1));
            Square square3 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()-2));

            switch (index) {

                case 5:
                    Square square4 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()-3));
                    Square square5 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()-4));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square4.hasBoat == false && square5.hasBoat == false){

                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - 2 * cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - 3 * cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - 4 * cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square4.hasBoat = true;
                        square5.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }

                case 4:
                    Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX(), cell.getCoord().getY()-3));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square.hasBoat == false) {

                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - 2 * cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - 3 * cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }
                case 3:
                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false) {
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4 - 2 * cell.getHeight()), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        break;}else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }
                default:
                    break;

            }
        }else{
            GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats

        }
    }

    public void placeLeft(Boat boatToAdd, Cell cell, Graphics g) {

        int index = boatToAdd.getLength();

        if ((cell.getCoord().getX() != 10) && (cell.getCoord().getX() - index >= -1)) {

            Square square1 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());
            Square square2 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()-1, cell.getCoord().getY()));
            Square square3 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()-2, cell.getCoord().getY()));

            switch (index) {

                case 5:

                    Square square4 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()-3, cell.getCoord().getY()));
                    Square square5 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()-4, cell.getCoord().getY()));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square4.hasBoat == false && square5.hasBoat == false){
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - 2 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - 3 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - 4 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square4.hasBoat = true;
                        square5.hasBoat = true;

                        break;}
                    else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }

                case 4:

                    Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()-3, cell.getCoord().getY()));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square.hasBoat == false){
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - 2 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - 3 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }
                case 3:
                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false){
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 - 2 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;

                        break;}
                    else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }

                default:
                    break;

            }

        }else{
            GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats

        }
    }

    public void placeRight(Boat boatToAdd, Cell cell, Graphics g) {

        int index = boatToAdd.getLength();
        if (cell.getCoord().getX() + index <= 10) {

            Square square1 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(cell.getCoord());
            Square square2 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()+1, cell.getCoord().getY()));
            Square square3 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()+2, cell.getCoord().getY()));

            switch (index) {

                case 5:

                    Square square4 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()+3, cell.getCoord().getY()));
                    Square square5 = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()+4, cell.getCoord().getY()));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square4.hasBoat == false && square5.hasBoat == false) {
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + 2 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + 3 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + 4 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square4.hasBoat = true;
                        square5.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }


                case 4:
                    Square square = GameState.getPlayer().getuserGrid().getSquareByCoordinate(new Coordinates(cell.getCoord().getX()+3, cell.getCoord().getY()));

                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false && square.hasBoat == false) {
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + 2 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + 3 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;
                        square.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }
                case 3:
                    if (square1.hasBoat == false && square2.hasBoat == false && square3.hasBoat == false) {
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);
                        g.fillOval((int) (cell.getX() + cell.getWidth() / 2.75 + 2 * cell.getWidth()), (int) (cell.getY() + cell.getHeight() / 4), (int) cell.getWidth() / 4, (int) cell.getWidth() / 4);

                        square1.hasBoat = true;
                        square2.hasBoat = true;
                        square3.hasBoat = true;

                        break;
                    }else{
                        GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats
                        break;
                    }

                default:
                    break;

            }

        }else{
            GameState.getPlayer().addBoat(0, boatToAdd); //couldn't be placed so it stays in the list of available boats

        }
    }
}
