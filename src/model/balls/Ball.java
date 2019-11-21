package model.balls;
import game_engine.GameConstants;
import model.GameObject;

import java.awt.*;

public class Ball extends GameObject implements GameConstants{

    private double xDir = BALL_X_DIRECTION, yDir = BALL_Y_DIRECTION;

    public double getVectorLength() {
        return vectorLength;
    }

    private double vectorLength=Math.sqrt(xDir*xDir+yDir*yDir);

    public void setAngle(double angle) {
        this.angle = angle;

       // System.out.println("angle changed to: "+angle);
    }

    private double angle=Math.toDegrees(Math.atan( - (yDir/xDir)));

    public Ball() {
        super(BALL_X_START, BALL_Y_START, BALL_WIDTH, BALL_HEIGHT, BALL_COLOR);
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
        vectorLength=Math.sqrt(xDir*xDir+yDir*yDir);
    }

    //Mutator methods
    public void setXDir(double xDir) {
        this.xDir = xDir;
        setAngle(Math.toDegrees(Math.atan((double) -(yDir/xDir))));

    }

    public void setYDir(double yDir) {
        this.yDir = yDir;
        setAngle(Math.toDegrees(Math.atan((double) -(yDir/xDir))));

    }

    public void setXDirSpecial(double xDir) {
        this.xDir = xDir;


    }
    public void setYDirSpecial(double yDir) {
        this.yDir = yDir;


    }


    public void setX(int xCoordinate){
        super.x_coordinate = xCoordinate;
    }
    public void setY(int yCoordinate){
        super.y_coordinate = yCoordinate;
    }

    //Accessor methods
    public double getXDir() {
        return xDir;
    }

    public double getYDir() {
        return yDir;
    }

    public double getX(){
        return super.x_coordinate;
    }
    public double getY(){
        return super.y_coordinate;
    }

    public double getAngle(){
        return this.angle;
    }
    public void setDirByAngle(double angle){
        this.angle=angle;
        xDir=vectorLength*Math.cos(Math.toRadians(angle));
        yDir=- vectorLength*Math.sin(Math.toRadians(angle));

    }
    public void setAngleByDir(double xx,double yy){
        setAngle(Math.toDegrees(Math.atan((double) -yy/xx)));
    }
}
