package gui;

import game_engine.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorPanel extends JFrame implements GameConstants {

    JLabel errorLabel;
    JLabel imageContainer;
    JButton exitButton;
    private static ErrorPanel errorpanel_instance = null;


    public static ErrorPanel getInstance(){
        if(errorpanel_instance == null){
            errorpanel_instance = new ErrorPanel();
            errorpanel_instance.setTitle("Bricking Bad");
            errorpanel_instance.setLayout(null);
            errorpanel_instance.initializePanel();
            return errorpanel_instance;
        }else{
            return errorpanel_instance;
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

        errorLabel = new JLabel("Authentication Failed");
        errorLabel.setBounds(WINDOW_WIDTH / 2 - 150, 400, 300, 40);
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
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
        add(errorLabel);
        add(imageContainer);
        add(exitButton);
    }
    private class exitGameHandller implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            synchronized (exitButton){
                exitButton.notify();
            }
            setVisible(false);
        }
    }

}
