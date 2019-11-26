package model.bricks;

import model.GameObject;

import java.awt.*;
import java.io.Serializable;

public abstract class Brick  extends GameObject implements Serializable{
    private int x_coordinate;
    private int y_coordinate;
    private int lives;
    private int hits;

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    private boolean isDestroyed;
    private static final long serialVersionUID = 2L;
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
    public void resetHit(){
        this.hits = 0;
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
