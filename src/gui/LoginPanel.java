package gui;

import game_engine.GameConstants;
import game_engine.Redirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginPanel extends JFrame implements GameConstants {

    private Redirection desiredPage = Redirection.loginPage;
    JButton loginButton;
    JButton backButton;
    JLabel welcomeLabel;
    JLabel clickLabel;
    JLabel imageContainer;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    private String username;
    private String password;

    private static LoginPanel loginpanel_instance = null;

    public static LoginPanel getInstance() {
        if (loginpanel_instance == null) {
            loginpanel_instance = new LoginPanel();

        }
        loginpanel_instance.setTitle("Bricking Bad");
        loginpanel_instance.setLayout(null);
        loginpanel_instance.initializePanel();
        return loginpanel_instance;

    }

    public void initializePanel() {
        loginButton = new JButton("Login Game");
        backButton = new JButton("Back");
        ImageIcon gameImage = new ImageIcon("b_bad_logo.jpg");
        imageContainer = new JLabel();
        imageContainer.setIcon(gameImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation(frame_x, frame_y);
        setResizable(false);
        pack();

        imageContainer.setBounds(WINDOW_WIDTH / 2 - 150, 150, 300, 200);
        backButton.setBounds(WINDOW_WIDTH / 2 - 150, 480, 150, 55);
        loginButton.setBounds(WINDOW_WIDTH / 2 + 5, 480, 150, 55);
        welcomeLabel = new JLabel("Login Page");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);


        welcomeLabel.setBounds(WINDOW_WIDTH / 2 - 150, 100, 300, 40);
        usernameLabel.setBounds(WINDOW_WIDTH / 2 - 120, 380, 200, 30);
        passwordLabel.setBounds(WINDOW_WIDTH / 2 - 120, 420, 200, 30);

        usernameField.setBounds(WINDOW_WIDTH / 2, 380, 120, 30);
        passwordField.setBounds(WINDOW_WIDTH / 2, 420, 120, 30);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        addComponents();
        addListeners();
        setVisible(true);
        synchronized (loginButton) {
            try {
                loginButton.wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }


    public void addComponents() {
        add(welcomeLabel);
        add(loginButton);
        add(backButton);
        add(imageContainer);
        add(usernameLabel);
        add(passwordLabel);
        add(usernameField);
        add(passwordField);

    }

    public void addListeners() {
        loginButton.addActionListener(new loginGameButtonHandler());
        backButton.addActionListener(new exitButtonHandler());
    }


    private class loginGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            desiredPage = Redirection.gamePage;
            username = usernameField.getText();
            password = passwordField.getText();
            setVisible(false);
            releaseLock();
        }
    }

    private class exitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            desiredPage = Redirection.mainPage;
            remove(usernameField);
            remove(passwordField);
            setVisible(false);
            releaseLock();
        }
    }


    private void releaseLock() {
        synchronized (loginButton) {
            loginButton.notify();
        }
    }


    public Redirection getDesiredPage() {
        return desiredPage;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
