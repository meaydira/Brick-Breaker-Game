package model2;

public class Paddle {


    private int width;
    private int Xpos;
    private int Ypos;  //may be unneccessary
    private int angle;


    public int getWidth() {
        return width;
    }

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        Xpos = xpos;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
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
