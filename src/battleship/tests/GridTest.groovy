package battleship.tests

import battleship.grid.Coordinates
import battleship.grid.Grid
import battleship.grid.UserGrid
import org.junit.Test

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

class GridTest extends GroovyTestCase {

    @Test
    void testGrid(){
        Grid userGrid = new UserGrid()
        assertTrue(TestsMethods.sizeArray(userGrid.squares) == 100)
    }

    @Test
    void testMarkSquare(){
        Grid userGrid = new UserGrid()
        Coordinates coord = new Coordinates(5,6)
        userGrid.markSquare(coord)
        assertTrue(userGrid.getSquareByCoordinate(coord).hasBeenShot)
    }

    @Test
    void testCoordinatesEqual() {
        Coordinates coord = new Coordinates(5,8)
        assertTrue(coord.equals(new Coordinates(5,8)))
        assertFalse(coord.equals(null))
        assertFalse(coord.equals(new Coordinates(3,10)))
        assertFalse(coord.equals(new Object()))
    }


}
