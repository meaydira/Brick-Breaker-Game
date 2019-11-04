package game_engine;

import javax.swing.*;

<<<<<<< HEAD
public class Board extends JFrame {

    private static Board board_instance = null;

    //The board is singleton.
    public Board() {
=======
public class Board extends JPanel implements GameConstants{

    private static Board board_instance = null;


    //The board is singleton.
    public Board() {
        super.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
>>>>>>> first-iteration
        //Leave the Constructor empty so that it does not initialize a field during board_instanceect creation.
    }
    public static Board getInstance() {
        if (board_instance == null) {
            board_instance = new Board();
<<<<<<< HEAD
=======

           /* super.setSize(width, height);
>>>>>>> first-iteration
            board_instance.setBounds(30, 30, 900, 700);
            board_instance.setTitle("Bricking Bad");
            board_instance.setResizable(false);
            board_instance.setVisible(true);
<<<<<<< HEAD
            board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
            board_instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
>>>>>>> first-iteration
            return board_instance;
        }
        else {
            return board_instance;
        }
    }
<<<<<<< HEAD
=======


    public String askInput(String message, String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public void showMessage(String message, String title){
        JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }



>>>>>>> first-iteration
}
