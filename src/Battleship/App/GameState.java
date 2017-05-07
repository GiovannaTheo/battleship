package Battleship.App;

/**
 * Created by arthurdeschamps on 05.05.17.
 */

import Battleship.App.Player;

public class GameState {

    /* Attributes of GameState class */

    private int round;
    private Boolean isUserTurn;

    /* Default constructor */

    public GameState(){
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

    public static void end(){
        //TODO: display a losing message
    }

    public static void abandon(){
        System.exit(0); //Quitting game
    }

}


