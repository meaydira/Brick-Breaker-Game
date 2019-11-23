package model;


import game_engine.GameConstants;
import game_engine.Map;
import javafx.scene.shape.Circle;
import model.balls.Ball;
import model.bricks.Brick;
import model.bricks.MineBrick;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GameGeometrics implements GameConstants {

    public static boolean ballIntersectsBrick(Brick b, Ball ball) {
        Rectangle2D ballRect = new Rectangle2D.Double(ball.getX(), ball.getY(), BALL_WIDTH, BALL_HEIGHT);
        Rectangle brickRect = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());
        return ballRect.intersects(brickRect);
    }

    public static boolean ballHitsTopOrBottom(Brick b, Ball ball) {
        Rectangle brickRect = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());
        return ball.getY() + 20 <= brickRect.getY() + 2 || ball.getY() >= brickRect.getY() + brickRect.getHeight() - 2;
    }

    public static boolean inExplosionRange(Brick b) {
        Circle explosionRange = new Circle(b.getX(), b.getY(), screenSize.width / 20);
        return explosionRange.contains(b.getX(), b.getY());
    }

    public static boolean checkIntersectSimpleBrickwithAllBricks(Brick brick, Map map) {
        Boolean intersects = false;
        Rectangle paramBrickRect = new Rectangle((int) brick.getX(), (int) brick.getY(), brick.getWidth(), brick.getHeight());
        for (Brick b : map.getBricks()) {
            if (!(b instanceof MineBrick)) {
                Rectangle brickRect = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());
                if (paramBrickRect.intersects(brickRect))
                    return true;
            } else {
                Ellipse2D mineBrickCircle = new Ellipse2D.Double(b.getX(), b.getY(), b.getWidth() / 2, b.getHeight() / 2);
                if (mineBrickCircle.intersects(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight())) {
                    return true;
                }
            }
        }
        return intersects;
    }


}
