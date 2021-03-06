package gui;

import game_engine.GameConstants;
import game_engine.Redirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JFrame implements GameConstants {

    private Redirection desiredPage = Redirection.registerPage;
    JButton registerButton;
    JButton backButton;
    JLabel welcomeLabel;
    JLabel clickLabel;
    JLabel imageContainer;
    JLabel usernameLabel;
    JLabel passwordLabel1;
    JLabel passwordLabel2;
    JTextField usernameField;
    JPasswordField passwordField1;
    JPasswordField passwordField2;
    private String username;
    private String password;

    private static RegisterPanel registerpanel_instance = null;


    public static RegisterPanel getInstance() {
        if (registerpanel_instance == null) {
            registerpanel_instance = new RegisterPanel();
        }
        registerpanel_instance.setTitle("Bricking Bad");
        registerpanel_instance.setLayout(null);
        registerpanel_instance.initializePanel();
        return registerpanel_instance;

    }


    public void initializePanel() {
        registerButton = new JButton("Register Game");
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
        backButton.setBounds(WINDOW_WIDTH / 2 - 150, 500, 150, 55);
        registerButton.setBounds(WINDOW_WIDTH / 2 + 5, 500, 150, 55);
        welcomeLabel = new JLabel("Register Page");
        usernameLabel = new JLabel("Username: ");
        passwordLabel1 = new JLabel("Password: ");
        passwordLabel2 = new JLabel("Re-enter Pass: ");
        usernameField = new JTextField(10);
        passwordField1 = new JPasswordField(10);
        passwordField2 = new JPasswordField(10);


        welcomeLabel.setBounds(WINDOW_WIDTH / 2 - 150, 100, 300, 40);
        usernameLabel.setBounds(WINDOW_WIDTH / 2 - 120, 380, 200, 30);
        passwordLabel1.setBounds(WINDOW_WIDTH / 2 - 120, 420, 200, 30);
        passwordLabel2.setBounds(WINDOW_WIDTH / 2 - 120, 460, 200, 30);

        usernameField.setBounds(WINDOW_WIDTH / 2, 380, 120, 30);
        passwordField1.setBounds(WINDOW_WIDTH / 2, 420, 120, 30);
        passwordField2.setBounds(WINDOW_WIDTH / 2, 460, 120, 30);

        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        addComponents();
        addListeners();
        setVisible(true);

        synchronized (registerButton) {
            try {
                registerButton.wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }


    public void addComponents() {
        add(welcomeLabel);
        add(registerButton);
        add(backButton);
        add(imageContainer);
        add(usernameLabel);
        add(passwordLabel1);
        add(passwordLabel2);
        add(usernameField);
        add(passwordField1);
        add(passwordField2);

    }

    public void addListeners() {
        registerButton.addActionListener(new registerGameButtonHandler());
        backButton.addActionListener(new exitButtonHandler());
    }

    private class registerGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            username = usernameField.getText();
            String password1 = passwordField1.getText();
            String password2 = passwordField2.getText();
            if (!password1.equals(password2)) {
                JOptionPane.showMessageDialog(null, "My Goodness, you entered unmatching passwords!");
                passwordField1.setText("");
                passwordField2.setText("");

            } else {
                password = password1;
                setVisible(false);
                removeData();
                releaseLock();
            }
            desiredPage = Redirection.gamePage;
        }


    }

    private void releaseLock() {
        synchronized (registerButton) {
            registerButton.notify();
        }
    }

    private class exitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            desiredPage = Redirection.mainPage;
            removeData();
            setVisible(false);
            releaseLock();
        }
    }

    private void removeData() {
        usernameField.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
        remove(usernameField);
        remove(passwordField1);
        remove(passwordField2);
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