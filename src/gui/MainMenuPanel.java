package gui;


import game_engine.GameConstants;
import game_engine.Redirection;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MainMenuPanel extends JFrame implements GameConstants {

    private Redirection desiredPage;
    JButton playGameButton;
    JButton loginButton;
    JButton registerButton;
    JLabel welcomeLabel;
    JLabel clickLabel;
    JLabel imageContainer;

    public MainMenuPanel() {
        super("Bricking Bad");
        setLayout(null);
        playGameButton = new JButton("Play Game");
        loginButton = new JButton("Login Game");
        registerButton = new JButton("Register Game");
        initializeMenu();

    }

    public void initializeMenu() {
        ImageIcon gameImage = new ImageIcon("b_bad_logo.jpg");
        imageContainer = new JLabel();
        imageContainer.setIcon(gameImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation(frame_x, frame_y);
        setResizable(false);
        pack();

        imageContainer.setBounds(WINDOW_WIDTH / 2 - 150, 150, 300, 200);
        playGameButton.setBounds(WINDOW_WIDTH / 2 - 250, 400, 150, 80);
        loginButton.setBounds(WINDOW_WIDTH / 2 - 70, 400, 150, 80);
        registerButton.setBounds(WINDOW_WIDTH / 2 + 100, 400, 150, 80);
        welcomeLabel = new JLabel("Welcome to Bricking Bad");
        clickLabel = new JLabel("Login Or Register To Save Score");
        welcomeLabel.setBounds(WINDOW_WIDTH / 2 - 150, 100, 300, 40);
        clickLabel.setBounds(WINDOW_WIDTH / 2 - 145, 350, 300, 40);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        clickLabel.setHorizontalAlignment(JLabel.CENTER);
        addComponents();
        addListeners();
        setVisible(true);

        synchronized (playGameButton) {
            try {
                playGameButton.wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }

    public void redirectPage(Redirection rd) {
        synchronized (playGameButton) {
            playGameButton.notify();
        }
        this.desiredPage = rd;
    }

    public Redirection getDesiredPage() {
        return this.desiredPage;
    }

    public void addComponents() {
        add(welcomeLabel);
        add(clickLabel);
        add(playGameButton);
        add(loginButton);
        add(registerButton);
        add(imageContainer);


    }
    public void addListeners(){
        playGameButton.addActionListener(new playGameButtonHandler());
        registerButton.addActionListener(new registerGameButtonHandler());
        loginButton.addActionListener(new loginGameButtonHandler());
    }

    private class playGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            redirectPage(Redirection.gamePage);
            setVisible(false);
        }
    }

    private class loginGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            redirectPage(Redirection.loginPage);
            setVisible(false);
        }
    }

    private class registerGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            redirectPage(Redirection.registerPage);
            setVisible(false);
        }
    }
}




