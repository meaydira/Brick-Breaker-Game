package model.balls;

import model.GameObject;

import java.awt.*;

public abstract class Ball extends GameObject {
    public Ball(int x_coordianate, int y_coordinate, int width, int height, Color color) {
        super(x_coordianate, y_coordinate, width, height, color);
    }
}
