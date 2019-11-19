package game_engine;

import factories.Brickfactory;
import model.bricks.Brick;
import model.bricks.HalfMetalBrick;
import model.bricks.SimpleBrick;

import java.awt.*;
import java.util.Random;

public class BuildingMode implements Runnable, GameConstants  {

    private Random random= new Random();

    public static final int xPosBrick_lowLimit= (int) (1.5*BRICK_WIDTH);
    public static final int xPosBrick_HighLimit= 500;
    public static final int yPosBrick_lowLimit= WINDOW_HEIGHT/10;
    public static final int yPosBrick_HighLimit= (int) (WINDOW_HEIGHT-(0.4*WINDOW_HEIGHT));

    Map map=null;
    public void generateMap(int numSimpleBrick, int numMineBrick, int numHalfMetalBrick,int WrapperBrick){

        for(int i=0; i<numSimpleBrick;i++) {
            int xPos=xPosBrick_lowLimit+ random.nextInt(xPosBrick_HighLimit-xPosBrick_lowLimit);
            int yPos=yPosBrick_lowLimit+ random.nextInt(yPosBrick_HighLimit-yPosBrick_lowLimit);
            Brick simpleBrick= Brickfactory.getInstance().produce("SimpleBrick",xPos,yPos,BRICK_WIDTH,BRICK_HEIGHT, Color.white);
            if(!( map==null)) {
                if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(simpleBrick,map))){
                    map.addBrick(simpleBrick);
                }
            }else{
                map.addBrick(simpleBrick);
            }
        }
    }


    @Override
    public void run() {

    }


}
