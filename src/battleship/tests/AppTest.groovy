package battleship.tests

import battleship.app.GameState
import battleship.app.Player

/**
 * Created by Theo on 06/05/2017.
 */

import org.junit.Test
import battleship.grid.*
import battleship.boats.*

class AppTest extends GroovyTestCase {

    /**
     *
     * TESTING PLAYER.JAVA
     *
     * */

        @Test
        void testGetBoats() {
            Player user = new Player()
            List<Boat> boats = user.getBoats()
            assertTrue(boats.size() == 5)
        }


         @Test
         void testReceiveAttack(){
             Player user = new Player()
             Grid userGrid = user.getuserGrid()
             Coordinates coord = new Coordinates(5,6)
             userGrid.getSquareByCoordinate(coord).hasBoat = 1
             user.receiveAttack(coord)
             assertTrue(userGrid.getSquareByCoordinate(coord).hasBoat)
             assertTrue(userGrid.getSquareByCoordinate(coord).hasBeenShot)
        }

        @Test
        void testTargetSquare(){
            Player user = new Player()
            Coordinates coord = new Coordinates(5,6)
            user.targetSquare(coord)
            assertTrue(user.getopponentGrid().getSquareByCoordinate(coord).hasBeenShot)
        }

    /**
     * TESTING GameState
     */

        @Test
        void testHasUserLost() {
            Player user = new Player()
            GameState gm = new GameState()
            assertFalse(gm.hasUserLost(user))
            user.getBoats().clear()
            assertTrue(gm.hasUserLost(user))
        }
}
