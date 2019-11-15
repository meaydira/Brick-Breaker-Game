package model.bricks;

import model.GameObject;

import java.awt.*;

public abstract class Brick  extends GameObject {
    private int x_coordinate;
    private int y_coordinate;
    private int lives;
    private int hits;
    private boolean isDestroyed;

    public Brick(int xCoordinate, int yCoordinate, int brick_width, int brick_height, Color brick_color){
        super(xCoordinate, yCoordinate, brick_width,brick_height,brick_color);
        this.lives = 1;
        this.hits = 0;
        this.isDestroyed = false;
    }

    public void hit(){
        this.hits++;
        if(hits == lives){
            this.isDestroyed =true;
        }
    }


    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void destroyBrick(){
        this.isDestroyed = true;
    }


}
