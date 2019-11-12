package game_engine;

import java.awt.*;
import java.awt.Toolkit;

public interface GameConstants {
    //Window Size

    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WINDOW_HEIGHT = screenSize.height * 2 / 3;
    public static final int WINDOW_WIDTH = screenSize.width * 1 / 3;
    public static final int frame_x = (screenSize.width - WINDOW_HEIGHT) / 4;
    public static final int frame_y = (screenSize.width - WINDOW_HEIGHT) / 4;


    //Lives
    public static final int MAX_LIVES = 5;
    public static final int MIN_LIVES = 0;

    //Ball
    public static final int BALL_WIDTH = 20;
    public static final int BALL_HEIGHT = 20;
    public static final int BALL_RIGHT_BOUND = 490;

    public static final int BALL_X_START = 120;
    public static final int BALL_Y_START = 350;


    public static final int BALL_X_DIRECTION = -1;
    public static final int BALL_Y_DIRECTION = -2;
    public static final Color BALL_COLOR = Color.yellow;


    //Paddle
    public static final int PADDLE_HEIGHT = 20;
    public static final int PADDLE_RIGHT_BOUND = 430;
    public static final int PADDLE_X_START = 225;
    public static final int PADDLE_Y_START = 550;
    public static final int PADDLE_MIN = 35;
    public static final int PADDLE_MAX = 140;

    //Bricks
    public static final int BRICK_WIDTH = 50;
    public static final int BRICK_HEIGHT = 25;
    public static final int MAX_BRICKS = 50;
    public static final int NO_BRICKS = 0;


}

