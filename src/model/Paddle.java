package model;

import game_engine.GameConstants;

import java.awt.*;



public class Paddle extends GameObject implements GameConstants{
    private int speed;
    public Paddle(int x_coordianate, int y_coordinate, int width, int height, Color color) {
        super(x_coordianate, y_coordinate, width, height, color);
    }

    //Draws the paddle
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x_coordinate, y_coordinate, width, height);
    }

    //Resets paddle's position
    public void reset() {
        this.setX(PADDLE_X_START);
        this.setY(PADDLE_Y_START);
    }

    // checks for a collusion between paddle and ball
    public boolean hitBall(int ballX, int ballY) {
        if ((ballX >= x_coordinate) && (ballX <= x_coordinate + width) && ((ballY >= y_coordinate) && (ballY <= y_coordinate + height))) {
            return true;
        }
        return false;
    }

    //checks for a collusion between paddle and a powerup
    public boolean caughtItem() {
        //TODO: implement caughtItem ? returns true if paddle intersects with a powerup
        return false;
    }
}
