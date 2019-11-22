package game_engine;

import factories.AlienFactory;
import factories.Brickfactory;
import javafx.scene.shape.Circle;
import model.balls.Ball;
import model.bricks.Brick;
import model2.Paddle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Game implements Runnable, GameConstants {

    private int i = 0;
    private String playerName = "John Doe";
    private Player player;
    private int totalBricks = 48;  //TODO: should be initialized by building mode
    private Ball ball;

    private Paddle paddle;
    private GameStatus status;
    private boolean running = false;

    private Brickfactory brickFactory;  //unused ?  //TODO: implement or delete
    private AlienFactory alienFactory;  //these should be  //TODO: implement or delete

    public boolean isBuilding() {
        return false;
    }

    public void setBuilding(boolean building) {
        isBuilding = building;
    }

    private boolean isBuilding=true;
    private long verticalDirectionChangeLock = 0;
    private long horizontalDirectionChangeLock = 0;
    private long hitLock = 0;
    private long Lock;
    private Map map;


    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 10;

    private Board gameBoard;  // TODO: implement or delete

    public Game(Player player) {
        playerName = JOptionPane.showInputDialog("Please enter your name:", "Brick Breaker, Corporate Slaves");
        //if (playerName.toUpperCase().equals("WARRIS") || playerName.toUpperCase().equals("WARRIS GILL") || playerName.toUpperCase().equals("ATİLLA") || playerName.toUpperCase().equals("ATİLLA GÜRSOY")) {
        //score += 1000;
        //gameP.showMessage("What a nice name ! You unlocked the secret 1,000 point bonus! Have fun!", "1,000 Points"); }


        this.player = player;
        ball = new Ball();
        paddle = new Paddle();
        map = new MapGenerator().generateMap(6, 12);
        hitLock = System.currentTimeMillis();


    }


    public Game(Player player, Map map) {
        playerName = JOptionPane.showInputDialog("Please enter your name:", "Brick Breaker, Corporate Slaves");
        //if (playerName.toUpperCase().equals("WARRIS") || playerName.toUpperCase().equals("WARRIS GILL") || playerName.toUpperCase().equals("ATİLLA") || playerName.toUpperCase().equals("ATİLLA GÜRSOY")) {
        //score += 1000;
        //gameP.showMessage("What a nice name ! You unlocked the secret 1,000 point bonus! Have fun!", "1,000 Points"); }


        this.player = player;
        ball = new Ball();
        paddle = new Paddle();
        this.map = map;
        hitLock = System.currentTimeMillis();


    }

    public void reinitialize() {
        if (status == GameStatus.Lost) {
            status = GameStatus.Undecided;
            getBall().setX(120);
            getBall().setY(530);

            getBall().setXDir(-1);
            getBall().setYDir(-2);

            getPaddle().setXpos(310);
            setScore(0);
            setTotalBricks(21);
            map = new MapGenerator().generateMap(6, 12);
        }
        running = true;

    }

    public void runPhysics() {

        //If the innner loop needs to break due to collusion, it will break to this point

        Rectangle2D ballRect;
        Rectangle brickRect;
        outher_escape:
        for (Brick b : map.getBricks()) {
            ballRect = new Rectangle2D.Double(this.ball.getX(), this.ball.getY(), 20, 20);
            brickRect = new Rectangle((int) b.getX(),(int) b.getY(), b.getWidth(), b.getHeight());

            if (!b.isDestroyed() && ballRect.intersects(brickRect)) {

                if (System.currentTimeMillis() - hitLock > 100) {
                    b.hit();
                    setScore(getScore() + 5);
                    hitLock = System.currentTimeMillis();
                }
                if (b.isDestroyed()) {
                    totalBricks--;
                }
                // when ball hits top or bottom of brick
                if (getBall().getY() + 20 <= brickRect.getY() + 2 || getBall().getY() >= brickRect.getY() + brickRect.getHeight() - 2) {
                    if (System.currentTimeMillis() > verticalDirectionChangeLock + 50)  //This lock prevent the ball from oscillating
                    {
                        getBall().setYDir(-getBall().getYDir());
                        verticalDirectionChangeLock = System.currentTimeMillis();
                        if (b.getClass().getName() == "model.bricks.MineBrick") {
                            Circle explosionRange = new Circle(b.getX(), b.getY(), getPaddle().getWidth()/2);
                            for (Brick brick_to_explode : map.getBricks()) {
                                if (!brick_to_explode.isDestroyed() && explosionRange.contains(brick_to_explode.getX(), brick_to_explode.getY())) {
                                    brick_to_explode.destroyBrick();
                                }
                            }
                        }
                    }
                }
                // when ball hit right or left of brick
                else {
                    if (System.currentTimeMillis() > horizontalDirectionChangeLock + 50) //This lock prevent the ball from oscillating
                    {
                        getBall().setXDir(-getBall().getXDir());
                        horizontalDirectionChangeLock = System.currentTimeMillis();
                    }
                }
                break outher_escape;
            }
        }
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalBricks() {
        return totalBricks;
    }

    public void setTotalBricks(int totalBricks) {
        this.totalBricks = totalBricks;
    }

    //Accessor methods
    public double getBallXDir() {
        return this.ball.getXDir();
    }

    public double getBallYDir() {
        return this.ball.getYDir();
    }

    public double getBallX() {
        return ball.getX();
    }

    public double getBallY() {
        return ball.getY();
    }


    public GameStatus getStatus() {
        return status;
    }

    public void moveRight() {
        running = true;
        getPaddle().moveRight();
    }

    public void moveLeft() {
        running = true;
        getPaddle().moveLeft();
    }

    public void changePaddleAnglePositively() {
        getPaddle().rotatePositive();
    }

    public void changePaddleAngleNegatively() {
        getPaddle().rotateNegative();
    }

    public void switchMode() {
        running = false;
    }

    public Map getMap() {
        return this.map;
    }
    public Player getPlayer() {
    	return this.player;
    }
    public int getlives() {
    	return this.lives;
    }

    private void collisionBallPaddle(){
        //squashes with the paddle
        if(getPaddle().getAngle()<0){
            if (new Rectangle2D.Double(  (getBall().getX()), (getBall().getY()), 20, 20).intersectsLine(new Line2D.Double(
                    getPaddle().getVirtualX(),
                    getPaddle().getVirtualY(),
                    getPaddle().getVirtualX()+(getPaddle().getWidth())*(Math.cos(Math.toRadians(-getPaddle().getAngle()))),
                    getPaddle().getVirtualY()-(getPaddle().getWidth())*(Math.sin(Math.toRadians(-getPaddle().getAngle()))))))
            {
                if(System.currentTimeMillis()>Lock + 100) {
//                        System.out.println();
//                        System.out.println("COLLISION NUMBER: "+count++);
//
//                        System.out.println("paddle angle while collision <0 : "+getPaddle().getAngle());
//                        System.out.println("ball input angle "+getBall().getAngle());
                    getBall().setAngle((180- 2 * getPaddle().getAngle() - getBall().getAngle()));
//                        System.out.println("ball angle set to 180-2paddle-ball == "+getBall().getAngle());
                    getBall().setYDirSpecial(-Math.abs(Math.sin(Math.toRadians(getBall().getAngle()))*getBall().getVectorLength()));
                    getBall().setXDirSpecial(Math.cos(Math.toRadians(getBall().getAngle()))*getBall().getVectorLength());
                    getBall().setAngleByDir(getBall().getXDir(),getBall().getYDir());
//                        System.out.println("ball output directions: "+getBall().getXDir()+", "+getBall().getYDir());
//                        System.out.println("ball output angle "+getBall().getAngle());
                    Lock=System.currentTimeMillis();
                }
                //System.out.println("HIIIIT!!! angle negative");

            }
        }else if(getPaddle().getAngle()>=0){
            if( (new Rectangle2D.Double(  (getBall().getX()),  (getBall().getY()), 20, 20))
                    .intersectsLine(new Line2D.Double(
                            getPaddle().getXpos()+getPaddle().getWidth()-(getPaddle().getWidth())*(Math.cos(Math.toRadians(getPaddle().getAngle()))),
                            getPaddle().getYpos()-(getPaddle().getWidth())*(Math.sin(Math.toRadians(getPaddle().getAngle()))),
                            getPaddle().getXpos()+(getPaddle().getWidth()),
                            getPaddle().getYpos()  )))
            {
                if(System.currentTimeMillis()>Lock + 100) {
//                        System.out.println();
//                        System.out.println("COLLISION NUMBER: "+count++);
//                        System.out.println("ball input directions: "+getBall().getXDir()+", "+getBall().getYDir());
//                        System.out.println("paddle angle while collision >=0 : "+getPaddle().getAngle());
//                        System.out.println("ball input angle "+getBall().getAngle());
                    getBall().setAngle((360-2 * getPaddle().getAngle() - getBall().getAngle()));
                    getBall().setYDirSpecial(-Math.abs(Math.sin(Math.toRadians(getBall().getAngle()))*getBall().getVectorLength()));
                    getBall().setXDirSpecial(Math.cos(Math.toRadians(getBall().getAngle()))*getBall().getVectorLength());
                    getBall().setAngleByDir(getBall().getXDir(),getBall().getYDir());
//                        System.out.println("ball angle set to 360-2paddle-ball == "+getBall().getAngle());
//
//                        System.out.println("ball output directions: "+getBall().getXDir()+", "+getBall().getYDir());
//                        System.out.println("ball output angle "+getBall().getAngle());
                    Lock=System.currentTimeMillis();
                    // System.out.println("HIIIIT!!! angle positive");
                }
            }
        }
        //end of squashes with paddle

    }

    private void collisionBallWall(){
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

            collisionBallPaddle();
            collisionBallWall();


            //move the ball

            if (isRunning()) {
//                getBall().setX(getBallX() + getBallXDir());
//                getBall().setY(getBallY() + getBallYDir());
                ball.move();
            }
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }


}

//old squashes with the paddle
//            if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos(), PADDLE_Y_START, 30, 8))) {
//                getBall().setYDir(-getBall().getYDir());
//                getBall().setXDir(-2);
//            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 120, PADDLE_Y_START, 30, 8))) {
//                getBall().setYDir(-getBall().getYDir());
//                getBall().setXDir(+2);
//            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 30, PADDLE_Y_START, 30, 8))) {
//                getBall().setYDir(-getBall().getYDir());
//                getBall().setXDir(getBall().getXDir() - 1);
//            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 90, PADDLE_Y_START, 30, 8))) {
//                getBall().setYDir(-getBall().getYDir());
//                getBall().setXDir(getBall().getXDir() + 1);
//            } else if (new Rectangle(getBall().getX(), getBall().getY(), 20, 20).intersects(new Rectangle(getPaddle().getXpos() + 60, PADDLE_Y_START, 30, 8))) {
//                getBall().setYDir(-getBall().getYDir());
//            }



