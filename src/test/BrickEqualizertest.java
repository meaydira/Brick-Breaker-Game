package test;

import factories.Brickfactory;
import model.bricks.Brick;
import model.bricks.MineBrick;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BrickEqualizertest {
    @Test
    public void brickEqualTest() {
        MineBrick brick =new MineBrick(10,10,10,10,Color.white);
        assertEquals("model.bricks.MineBrick",brick.getClass().getName() );
    }



}
