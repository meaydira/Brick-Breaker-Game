package game_engine;

import model.bricks.SimpleBrick;

import java.awt.*;

public class MapGenerator implements GameConstants
{
    private int col;
    private int row;



    public MapGenerator ()
    {

    }
    public Map generateMap(int row, int col){

        this.col = col;
        this.row = row;

        int brickWidth = 540/col;
        int brickHeight = 150/row;
        Map  map= new Map();
        for(int i = 0; i<row; i++)
        {
            for(int j =0; j< col; j++)
            {
                int brickX = j * (brickWidth+10) + 20;
                int brickY = i * (brickHeight+10) + 50;
                map.addBrick(new SimpleBrick(brickX,brickY, brickWidth,brickHeight,getColor(Math.floorMod(i+j, 4))));
            }
        }
        return map;
    }

    public void draw(Graphics2D g)
    {

    }

    public Color getColor(int x){

        switch(x) {
            case 0: return Color.RED;
            case 1: return Color.GREEN;
            case 2: return Color.BLUE;
            default : return Color.YELLOW;
        }
    }


    }
