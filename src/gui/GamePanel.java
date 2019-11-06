package gui;

import game_engine.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JFrame implements GameConstants {

    JLabel messageLabel;
    JLabel imageContainer;
    JButton exitButton;
    private static GamePanel game_instance = null;


    public static GamePanel getInstance(){
        if(game_instance == null){
            game_instance = new GamePanel();
            game_instance.setTitle("Bricking Bad");
            game_instance.setLayout(null);
            game_instance.initializePanel();
            return game_instance;
        }else{
            return game_instance;
        }

    }

    public void initializePanel()  {
        ImageIcon gameImage = new ImageIcon("b_bad_logo.jpg");
        imageContainer = new JLabel();
        exitButton = new JButton("Exit");
        imageContainer.setIcon(gameImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation(frame_x, frame_y);
        setResizable(false);
        pack();

        messageLabel = new JLabel("Authentication Successful");
        messageLabel.setBounds(WINDOW_WIDTH / 2 - 150, 400, 300, 40);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageContainer.setBounds(WINDOW_WIDTH / 2 - 150, 150, 300, 200);
        exitButton.setBounds(WINDOW_WIDTH / 2 - 75, 500, 150, 50);
        addComponents();
        exitButton.addActionListener(new exitGameHandller());
        setVisible(true);
        synchronized (exitButton){
            try{
                exitButton.wait();
            }catch(InterruptedException e){
                System.out.println("Interruped");
            }
        }
    }

    public void addComponents() {
        add(messageLabel);
        add(imageContainer);
        add(exitButton);
    }
    private class exitGameHandller implements ActionListener {
        public void actionPerformed(ActionEvent event) {
           // redirectPage(Redirection.registerPage);
            setVisible(false);
        }
    }

}
