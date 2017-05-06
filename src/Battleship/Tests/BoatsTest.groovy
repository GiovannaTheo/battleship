package Battleship.Tests

import Battleship.Boats.Cruiser
import Battleship.Boats.Orientation
import org.junit.Test

/**
 * Created by arthurdeschamps on 06.05.17.
 */
class BoatsTest extends GroovyTestCase {

    /**
     * Testing Boat class
     */

    @Test
    void testBoatInstantiation() {
        Cruiser cruis = new Cruiser()
        assertEquals(4, cruis.getLength())
        assertEquals(cruis.getHitpoints(), cruis.getLength())
        assertEquals(cruis.getOrientation(), Orientation.UP)
        cruis.setOrientation(Orientation.DOWN)
        cruis.inflictDamage()
        assertEquals(3, cruis.getHitpoints())
    }

}
