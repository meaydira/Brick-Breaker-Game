package model.bricks;

import java.awt.*;
import java.io.Serializable;

public class HalfMetalBrick extends Brick implements Serializable{
    private static final long serialVersionUID = 3L;
    //TODO: implement HalfMetalBrick
    public HalfMetalBrick(int x_coordinate, int y_coordinate, int brick_width, int brick_height, Color brick_color) {
        super(x_coordinate, y_coordinate, brick_width, brick_height, brick_color);
        this.setLives(2);
    }
}
