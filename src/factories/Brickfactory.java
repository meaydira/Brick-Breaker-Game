package factories;

import model.bricks.Brick;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    public Brick produce(String bricktype,int a1,int a2,int a3,int a4,Color color) {
        Brick brick_instance = null;
        try {
            Class classname = Class.forName("model.bricks." + bricktype);
            Constructor[] constructors = classname.getConstructors();
            brick_instance = (Brick) constructors[0].newInstance(a1,a2,a3,a4,color);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return brick_instance;
    }
}
