package game_engine;

import gui.BuildingModePanel;
import gui.GamePanel;

import javax.swing.*;

public class Board extends JFrame implements GameConstants {

    private static Board board_instance = null;
    private JButton pauseButton;

    //The board is singleton.
    private Board() {

        //Leave the Constructor empty so that it does not initialize a field during board_instanceect creation.
    }

    public static Board getInstance(GamePanel panel) {
        if (board_instance == null) {
            board_instance = new Board();
            board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            board_instance.setBounds(10, 10, 900, 600);

            board_instance.setTitle("Bricking Bad");
            board_instance.setResizable(false);
            board_instance.setVisible(true);
            board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            board_instance.add(panel);
            return board_instance;

        } else {
            return board_instance;
        }
    }

    public static Board getInstance(BuildingModePanel panel) {
        if (board_instance == null) {
            board_instance = new Board();
            board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            board_instance.setBounds(10, 10, 900, 600);

            board_instance.setTitle("Bricking Bad");
            board_instance.setResizable(false);
            board_instance.setVisible(true);
            board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            board_instance.add(panel);
            return board_instance;

        } else {
            return board_instance;
        }
    }

    public static Board changeToGamingPanel(GamePanel panel){

        board_instance = new Board();
        board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board_instance.setBounds(10, 10, 900, 600);

        board_instance.setTitle("Bricking Bad");
        board_instance.setResizable(false);
        board_instance.setVisible(true);
        board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board_instance.add(panel);
        return board_instance;
    }



}



