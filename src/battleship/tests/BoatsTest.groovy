package battleship.tests

import battleship.boats.Cruiser
import battleship.boats.Orientation
import battleship.grid.Coordinates
import org.junit.Test

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

class BoatsTest extends GroovyTestCase {

    /**
     * Testing Boat class
     */

    @Test
    void testBoat() {
        Cruiser cruis = new Cruiser()
        assertEquals(4, cruis.getLength())
        assertEquals(cruis.getHitpoints(), cruis.getLength())
        assertEquals(cruis.getOrientation(), Orientation.UP)
        cruis.setOrientation(Orientation.DOWN)
        cruis.inflictDamage()
        assertEquals(3, cruis.getHitpoints())
        cruis.setHeadPosition(new Coordinates(4,5))
        assertTrue(cruis.isAtCoordinates(new Coordinates(4,5)))
        assertTrue(cruis.isAtCoordinates(new Coordinates(4,7)))

    }

}
