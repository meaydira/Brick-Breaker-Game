package model.balls;
import game_engine.GameConstants;
import model.GameObject;

import java.awt.*;

public class Ball extends GameObject implements GameConstants{

    private int xDir = BALL_X_DIRECTION, yDir = BALL_Y_DIRECTION;

    public Ball() {
        super(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT, BALL_COLOR);
    }

    //Draw the ball
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(super.x_coordinate, super.y_coordinate, super.width, super.height);
    }

    //Moves the ball
    public void move() {
        x_coordinate += xDir;
        y_coordinate += yDir;
    }

    //Resets the ball to original position at center of screen
    public void reset() {
        x_coordinate = BALL_X_START;
        y_coordinate = BALL_Y_START;
        xDir = 1;
        yDir = -1;
    }

    //Mutator methods
    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }

    public void setX(int xCoordinate){
        super.x_coordinate = xCoordinate;
    }
    public void setY(int yCoordinate){
        super.y_coordinate = yCoordinate;
    }

    //Accessor methods
    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    public int getX(){
        return super.x_coordinate;
    }
    public int getY(){
        return super.y_coordinate;
    }

}
