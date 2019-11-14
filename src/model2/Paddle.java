package model2;

public class Paddle {


    private int width;
    private int Xpos;
    private int Ypos;  //may be unneccessary
    private double angle;


    public int getWidth() {
        return width;
    }

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        Xpos = xpos;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void rotatePositive() {
        if (this.angle <= 45)
            this.angle += 5;
    }

    public void rotateNegative() {
        if (this.angle >= -45)
            this.angle -= 5;
    }

    public void moveRight() {
        this.Xpos += 20;
    }

    public void moveLeft() {
        this.Xpos -= 20;
    }

    public Paddle() {
        this.Xpos = 310;
        this.Ypos = 570;
        this.width = 150;
        this.angle = 0;
    }


}
