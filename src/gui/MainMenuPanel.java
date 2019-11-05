package gui;


import game_engine.GameConstants;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainMenuPanel extends JFrame implements GameConstants {
        private boolean gameCanStart = false;
        JButton playGame;
        JButton loginButton;
        JButton registerButton;
        JLabel welcomeLabel;
        JLabel clickLabel;
        JLabel imageContainer;

        public MainMenuPanel() {
        super("Bricking Bad");
        setLayout(null);
        playGame = new JButton("Play Game");
        loginButton = new JButton("Login Game");
        registerButton = new JButton("Register Game");
        initializeMenu();

    }

    public void goToGame(){
        synchronized (playGame) {
            playGame.notify();
        }
        this.gameCanStart = true;
    }
    public boolean getPlayPermission(){
        return this.gameCanStart;
    }
    public void addComponents(){
        add(welcomeLabel);
        add(clickLabel);
        add(playGame);
        add(loginButton);
        add(registerButton);
        add(imageContainer);
        playGame.addActionListener(new ButtonHandler());

    }
    public void initializeMenu(){
        ImageIcon gameImage = new ImageIcon("b_bad_logo.jpg");
        imageContainer = new JLabel();
        imageContainer.setIcon(gameImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation(frame_x, frame_y);
        setResizable(false);
        pack();

        imageContainer.setBounds(WINDOW_WIDTH/2-150,150,300,200);
        playGame.setBounds(WINDOW_WIDTH / 2 - 250, 400, 150, 80);
        loginButton.setBounds(WINDOW_WIDTH / 2 - 70, 400, 150, 80);
        registerButton.setBounds(WINDOW_WIDTH / 2 +  100, 400, 150, 80);
        welcomeLabel = new JLabel("Welcome to Bricking Bad");
        clickLabel = new JLabel("Login Or Register To Save Score");
        welcomeLabel.setBounds(WINDOW_WIDTH / 2 - 150, 100, 300, 40);
        clickLabel.setBounds(WINDOW_WIDTH / 2 - 145, 350, 300, 40);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        clickLabel.setHorizontalAlignment(JLabel.CENTER);
        addComponents();
        setVisible(true);

        synchronized (playGame){
            try{
                playGame.wait();
            }
            catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
                goToGame();
                setVisible(false);
            }
        }
    }



