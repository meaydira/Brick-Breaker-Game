package game_engine;

import database.GameState;
import model.GameGeometrics;
import model.Paddle;
import model.balls.Ball;
import model.bricks.Brick;

import java.io.IOException;

public class Game implements Runnable, GameConstants {

    private Player player;
    private int totalBricks = 0;
    private Ball ball;

    private Paddle paddle;
    private GameStatus status;

    public void setRunning(boolean running) {
        this.running = running;
    }

    private boolean running = false;
    private boolean gamePaused = false;
    private boolean gameStarted = false;

    public boolean isGamePaused() {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }


    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }


    private long verticalDirectionChangeLock = 0;
    private long horizontalDirectionChangeLock = 0;
    private long hitLock = 0;
    private long Lock;
    private Map initialMap;
    private Map map;
    SaveLoadManager SLM = SaveLoadManager.getInstance();

    private int score = 0, lives = MAX_LIVES, bricksLeft = MAX_BRICKS, waitTime = 10;

    public Game(Player player, Map passedMap) {
        this.player = player;
        ball = new Ball();
        paddle = new Paddle();
        this.map = passedMap;
        this.initialMap = passedMap;
        setTotalBricks(this.map.getBricks().size());
        hitLock = System.currentTimeMillis();
    }

    public boolean gameIsOver() {
        return (isGameStarted() && getStatus() == GameStatus.Lost);
    }

    public void lostGame(){
        setGameStarted(false);
    }

    public void restartGame(){
        status = GameStatus.Undecided;
        getBall().setX(385);
        getBall().setY(519 - 30);

        getBall().setXDir(-1);
        getBall().setYDir(-2);

        getPaddle().setXpos(310);
        setScore(0);
        map = initialMap;
        setTotalBricks(initialMap.getBricks().size());
        setGameStarted(true);
        setRunning(true);
    }


    public void runPhysics() {

        //If the innner loop needs to break due to collusion, it will break to this point
        outher_escape:
        for (Brick b : map.getBricks()) {

            if (!b.isDestroyed() && GameGeometrics.ballIntersectsBrick(b, ball)) {

                if (System.currentTimeMillis() - hitLock > 100) {
                    b.hit();
                    setScore(getScore() + 5);
                    hitLock = System.currentTimeMillis();
                }
                if (b.isDestroyed()) {
                    totalBricks--;
                }
                // when ball hits top or bottom of brick
                if (GameGeometrics.ballHitsTopOrBottom(b, getBall())) {
                    if (System.currentTimeMillis() > verticalDirectionChangeLock + 50)  //This lock prevent the ball from oscillating
                    {
                        getBall().setYDir(-getBall().getYDir());
                        verticalDirectionChangeLock = System.currentTimeMillis();
                        if (b.getClass().getName() == "model.bricks.MineBrick") {
                            for (Brick brick_to_explode : map.getBricks()) {
                                if (!brick_to_explode.isDestroyed() && GameGeometrics.inExplosionRange(b, brick_to_explode)) {
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

    public GameStatus getStatus() {
        return status;
    }

    public void moveRight() {
        //running = true;
        if (!isGamePaused()) {
            getPaddle().moveRight();
            if (!isRunning() && !isGameStarted()) {
                getBall().setX(getPaddle().getXpos() + getPaddle().getWidth() / 2 - BALL_WIDTH / 2);
            }
        }
    }

    public void moveLeft() {
        //running = true;
        if (!isGamePaused()) {
            getPaddle().moveLeft();
            if (!isRunning() && !isGameStarted()) {
                getBall().setX(getPaddle().getXpos() + getPaddle().getWidth() / 2 - BALL_WIDTH / 2);
            }
        }
        // getBall().setX(getBall().getX()-20);
    }

    public void throwBall() {
        if (gameStarted == false) {
            setGameStarted(true);
            running = true;
        }
    }


    public void changePaddleAnglePositively() {
        if (!isGamePaused() && isRunning() && isGameStarted()) {
            getPaddle().rotatePositive();

        }

    }

    public void changePaddleAngleNegatively() {
        if (!isGamePaused() && isRunning() && isGameStarted()) {
            getPaddle().rotateNegative();

        }
    }

    public void switchMode() {
        running = !running;
        if (!isRunning()) {
            setGamePaused(true);
        } else setGamePaused(false);
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

    private void collisionBallPaddle() {
        //squashes with the paddle
        if (getPaddle().getAngle() < 0) {
            if (GameGeometrics.checkPaddleLineIntersectsBall((getBall().getX()), (getBall().getY()),
                    getPaddle().getVirtualX(),
                    getPaddle().getVirtualY(),
                    getPaddle().getVirtualX() + (getPaddle().getWidth()) * (Math.cos(Math.toRadians(-getPaddle().getAngle()))),
                    getPaddle().getVirtualY() - (getPaddle().getWidth()) * (Math.sin(Math.toRadians(-getPaddle().getAngle()))))) {
                if (System.currentTimeMillis() > Lock + 100) {
                    getBall().setAngle((180 - 2 * getPaddle().getAngle() - getBall().getAngle()));
                    getBall().setYDirSpecial(-Math.abs(Math.sin(Math.toRadians(getBall().getAngle())) * getBall().getVectorLength()));
                    getBall().setXDirSpecial(Math.cos(Math.toRadians(getBall().getAngle())) * getBall().getVectorLength());
                    getBall().setAngleByDir(getBall().getXDir(), getBall().getYDir());
                    Lock = System.currentTimeMillis();
                }
            }
        } else if (getPaddle().getAngle() >= 0) {
            if (GameGeometrics.checkPaddleLineIntersectsBall((getBall().getX()), (getBall().getY()),

                    getPaddle().getXpos() + getPaddle().getWidth() - (getPaddle().getWidth()) * (Math.cos(Math.toRadians(getPaddle().getAngle()))),
                    getPaddle().getYpos() - (getPaddle().getWidth()) * (Math.sin(Math.toRadians(getPaddle().getAngle()))),
                    getPaddle().getXpos() + (getPaddle().getWidth()),
                    getPaddle().getYpos())) {
                if (System.currentTimeMillis() > Lock + 100) {
                    getBall().setAngle((360 - 2 * getPaddle().getAngle() - getBall().getAngle()));
                    getBall().setYDirSpecial(-Math.abs(Math.sin(Math.toRadians(getBall().getAngle())) * getBall().getVectorLength()));
                    getBall().setXDirSpecial(Math.cos(Math.toRadians(getBall().getAngle())) * getBall().getVectorLength());
                    getBall().setAngleByDir(getBall().getXDir(), getBall().getYDir());
                    Lock = System.currentTimeMillis();
                }
            }
        }

    }

    private void collisionBallWall() {
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

    public void saveCurrent() {
        if (running == false) {
            SLM.saveGame(this);
            System.out.println("Game Savec");
        }

    }

    public void loadCurrent() throws ClassNotFoundException, IOException {
        if (running == false) {
            GameState Load = SLM.loadGame(player);
            this.setScore(Load.getScore());
            this.paddle = Load.getPaddleState();
            this.ball = Load.getBallState();
            this.map = Load.getMapState();
            this.lives = Load.getLives();
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

            if (isRunning()) {
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

