package controllers;

import game_engine.BuildingMode;
import gui.*;

public class UIController {
    private MainMenuPanel mainMenu;
    private ErrorPanel errorPanel;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private GamePanel gamePanel;
    private BuildingModePanel buildingModePanel;
    public static Gameboard buildingBoard;
    private static UIController UIController_instance = null;

    public static UIController getInstance(){
        if(UIController_instance == null){
            UIController_instance = new UIController();
            return UIController_instance;
        }else{
            return UIController_instance;
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

    public GamePanel getGamePanel(GameController game){
        this.gamePanel = GamePanel.getInstance(game);
        Gameboard gameBoard = Gameboard.changeToGamingPanel(gamePanel);
        return gamePanel;
    }

    public RegisterPanel getRegisterPanel() {
        this.registerPanel = RegisterPanel.getInstance();
        return registerPanel;
    }

    public BuildingModePanel getBuildingModePanel(BuildingMode bm) {
        this.buildingModePanel =  BuildingModePanel.getInstance(bm);
        buildingBoard = Gameboard.getInstance(buildingModePanel);
        return buildingModePanel;
    }
}
