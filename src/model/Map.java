package model;

import model.bricks.Brick;

import java.util.ArrayList;

public class Map {
    private ArrayList<Brick> map;
    public Map(){
        this.map = new ArrayList<Brick>();
    }

    public void addBrick(Brick b) {
        this.map.add(b);
    }
}
