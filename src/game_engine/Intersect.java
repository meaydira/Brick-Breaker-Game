package game_engine;

//import javafx.scene.shape.Circle;
import model.bricks.Brick;
import model.bricks.MineBrick;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Intersect {


    public static boolean checkIntersectSimpleBrickwithAllBricks(Brick brick,Map map){
        Boolean intersects= false;
        Rectangle paramBrickRect= new Rectangle((int) brick.getX(), (int) brick.getY(), brick.getWidth(), brick.getHeight());
        for (Brick b : map.getBricks()) {


                if (!(b instanceof MineBrick)) {
                    Rectangle brickRect = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());
                    if(paramBrickRect.intersects(brickRect))
                        return true;
                }else{
                    Ellipse2D mineBrickCircle= new Ellipse2D.Double(b.getX(),b.getY(),b.getWidth()/2,b.getHeight()/2);
                    if(mineBrickCircle.intersects(brick.getX(),brick.getY(), brick.getWidth(),brick.getHeight())){
                        return true;
                    }
                }


        }
        return intersects;
    }
}
