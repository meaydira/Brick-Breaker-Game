package model2;

import game_engine.GameConstants;

public class Paddle implements GameConstants {


    private int width;
    private double Xpos;
    private double Ypos;  //may be unnecessary

    private double virtualX;
    private double virtualY;
    public int height = PADDLE_HEIGHT;


    private double angle = 0;


    public int getWidth() {
        return width;
    }

    public double getYpos() {
        return Ypos;
    }

    public double getXpos() {
        return Xpos;
    }

    public void setXpos(double xpos) {
        Xpos = xpos;
    }

    public double getAngle() {
        return angle;
    }

    public void setVirtualXY(double angle) {//sets imaginary X and Y positions for game to interpret for the top line of the paddle
        if (angle <= 0) {
            //  setXpos((int) Xpos-height*Math.sin(Math.toRadians(angle)));
            virtualX=Xpos;
            virtualY=Ypos;
        } else if (angle > 0) {
            setVirtualX( getXpos() + width - width * (Math.cos(Math.toRadians(angle))));
            setVirtualY( getYpos() - width * (Math.sin(Math.toRadians(angle))));
        }


    }

    public void rotatePositive() {
        if (this.angle <= 45) {
            this.angle += 5;
           // System.out.println(angle+" angle positive");
            setVirtualXY(this.angle);
        }


    }

    public void rotateNegative() {
        if (this.angle >= -45) {
            this.angle -= 5;
           // System.out.println(angle+" angle negative");
            setVirtualXY(this.angle);
        }

    }

    public void moveRight() {
        this.Xpos += 20;
        setVirtualXY(this.angle);
    }

    public void moveLeft() {
        this.Xpos -= 20;
        setVirtualXY(this.angle);
    }

    public Paddle() {
        this.Xpos = 310;
        this.Ypos = 510;
        this.width = 150;
        //this.angle = 0;
        virtualX=310;
        virtualY=510;
    }

    public double getVirtualX() {
        return virtualX;
    }

    public void setVirtualX(double virtualX) {
        this.virtualX = virtualX;
    }

    public double getVirtualY() {
        return virtualY;
    }

    public void setVirtualY(double virtualY) {
        this.virtualY = virtualY;
    }


}