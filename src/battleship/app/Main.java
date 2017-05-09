package battleship.app;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

import battleship.gui.main.game.MainFrame;
import battleship.gui.main.start.StartFrame;

public class Main {

    public static void main(String args[]) {

        init();

    }

    private static void init() {
        // Render main view
        new StartFrame();

    }

    public static void initGame() {
        // Init game
        Player player = new Player();
        player.isPlaying = true;
        new GameState(player);
        new MainFrame();

    }

}
