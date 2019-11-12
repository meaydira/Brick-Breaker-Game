package factories;

import model.aliens.Alien;

public class AlienFactory {
    private static AlienFactory alien_factory_instance = null;
    private AlienFactory() {
    }

    public static AlienFactory getInstance() {
        if (alien_factory_instance == null) {
            alien_factory_instance = new AlienFactory();
        }
        return alien_factory_instance;
    }
    public Alien produce(String alientype) {
        Alien instance = null;
        try {
            instance = (Alien) Class.forName("model.aliens." + alientype).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }
}