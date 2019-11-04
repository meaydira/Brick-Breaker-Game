package model.balls;
<<<<<<< HEAD
import model.Direction;

public abstract class Ball {

    private int x_position;
    private int y_position;
    private Direction direction;

    public Ball(int x_position, int y_position) {
        this.x_position = x_position;
        this.y_position = y_position;
    }

    public void bounce(){
        //TODO : Implement bounce method
    }

=======

import game_engine.GameConstants;
import model.GameObject;

import java.awt.*;



public class Ball extends GameObject implements GameConstants{

    private int xDir = 1, yDir = -1;



    public Ball(int x_coordianate, int y_coordinate, int width, int height, Color color) {
        super(x_coordianate, y_coordinate, width, height, color);
    }


    //Draw the ball
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x_coordinate, y_coordinate, width, height);
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


    //Accessor methods
    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }
>>>>>>> first-iteration

}
