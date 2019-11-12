package game_engine;

import com.sun.prism.Graphics;
import factories.AlienFactory;
import factories.Brickfactory;
import gui.MainMenuPanel;
import model.Paddle;
import model.balls.Ball;
import model.balls.SimpleBall;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static game_engine.GameConstants.*;


enum GameStatus {
    Won, Lost, Undecided
}

public class Game implements Runnable , GameConstants{

    private String playerName = "Enes";
    private Player player;
    private int totalBricks = 48;
    private Ball ball;

    private Board board;
    private MainMenuPanel initiater;
    private Brickfactory brickFactory;
    private AlienFactory alienFactory;
    private GameStatus status;
    private Paddle paddle;
    private Map gameMap;
    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 1000, xSpeed, withSound, level = 1;
//  private String playerName;
    private AtomicBoolean isPaused = new AtomicBoolean(true);
    private Board gameBoard;


    public Game(Player player) {


        //TODO:initialize Map

        playerName = JOptionPane.showInputDialog("Please enter your name:", "Brick Breaker, Corporate Slaves");
        ball = new Ball();
        paddle = new Paddle(PADDLE_X_START, PADDLE_Y_START, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);


        //TODO: addKeyListener
        //addKeyListener(new BoardObserver());
        //this.balls = new ArrayList<Ball>();
        //added main ball to screen
        //balls.add(new SimpleBall(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT, Color.BLACK));
        //Get the player's name

    }
    public String getPlayerName() {
        return playerName;
    }

    public Ball getBall(){
        return this.ball;
    }

    //Mutator methods
    public void setBallY(int y_coord) {
        this.ball.setY(y_coord);
    }
    public void setBallX(int x_coord) {
        this.ball.setX(x_coord);
    }
    public void setBallXDir(int xDir) {
        this.ball.setXDir(xDir);
    }
    public void setBallYDir(int yDir) {
        this.ball.setYDir(yDir);
    }


    //Accessor methods
    public int getBallXDir() {
        return this.ball.getXDir();
    }
    public int getBallYDir() {
        return this.ball.getYDir();
    }
    public int getBallX() {
        return ball.getX();
    }
    public int getBallY() {
        return ball.getY();
    }


    @Override
    public void run() {

        while (true) {
            System.out.println("This proves we run the game thread!");

            //Makes sure speed doesnt get too fast/slow
//            if (Math.abs(xSpeed) > 1) {
//                if (xSpeed > 1) {
//                    xSpeed--;
//                }
//                if (xSpeed < 1) {
//                    xSpeed++;
//                }
//            }
//
//            //TODO: implement below functions
//            //checkPaddleCollusion(balls);
//            //checkWallCollusion(balls);
//            //checkBrickCollusion(balls);
//            //checkLives();
//            //checkIfOut(y1);
//            //ball.move();
//            //dropItems();
//            // checkItemList();
//            // repaint();

            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
    public int getTotalBricks() {
        return totalBricks;
    }

    public void setTotalBricks(int totalBricks) {
        this.totalBricks = totalBricks;
    }

}







//        if (playerName.toUpperCase().equals("WARRIS") || playerName.toUpperCase().equals("WARRIS GILL") || playerName.toUpperCase().equals("ATİLLA") || playerName.toUpperCase().equals("ATİLLA GÜRSOY")) {
//            score += 1000;
//            gameBoard.showMessage("What a nice nime ! You unlocked the secret 1,000 point bonus! Have fun!", "1,000 Points");
//        }

