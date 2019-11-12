package model2;

public class Paddle {


    private int width;
    private int speed;
    private int Xpos;
    private int Ypos;  //may be unneccessary

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) { this.width = width; }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        Xpos = xpos;
    }

    public int getYpos() {
        return Ypos;
    }

    public void setYpos(int ypos) {
        Ypos = ypos;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
    public void moveRight(){
        this.Xpos+=20;
    }
    public void moveLeft(){
        this.Xpos-=20;
    }

    private int angle;

    public Paddle(){
        this.Xpos = 310;
        this.Ypos = 570;
        this.width = 150;
        this.angle = 0;
    }


}
