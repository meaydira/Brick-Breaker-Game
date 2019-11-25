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

    private Redirection mainMenuRedirection;
    JButton playGameButton;
    JButton loginButton;
    JButton registerButton;
    JLabel welcomeLabel;
    JLabel clickLabel;
    JLabel imageContainer;
    private static MainMenuPanel mainmenu_instance = null;

    public static MainMenuPanel getInstance() {
        if (mainmenu_instance == null) {
            mainmenu_instance = new MainMenuPanel();
        }
        mainmenu_instance.setTitle("Bricking Bad");
        mainmenu_instance.setLayout(null);
        mainmenu_instance.playGameButton = new JButton("Play Game");
        mainmenu_instance.loginButton = new JButton("Login Game");
        mainmenu_instance.registerButton = new JButton("Register Game");
        mainmenu_instance.initializeMenu();
        return mainmenu_instance;
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
        playGameButton.setBounds(WINDOW_WIDTH / 2 - 255, 400, 150, 55);
        loginButton.setBounds(WINDOW_WIDTH / 2 - 75, 400, 150, 55);
        registerButton.setBounds(WINDOW_WIDTH / 2 + 95, 400, 150, 55);
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
        this.mainMenuRedirection = rd;
    }

    public Redirection getMainMenuRedirection() {
        return this.mainMenuRedirection;
    }

    public void addComponents() {
        add(welcomeLabel);
        add(clickLabel);
        add(playGameButton);
        add(loginButton);
        add(registerButton);
        add(imageContainer);


    }

    public void addListeners() {
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




