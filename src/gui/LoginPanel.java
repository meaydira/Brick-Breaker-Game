package gui;

import game_engine.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JFrame implements GameConstants {

    JButton loginButton;
    JButton exitButton;
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

    public static LoginPanel getInstance(){
        if(loginpanel_instance == null){
            loginpanel_instance = new LoginPanel();
            loginpanel_instance.setTitle("Bricking Bad");
            loginpanel_instance.setLayout(null);
            loginpanel_instance.initializePanel();
            return loginpanel_instance;
        }else{
            return loginpanel_instance;
        }

    }

    public void initializePanel() {
        loginButton = new JButton("Login Game");
      //  exitButton = new JButton("Return Main Menu");
        ImageIcon gameImage = new ImageIcon("b_bad_logo.jpg");
        imageContainer = new JLabel();
        imageContainer.setIcon(gameImage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocation(frame_x, frame_y);
        setResizable(false);
        pack();

        imageContainer.setBounds(WINDOW_WIDTH / 2 - 150, 150, 300, 200);
        loginButton.setBounds(WINDOW_WIDTH / 2 - 75, 500, 150, 55);
  //      exitButton.setBounds(WINDOW_WIDTH / 2 + 50, 500, 100, 55);
        welcomeLabel = new JLabel("Login Page");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        usernameField= new JTextField( 10 );
        passwordField= new JPasswordField( 10 );


        welcomeLabel.setBounds(WINDOW_WIDTH / 2 - 150, 100, 300, 40);
        usernameLabel.setBounds(WINDOW_WIDTH / 2 - 120, 380, 200, 30);
        passwordLabel.setBounds(WINDOW_WIDTH / 2 - 120, 420, 200, 30);

        usernameField.setBounds(WINDOW_WIDTH / 2 , 380, 120, 30);
        passwordField.setBounds(WINDOW_WIDTH / 2 , 420, 120, 30);

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
        //add(exitButton);
        add(imageContainer);
        add(usernameLabel);
        add(passwordLabel);
        add(usernameField);
        add(passwordField);

    }
    public void addListeners(){
        loginButton.addActionListener(new loginGameButtonHandler());
//        exitButton.addActionListener(new exitButtonHandler());
    }

    private class loginGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
           username = usernameField.getText();
           password = passwordField.getText();

            releaseLock();
            setVisible(false);
        }
    }

  /*  private class exitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            releaseLock();

            setVisible(false);
        }
    }*/
    private void releaseLock(){
        synchronized (loginButton) {
            loginButton.notify();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
