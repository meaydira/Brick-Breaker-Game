package game_engine;

import model.Map;
import model.Paddle;
import model.balls.Ball;
import model.balls.SimpleBall;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class GameController implements Runnable, GameConstants{


    //Game-objects on screen
    private Paddle paddle;
    private ArrayList<Ball> balls;
    private Map gameMap;
    private  JFrame frame;

     //Initial Values for some important variables
    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 3, xSpeed, withSound, level = 1;

    //Player's name
    private String playerName;

    //The game
    private Thread game;

    private AtomicBoolean isPaused = new AtomicBoolean(true);

    //Constructor
    public GameController() {
        initializeFrame();

        Board gameBoard = new Board();
        frame.add(gameBoard);


        //TODO: addKeyListener
        addKeyListener(new BoardObserver());


       //TODO:initialize Map
        this.balls = new ArrayList<Ball>();
        paddle = new Paddle(PADDLE_X_START, PADDLE_Y_START, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);

        //added main ball to screen
        balls.add( new SimpleBall(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT, Color.BLACK));


        //Get the player's name
        playerName = gameBoard.askInput("Please enter your name:", "Brick Breaker, Corporate Slaves");

        if (playerName == null) {
            System.exit(0);
        }

        if (playerName.toUpperCase().equals("WARRIS") || playerName.toUpperCase().equals("WARRIS GILL") || playerName.toUpperCase().equals("ATİLLA") || playerName.toUpperCase().equals("ATİLLA GÜRSOY") ) {
            score += 1000;
           gameBoard.showMessage("What a nice nime ! You unlocked the secret 1,000 point bonus! Have fun!", "1,000 Points");
        }

        game = new Thread(this);
        game.start();
        game.stop();
        isPaused.set(true);
    }

    @Override
    public void run() {
        while(true) {


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
                game.sleep(waitTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }


    public void initializeFrame(){
        frame=new JFrame();
        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("Bricking Bad - COMP302 CORPORATE SLAVES");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setFocusable(true);
    }



    private void initializeGame() {
    }
}
