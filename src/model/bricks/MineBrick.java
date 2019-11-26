package model.bricks;

import java.awt.*;
import java.io.Serializable;

public class MineBrick extends Brick implements Serializable{
    private static final long serialVersionUID = 4L;
    public MineBrick(int xCoordinate, int yCoordinate, int brick_width, int brick_height, Color brick_color) {
        super(xCoordinate, yCoordinate, brick_width, brick_height, brick_color);
        this.setLives(1);
    }
}
