package controllers;

import game_engine.Game;
import game_engine.GameStatus;
import gui.NotificationPanel;
import gui.PauseGamePanel;
import model.bricks.Brick;

import java.io.IOException;
import java.util.ArrayList;

public class GameController {
    private Game game;
    private static GameController instance;

    private GameController() {

    }

    public static GameController getInstance(Game newGame) {
        if (instance == null) {
            instance = new GameController();
        }
        instance.game = newGame;
        return instance;
    }

    public boolean isRunning() {
        return game.isRunning();
    }

    public GameStatus getStatus() {
        return game.getStatus();
    }

    public ArrayList<Brick> getBricks() {
        return game.getMap().getBricks();
    }

    public int getScore() {
        return game.getScore();
    }

    public double getPaddleX() {
        return game.getPaddle().getXpos();
    }

    public double getPaddleWidth() {
        return game.getPaddle().getWidth();
    }

    public double getPaddleAngle() {
        return game.getPaddle().getAngle();
    }

    public void changePaddleAngleNegatively() {
        game.changePaddleAngleNegatively();
    }

    public void changePaddleAnglePositively() {
        game.changePaddleAnglePositively();
    }

    public void saveCurrent() {
        game.saveCurrent();
    }

    public void throwBall() {
        game.throwBall();
    }

    public double getBallX() {
        return game.getBall().getX();
    }

    public double getBallY() {
        return game.getBall().getY();
    }

    public void movePaddleLeft() {
        game.moveLeft();
    }

    public void movePaddleRight() {
        game.moveRight();
    }

    public boolean gameIsOver() {
        return game.gameIsOver();
    }
    public boolean isGameStared(){
       return  game.isGameStarted();
    }

    public void lostGame(){
        game.lostGame();
    }

    public void switchMode(){
        game.switchMode();
    }
    public void openPauseMenu(){
        PauseGamePanel panel =PauseGamePanel.getInstance(this);
    }
    public void restartGame(){
        game.restartGame();
    }

    public void loadCurrent() {
        try {
            game.loadCurrent();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void runPhysics() {
        game.runPhysics();
    }

    public void exitGame(){
        System.exit(0);
    }

}
