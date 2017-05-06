package Battleship.Tests

import Battleship.App.Player

/**
 * Created by Theo on 06/05/2017.
 */

import org.junit.Test

import java.lang.reflect.Array

import Battleship.Grid.*
import Battleship.Boats.*

import static groovy.test.GroovyAssert.shouldFail

class MainTest extends GroovyTestCase {

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
}
