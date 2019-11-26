package game_engine;

import factories.Brickfactory;
import model.bricks.SimpleBrick;

import java.awt.*;

public class MapGenerator implements GameConstants {
    private int col;
    private int row;
    private Brickfactory brick_factory;


    public MapGenerator() {
        brick_factory = Brickfactory.getInstance();
    }

    public Map generateMap(int row, int col) {

        this.col = col;
        this.row = row;

        int brickWidth = 540 / col;
        int brickHeight = 150 / row;
        Map map = new Map();
        for (int i = 0; i < row; i++) {
            String bricktype = getBrick(i);
            for (int j = 0; j < col; j++) {
                int brickX = j * (brickWidth + 10) + 20;
                int brickY = i * (brickHeight + 10) + 50;
                map.addBrick(brick_factory.produce(bricktype, brickX, brickY, brickWidth, brickHeight, getColor(bricktype)));
            }
        }
        return map;
    }

    public String getBrick(int i) {
        if (i == 2) {
            return "MineBrick";
        } else if (i == 5) {
            return "HalfMetalBrick";
        } else {
            return "SimpleBrick";
        }

    }

    public Color getColor(String bricktype) {

        switch (bricktype) {
            case "SimpleBrick":
                return Color.white;
            case "HalfMetalBrick":
                return Color.gray;
            case "MineBrick":
                return Color.red;
            case "WrapperBrick":
                return Color.blue;
            default:
                return Color.yellow;
        }
    }


}
