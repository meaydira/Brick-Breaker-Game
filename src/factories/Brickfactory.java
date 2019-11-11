package factories;

import model.bricks.Brick;

public class Brickfactory {
    private static Brickfactory brick_factory_instance = null;
    private Brickfactory() {
    }
    public static Brickfactory getInstance() {
        if (brick_factory_instance == null) {
            brick_factory_instance = new Brickfactory();
        }
        return brick_factory_instance;
    }
    public Brick produce(String bricktype) {
        Brick brick_instance = null;
        try {
            brick_instance = (Brick) Class.forName("model.bricks." + bricktype).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return brick_instance;
    }
}
