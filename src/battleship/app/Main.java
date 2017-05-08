package battleship.app;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import battleship.gui.main.MainView;

import java.util.logging.Logger;

public class Main {
    
    public static void main(String args[]) {

        init();

    }

    private static void init() {

        // Init player
        Player player = new Player();

        // Render main view
        MainView view = new MainView(player);

    }
}
