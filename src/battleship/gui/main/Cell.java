package battleship.gui.main;

import battleship.grid.Coordinates;

import java.awt.*;

/**
 * Created by Theo on 08/05/2017.
 */

public class Cell extends Rectangle{

    private Coordinates coord;

    public Cell(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public Coordinates getCoord(){
        return this.coord;
    }

    public void setCoord(Coordinates value){
        this.coord = value;
    }
}
