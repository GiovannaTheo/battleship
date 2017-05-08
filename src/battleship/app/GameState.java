package battleship.app;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

public class GameState {

    /* Attributes of GameState class */

    private int round;
    private Boolean isUserTurn;
    private static Player player;

    /* Default constructor */

    public GameState(Player playerGlobal){
        player = playerGlobal;
        this.isUserTurn = true; /* Base case: user plays */
        this.round = 1;
    }

    /* Methods of GameState class */

    public Boolean getIsUserTurn(){
        return this.isUserTurn;
    }

    public void setIsUserTurn(Boolean bool){
        this.isUserTurn = bool;
    }

    public int getRound(){
        return this.round;
    }

    public void updateRound(){ /* Updates round */
        this.round += 1;
    }

    public Boolean hasUserLost(Player user) {
        return (user.getBoats() == null || user.getBoats().isEmpty()); //If there isn't any boat left in user's list then he loses
    }

    public static void abandon(){
        System.exit(0); //Quitting game
    }

    public static Player getPlayer() {
        return player;
    }
}


