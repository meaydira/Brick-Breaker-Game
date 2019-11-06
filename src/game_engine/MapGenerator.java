package game_engine;

import model.Map;
import model.bricks.Brick;
import model.bricks.SimpleBrick;

import java.awt.*;

public class MapGenerator implements GameConstants
{
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator (int row, int col)
    {
        map = new int[row][col];
        for(int i = 0; i<map.length; i++)
        {
            for(int j =0; j<map[0].length; j++)
            {
                map[i][j] = 1;
            }
        }

        brickWidth = 540/col;
        brickHeight = 150/row;
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0; i<map.length; i++)
        {
            for(int j =0; j<map[0].length; j++)
            {
                if(map[i][j] > 0)
                {
                    g.setColor(getColor(Math.floorMod(i+j, 4)));
                    g.fillRect(j * brickWidth + 70, i * brickHeight + 50, brickWidth, brickHeight);

                    // this is just to show separate brick, game can still run without it
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 70, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public Color getColor(int x){

       return Color.white;
    }

    public void setBrickValue(int value, int row, int col)
    {
        map[row][col] = value;
    }
}