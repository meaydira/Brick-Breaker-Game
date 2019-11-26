package test;

import factories.Brickfactory;
import model.bricks.Brick;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FactoryTest {
    @Test
    public void simpleFactoryTest() {
        Brickfactory brickfactory = Brickfactory.getInstance();
        Brick testBrick = brickfactory.produce("SimpleBrick", 10, 10, 10, 10, Color.white);
        assertNotEquals(null, testBrick);
    }
    @Test
    public void halfMetalBrickfactoryTest() {
        Brickfactory brickfactory = Brickfactory.getInstance();
        Brick testBrick = brickfactory.produce("HalfMetalBrick", 10, 10, 10, 10, Color.white);
        assertEquals("model.bricks.HalfMetalBrick", testBrick.getClass().getName());
    }
}
