package game_engine;

import model.Map;
import model.bricks.Brick;
import model.bricks.SimpleBrick;

import java.awt.*;

public class MapGenerator implements GameConstants
{
    public Map map;
    public int row;
    public int col;


    public MapGenerator (int row, int col)
    {
        map = new Map();
        this.row = row;
        this.col = col;

    }



    public void initializeMap() {
        for(int i = 0; i<row; i++)
        {
            for(int j =0; j<col; j++)
            {
                map.addBrick(new SimpleBrick(j * BRICK_WIDTH + 80, i * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT,this.getColor(i+j)));
            }
        }

        //brickWidth = 540/col;
        //brickHeight = 150/row;
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0; i<row; i++)
        {
            for(int j =0; j<col; j++)
            {

                g.setColor(getColor(Math.floorMod(i+j, 4)));
                g.fillRect(j * BRICK_WIDTH + 80, i * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);


                g.setStroke(new BasicStroke(3));
                g.setColor(Color.black);
                g.drawRect(j * BRICK_WIDTH + 80, i * BRICK_HEIGHT + 50, BRICK_WIDTH, BRICK_HEIGHT);

            }
        }
    }

    public Color getColor(int x){

        switch(x) {
            case 0: return Color.RED;
            case 1: return Color.GREEN;
            case 2: return Color.BLUE;
            default : return Color.YELLOW;
        }
    }

	public boolean setBrickPosition(Brick b,int x, int y)
	{     //TODO: implement setBrickPosition, returns true if the brick's position is successfully changed to x,y
         return false;
	}
}