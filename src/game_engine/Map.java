package game_engine;

import model.bricks.Brick;

import java.io.Serializable;
import java.util.ArrayList;

public class Map implements Serializable,Cloneable {

    private ArrayList<Brick> bricks;

    private static final long serialVersionUID = 7L;
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



    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void addBrick(Brick b){
        bricks.add(b);
    }
}
