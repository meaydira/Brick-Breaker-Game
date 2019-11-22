package game_engine;

import factories.Brickfactory;
import model.balls.Ball;
import model.bricks.Brick;
import model2.Paddle;

import java.awt.*;
import java.util.Random;

public class BuildingMode implements Runnable, GameConstants  {

    private Random random= new Random();

    public static final int xPosBrick_lowLimit= 1;
    public static final int xPosBrick_HighLimit= 670;
    public static final int yPosBrick_lowLimit= 0;
    public static final int yPosBrick_HighLimit= 338;
            //(int) (WINDOW_HEIGHT-(0.4*WINDOW_HEIGHT));
    private int numSimpleBrick=12,  numMineBrick=3,  numHalfMetalBrick=4, numWrapperBrick=0;
    private int waitTime = 10;
    private Ball ball;
    private Paddle paddle;
    private int currentBrick = 1;
    private boolean running = true;

    Map map=null;
    Player player;

    public BuildingMode(Player player) {
        this.player = player;
        map = new Map();
        ball = new Ball();
        paddle = new Paddle();
        System.out.println("Map is generated");
        System.out.println("Map list is " + map.getBricks().toString());
    }

    public void generateMap(int numSimpleBrick, int numMineBrick, int numHalfMetalBrick,int numWrapperBrick){
        this.numSimpleBrick = numSimpleBrick;
        this.numMineBrick = numMineBrick;
        this.numHalfMetalBrick = numHalfMetalBrick;
        generateRandom();}


    public void initializeMap(){
        if(map.getBricks().size() == 0)
        generateRandom();}

        public void generateRandom(){

        for(int i=0; i<numSimpleBrick;i++) {
            int xPos=xPosBrick_lowLimit+ random.nextInt(xPosBrick_HighLimit-xPosBrick_lowLimit);
            int yPos=yPosBrick_lowLimit+ random.nextInt(yPosBrick_HighLimit-yPosBrick_lowLimit);
            Brick simpleBrick= Brickfactory.getInstance().produce("SimpleBrick",xPos,yPos,BRICK_WIDTH,BRICK_HEIGHT, Color.green);
            if(!( map==null)) {
                if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(simpleBrick,map))){
                    map.addBrick(simpleBrick);
                }
            }else{
                map.addBrick(simpleBrick);
            }
        }

        for(int i=0; i<numMineBrick;i++) {
            int xPos=xPosBrick_lowLimit+ random.nextInt(xPosBrick_HighLimit-xPosBrick_lowLimit);
            int yPos=yPosBrick_lowLimit+ random.nextInt(yPosBrick_HighLimit-yPosBrick_lowLimit);
            Brick mineBrick= Brickfactory.getInstance().produce("MineBrick",xPos,yPos,BRICK_WIDTH,BRICK_HEIGHT, Color.red);
            if(!( map==null)) {
                if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(mineBrick,map))){
                    map.addBrick(mineBrick);
                }
            }else{
                map.addBrick(mineBrick);
            }
        }

        for(int i=0; i<numHalfMetalBrick;i++) {
            int xPos=xPosBrick_lowLimit+ random.nextInt(xPosBrick_HighLimit-xPosBrick_lowLimit);
            int yPos=yPosBrick_lowLimit+ random.nextInt(yPosBrick_HighLimit-yPosBrick_lowLimit);
            Brick halfMetalBrick= Brickfactory.getInstance().produce("HalfMetalBrick",xPos,yPos,BRICK_WIDTH,BRICK_HEIGHT, Color.gray);
            if(!( map==null)) {
                if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(halfMetalBrick,map))){
                    map.addBrick(halfMetalBrick);
                }
            }else{
                map.addBrick(halfMetalBrick);
            }
        }

        for(int i=0; i<numWrapperBrick;i++) {
            int xPos=xPosBrick_lowLimit+ random.nextInt(xPosBrick_HighLimit-xPosBrick_lowLimit);
            int yPos=yPosBrick_lowLimit+ random.nextInt(yPosBrick_HighLimit-yPosBrick_lowLimit);
            Brick wrapperBrick= Brickfactory.getInstance().produce("WrapperBrick",xPos,yPos,BRICK_WIDTH,BRICK_HEIGHT, Color.white);
            if(!( map==null)) {
                if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(wrapperBrick,map))){
                    map.addBrick(wrapperBrick);
                }
            }else{
                map.addBrick(wrapperBrick);
            }
        }


    }

    public Map getCurrentMap(){
        return map;
    }

    public Ball getBall() {
        return this.ball;
    }

    public Paddle getPaddle() {
        return this.paddle;
    }

    public void handleClick(int x , int y){
        Point point= new Point(x,y);
        Rectangle brickRect;
        boolean isProcessed = false;

        for (Brick b : map.getBricks()) {
            brickRect = new Rectangle((int) b.getX(),(int) b.getY(), b.getWidth(), b.getHeight());
            if(brickRect.contains(point)){
                if(!b.isDestroyed()){
                    b.setDestroyed(true);
                    isProcessed = true;
                }
            }
        }

        if(isProcessed == false){
            switch (currentBrick){
                case 1:
                    Brick simpleBrick= Brickfactory.getInstance().produce("SimpleBrick",x,y,BRICK_WIDTH,BRICK_HEIGHT, Color.green);
                    if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(simpleBrick,map))){
                        map.addBrick(simpleBrick);
                    }
                    break;

                case 2:
                    Brick halfMetalBrick= Brickfactory.getInstance().produce("HalfMetalBrick",x,y,BRICK_WIDTH,BRICK_HEIGHT, Color.gray);
                    if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(halfMetalBrick,map))){
                        map.addBrick(halfMetalBrick);
                    }
                    break;
                case 3:
                    Brick mineBrick= Brickfactory.getInstance().produce("MineBrick",x,y,BRICK_WIDTH,BRICK_HEIGHT, Color.red);
                    if(!(Intersect.checkIntersectSimpleBrickwithAllBricks(mineBrick,map))){
                        map.addBrick(mineBrick);
                    }
                    break;
            }
        }
    }

      public String getCurrentBrick(){
        if(currentBrick == 1){
            return "Simple Brick";
        }else if(currentBrick == 2){
            return "HalfMetalBrick";
        }else{
            return "MineBrick";
        }
      }

      public void changeBrickType(int type){
        currentBrick = type;
      }

    public void terminate() {
        running = false;
        synchronized (this) {
            this.notify();
        }
    }



    @Override
    public void run() {
        System.out.println("Building mode class is running");
        while (running) {

            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }


}
