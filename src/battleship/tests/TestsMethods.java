package battleship.tests;

import java.lang.reflect.Array;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
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
