package gui;

import javax.swing.*;

public class Renderer {
    private MainMenuPanel mainMenu;
    private ErrorPanel errorPanel;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private GamePanel gamePanel;
    JFrame obj ;
    private static Renderer renderer_instance = null;

    public static Renderer getInstance(){
        if(renderer_instance == null){
            renderer_instance = new Renderer();
            return renderer_instance;
        }else{
            return renderer_instance;
        }

    }
    public MainMenuPanel getMainMenu() {
        this.mainMenu = MainMenuPanel.getInstance();
        return mainMenu;
    }

    public ErrorPanel getErrorPanel() {
        this.errorPanel = ErrorPanel.getInstance();
        return errorPanel;
    }

    public LoginPanel getLoginPanel() {
        this.loginPanel= LoginPanel.getInstance();
        return loginPanel;
    }

    public GamePanel getGamePanel(){
        this.gamePanel = GamePanel.getInstance();
        obj =new JFrame();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Bricking Bad");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(this.gamePanel);
        obj.setVisible(true);
        return gamePanel;
    }

    public RegisterPanel getRegisterPanel() {
        this.registerPanel = RegisterPanel.getInstance();
        return registerPanel;
    }
}
