package gui;

import game_engine.GameConstants;

import javax.swing.*;

public class Gameboard extends JFrame implements GameConstants {

    private static Gameboard gameboard_instance = null;
    private JButton pauseButton;

    //The board is singleton.
    private Gameboard() {

        //Leave the Constructor empty so that it does not initialize a field during board_instanceect creation.
    }

    public static Gameboard getInstance(GamePanel panel) {
        if (gameboard_instance == null) {
            gameboard_instance = new Gameboard();
            gameboard_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameboard_instance.setBounds(10, 10, 900, 600);

            gameboard_instance.setTitle("Bricking Bad");
            gameboard_instance.setResizable(false);
            gameboard_instance.setVisible(true);
            gameboard_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameboard_instance.add(panel);
            return gameboard_instance;

        } else {
            return gameboard_instance;
        }
    }

    public static Gameboard getInstance(BuildingModePanel panel) {
        if (gameboard_instance == null) {
            gameboard_instance = new Gameboard();
            gameboard_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameboard_instance.setBounds(10, 10, 900, 600);

            gameboard_instance.setTitle("Bricking Bad");
            gameboard_instance.setResizable(false);
            gameboard_instance.setVisible(true);
            gameboard_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameboard_instance.add(panel);
            return gameboard_instance;

        } else {
            return gameboard_instance;
        }
    }

    public static Gameboard changeToGamingPanel(GamePanel panel){

        gameboard_instance = new Gameboard();
        gameboard_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameboard_instance.setBounds(10, 10, 900, 600);

        gameboard_instance.setTitle("Bricking Bad");
        gameboard_instance.setResizable(false);
        gameboard_instance.setVisible(true);
        gameboard_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameboard_instance.add(panel);
        return gameboard_instance;
    }



}



