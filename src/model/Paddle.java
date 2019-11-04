package model;

import java.awt.*;

public class Paddle extends GameObject{

    public Paddle(int paddleXStart, int paddleYStart, int paddleWidth, int paddleHeight, Color paddleColor) {
        super(paddleXStart,paddleYStart,paddleWidth,paddleHeight,paddleColor);

    }

    @Override
    public void draw(Graphics g) {
                g.setColor(super.color);
                g.fillRect(super.x_coordinate, super.y_coordinate, super.width, super.height);
    }
}
