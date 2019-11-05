package game_engine;

import gui.MainMenuPanel;

public class GameController implements GameConstants {
    //Game-objects on screen
//    private Paddle paddle;
//    private ArrayList<Ball> balls;
//    private Map gameMap;
    private MainMenuPanel mainMenu;
//    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 3, xSpeed, withSound, level = 1;
//    private String playerName;
    private Game game;
//    private AtomicBoolean isPaused = new AtomicBoolean(true);

    //Constructor
    public GameController() {
       mainMenu= new MainMenuPanel();
        if(!mainMenu.getPlayPermission()){
            // The game must be initialized
            // The map must be chosen here
            System.out.println("System must visit register or login page");
        }else{

        }


    }

}


