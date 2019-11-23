package model;


import game_engine.GameConstants;
import javafx.scene.shape.Circle;
import model.balls.Ball;
import model.bricks.Brick;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GameShape implements GameConstants {

    public static boolean ballIntersectsBrick(Brick b, Ball ball){
        Rectangle2D ballRect = new Rectangle2D.Double(ball.getX(), ball.getY(), BALL_WIDTH, BALL_HEIGHT);
        Rectangle brickRect = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());
        return ballRect.intersects(brickRect);
    }
    public static boolean ballHitsTopOrBottom(Brick b, Ball ball){
        Rectangle brickRect = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());
        return ball.getY() + 20 <= brickRect.getY() + 2 || ball.getY() >= brickRect.getY() + brickRect.getHeight() - 2;
    }
    public static boolean inExplosionRange(Brick b){
        Circle explosionRange = new Circle(b.getX(), b.getY(), screenSize.width / 20);
        return explosionRange.contains(b.getX(),b.getY());
    }


}
