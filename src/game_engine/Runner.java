package game_engine;

import javax.swing.*;
import java.awt.*;

public class Runner extends JFrame implements GameConstants{

    private static JFrame frame;
    private static GameController GameApplication;
    private static Container pane;
    private static Dimension dim;

    public static void main(String[] args) {


        GameController application = new GameController();
        application.run();

    }

}
