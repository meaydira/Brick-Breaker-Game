package controllers;

import game_engine.Game;
import game_engine.GameStatus;

public class GameController {
    private Game game;
    private static GameController instance;

    private GameController() {

    }
    public static GameController getInstance(Game newGame){
        if(instance == null){
            instance = new GameController();
        }
        instance.game = newGame;
        return instance;
    }
    public boolean isRunning(){
        return game.isRunning();
    }
    public GameStatus getStatus(){
        return game.getStatus();
    }

}
