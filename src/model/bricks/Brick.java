package model.bricks;

import model.GameObject;

import java.awt.*;

public abstract class Brick  extends GameObject {
    private int x_coordinate;
    private int y_coordinate;
    boolean isVisible;
    private int lives;
    private int hits;
    private boolean isDestroyed;

    public Brick(int xCoordinate, int yCoordinate, int brick_width, int brick_height, Color brick_color){
        super(xCoordinate, yCoordinate, brick_width,brick_height,brick_color);
        this.setLives(lives);
        this.hits = 0;
        this.setVisible(true);

    }


    public void draw(Graphics g) {
        if (isVisible) {
            g.setColor(color);
            g.fillRect(x_coordinate, y_coordinate, width, height);
        }
    }
    //TODO : We need to implement an isDestroyed boolean.

    public void hasBeenHit(){

        this.hits++;
        if(hits == lives){
            this.setVisible(false);
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getHits() {
        return this.hits;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public void setVisible(boolean v){
        this.isVisible = v;
    }

    public boolean getIsVisible(boolean v){
        return this.isVisible;
    }


}
