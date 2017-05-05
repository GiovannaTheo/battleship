package Battleship.App;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import Battleship.gui.*;

public class Main {

    public static void main(String args[]) {

        init();

    }


    private static void init() {

        // Create player
        Player user = new Player();

        // Render main view
        MainView view = new MainView();
        view.render();
    }
}
