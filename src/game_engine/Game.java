package game_engine;

import factories.AlienFactory;
import factories.Brickfactory;
import gui.MainMenuPanel;
import model2.Paddle;
import model.balls.Ball;
import model.balls.SimpleBall;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static game_engine.GameConstants.*;

public class Game implements Runnable, GameConstants {

    private String playerName = "Enes";
    private Player player;
    private int totalBricks = 48;
    private Ball ball;
    private Paddle paddle;
    private GameStatus status;
    private boolean running = false;


    private Board board;
    private MainMenuPanel initiater;
    private Brickfactory brickFactory;
    private AlienFactory alienFactory;
    private Map gameMap;
    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 10, xSpeed, withSound, level = 1;
    //  private String playerName;
    private AtomicBoolean isPaused = new AtomicBoolean(true);
    private Board gameBoard;


    public Game(Player player) {


        //TODO:initialize Map

        playerName = JOptionPane.showInputDialog("Please enter your name:", "Brick Breaker, Corporate Slaves");
        ball = new Ball();
        paddle = new Paddle();

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

    public Ball getBall() {
        return this.ball;
    }

    public Paddle getPaddle() {
        return this.paddle;
    }

    public boolean isRunning() {
        return running;
    }

    //Mutator methods
//    public void setBallY(int y_coord) {
//        this.ball.setY(y_coord);
//    }
//    public void setBallX(int x_coord) {
//        this.ball.setX(x_coord);
//    }
//    public void setBallXDir(int xDir) {
//        this.ball.setXDir(xDir);
//    }
//    public void setBallYDir(int yDir) {
//        this.ball.setYDir(yDir);
//    }
    public int getTotalBricks() {
        return totalBricks;
    }

    public void setTotalBricks(int totalBricks) {
        this.totalBricks = totalBricks;
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


    public GameStatus getStatus() {
        return status;
    }

    public void moveRight(){
        running =true;
        getPaddle().moveRight();
    }

    public void moveLeft(){
        running =true;
        getPaddle().moveLeft();
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {

        while (true) {
            if (getTotalBricks() <= 0) {
                status = GameStatus.Won;
                running = false;
                this.ball.setXDir(0);
                this.ball.setYDir(0);
            }
            if (getBall().getY() > 570) {
                status = GameStatus.Lost;
                running = false;
                getBall().setXDir(0);
                getBall().setYDir(0);
            }
            if (getPaddle().getXpos() <= 10) {
                getPaddle().setXpos(10);
            }

            if (getPaddle().getXpos() >= 520) {
                getPaddle().setXpos(520);
            }


            //squashes with the paddle
            if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos(), PADDLE_Y_START, 30, 8))) {
                getBall().setYDir(-getBall().getYDir());
                getBall().setYDir(-2);
            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 120, PADDLE_Y_START, 30, 8))) {
                getBall().setYDir(-getBall().getYDir());
                getBall().setXDir(+2);
            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 30, PADDLE_Y_START, 30, 8))) {
                getBall().setYDir(-getBall().getYDir());
                getBall().setXDir(getBall().getXDir() - 1);
            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 90, PADDLE_Y_START, 30, 8))) {
                getBall().setYDir(-getBall().getYDir());
                getBall().setXDir(getBall().getXDir() + 1);
            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 60, PADDLE_Y_START, 30, 8))) {
                getBall().setYDir(-getBall().getYDir());
            }
            //squashes with the wall
            if (getBall().getX() < 0) {
                getBall().setXDir(-getBall().getXDir());
            }
            if (getBall().getY() < 0) {
                getBall().setYDir(-getBall().getYDir());
            }
            if (getBall().getX() > 670) {
                getBall().setXDir(-getBall().getXDir());
            }

            //move the ball
            if(isRunning()) {
                getBall().setX(getBall().getX() + getBall().getXDir());
                getBall().setY(getBall().getY() + getBall().getYDir());
            }

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


}


//        if (playerName.toUpperCase().equals("WARRIS") || playerName.toUpperCase().equals("WARRIS GILL") || playerName.toUpperCase().equals("ATİLLA") || playerName.toUpperCase().equals("ATİLLA GÜRSOY")) {
//            score += 1000;
//            gameBoard.showMessage("What a nice nime ! You unlocked the secret 1,000 point bonus! Have fun!", "1,000 Points");
//        }

