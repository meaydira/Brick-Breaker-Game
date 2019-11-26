package gui;

import controllers.GameController;
import game_engine.GameConstants;
import model.GameGeometrics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseGamePanel extends JFrame implements GameConstants {
    private static PauseGamePanel instance = null;
    JButton saveButton;
    JButton loadButton;
    JButton resumeButton;
    JButton exitButton;
    JLabel introText;
    GameController gameController;
    private Container container;
    private PauseGamePanel(){

    }
    public static PauseGamePanel getInstance(GameController controller){
        if(instance == null){
            instance = new PauseGamePanel();
            instance.initializePausePanel();
            instance.gameController = controller;
        }else{
            instance.setVisible(true);
        }
        return instance;
    }

    public void initializePausePanel(){
        setPreferredSize(new Dimension(WINDOW_WIDTH/2, WINDOW_HEIGHT/2));
        container = getContentPane();
        setLayout(new GridLayout(5,1,10,5));
        setLocation(frame_x, frame_y);
        setResizable(false);
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        introText = new JLabel("Welcome to Game Menu");
        introText.setHorizontalAlignment(JLabel.CENTER);
        saveButton = new JButton("Save Game");
        saveButton.setPreferredSize(new Dimension(30,20));setPreferredSize(new Dimension(200,100));
        loadButton = new JButton("Load Game");
        loadButton.setPreferredSize(new Dimension(30,20));setPreferredSize(new Dimension(200,100));
        resumeButton = new JButton("Resume Game");
        resumeButton.setPreferredSize(new Dimension(30,20));setPreferredSize(new Dimension(200,100));
        exitButton = new JButton("Exit Game");
        exitButton.setPreferredSize(new Dimension(30,20));setPreferredSize(new Dimension(200,100));
        addComponents();
        setVisible(true);

    }

    private void addComponents() {
        add(introText);
        add(saveButton);
        add(loadButton);
        add(resumeButton);
        add(exitButton);

        exitButton.addActionListener(new exitGameButtonHandler());
        resumeButton.addActionListener(new resumeGameButtonHandler());
    }

    private class loadGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        }
    }
    private class saveGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        }
    }
    private class resumeGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            gameController.switchMode();
            setVisible(false);
        }
    }
    private class exitGameButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            gameController.exitGame();
        }
    }

}
