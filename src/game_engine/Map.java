package game_engine;

import model.bricks.Brick;

import java.util.ArrayList;

public class Map {

    ArrayList<Brick> bricks;


    public Map() {
        this.bricks = new ArrayList<Brick>();
    }




    public void SetBrickPosition(){
        //TODO: implement SetBrickPosition
    }

    public int totalBricks(){
        return bricks.size();
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }





    public void addBrick(Brick b){
        bricks.add(b);
    }
}
