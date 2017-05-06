package Battleship.Tests;

import java.lang.reflect.Array;

/**
 * Created by Theo on 06/05/2017.
 */
public class TestsMethods {

    public TestsMethods(){

    }

    /* The following method counts elements in any given array / double array */

    public static int sizeArray(Object object) {
        if (!object.getClass().isArray()) {
            return 1;
        }

        int size = 0;
        for (int i = 0; i < Array.getLength(object); i++) {
            size += sizeArray(Array.get(object, i));
        }
        return size;
    }

}
