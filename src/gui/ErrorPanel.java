package gui;

import game_engine.GameConstants;
import game_engine.Redirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorPanel extends JFrame implements GameConstants {

    JLabel welcomeLabel;
    JLabel imageContainer;
    JButton exitButton;

    public ErrorPanel() {
        super("Bricking Bad");
        setLayout(null);
        initializeMenu();
    }

    public void initializeMenu()  {
        ImageIcon gameImage = new ImageIcon("b_bad_logo.jpg");
        imageContainer = new JLabel();
        exitButton = new JButton("Exit");
        imageContainer.setIcon(gameImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation(frame_x, frame_y);
        setResizable(false);
        pack();

        welcomeLabel = new JLabel("Authentication Failed");
        welcomeLabel.setBounds(WINDOW_WIDTH / 2 - 150, 400, 300, 40);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        imageContainer.setBounds(WINDOW_WIDTH / 2 - 150, 150, 300, 200);
        exitButton.setBounds(WINDOW_WIDTH / 2 - 75, 500, 150, 80);
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
        add(welcomeLabel);
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
