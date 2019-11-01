package model.balls;
import model.Direction;

public abstract class Ball {

    private int x_position;
    private int y_position;
    private Direction direction;

    public Ball(int x_position, int y_position) {
        this.x_position = x_position;
        this.y_position = y_position;
    }

}
