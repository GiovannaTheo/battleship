package battleship.app;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class GameState {


    private int round;
    private Boolean isUserTurn;
    private static Player player;


    public GameState(Player playerGlobal){
        player = playerGlobal;
        this.isUserTurn = true; /* Base case: user plays */
        this.round = 1;
    }


    public static void abandon(){
        System.exit(0); //Quitting game
    }

    public static Player getPlayer() {
        return player;
    }
}


