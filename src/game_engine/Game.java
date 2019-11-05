package game_engine;

import factories.AlienFactory;
import factories.Brickfactory;
import gui.MainMenuPanel;
import model.Paddle;
import model.balls.Ball;
import model.balls.SimpleBall;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static game_engine.GameConstants.*;


enum GameStatus {
    Won, Lost, Undecided
}

public class Game implements Runnable {

    private Player player;
    private Board board;
    private MainMenuPanel initiater;
    private Brickfactory brickFactory;
    private AlienFactory alienFactory;
    private GameStatus status;
    private Paddle paddle;
    private ArrayList<Ball> balls;
    private Map gameMap;
    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 3, xSpeed, withSound, level = 1;
    private String playerName;
    private AtomicBoolean isPaused = new AtomicBoolean(true);
    private Board gameBoard;


    public Game(Player player) {
        Board gameBoard = Board.getInstance();

        //TODO: addKeyListener
        addKeyListener(new BoardObserver());

        //TODO:initialize Map
        this.balls = new ArrayList<Ball>();
        paddle = new Paddle(PADDLE_X_START, PADDLE_Y_START, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);
        //added main ball to screen
        balls.add(new SimpleBall(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT, Color.BLACK));
        //Get the player's name
        playerName = gameBoard.askInput("Please enter your name:", "Brick Breaker, Corporate Slaves");
        if (playerName.toUpperCase().equals("WARRIS") || playerName.toUpperCase().equals("WARRIS GILL") || playerName.toUpperCase().equals("ATİLLA") || playerName.toUpperCase().equals("ATİLLA GÜRSOY")) {
            score += 1000;
            gameBoard.showMessage("What a nice nime ! You unlocked the secret 1,000 point bonus! Have fun!", "1,000 Points");
        }

    }

    @Override
    public void run() {
        while (true) {
            //Makes sure speed doesnt get too fast/slow
            if (Math.abs(xSpeed) > 1) {
                if (xSpeed > 1) {
                    xSpeed--;
                }
                if (xSpeed < 1) {
                    xSpeed++;
                }
            }

            //TODO: implement below functions
            //checkPaddleCollusion(balls);
            //checkWallCollusion(balls);
            //checkBrickCollusion(balls);
            //checkLives();
            //checkIfOut(y1);
            //ball.move();
            //dropItems();
            // checkItemList();
            // repaint();

            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }


}


