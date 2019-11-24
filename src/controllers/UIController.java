package controllers;

import game_engine.Board;
import game_engine.BuildingMode;
import game_engine.Game;
import gui.*;

public class UIController {
    private MainMenuPanel mainMenu;
    private ErrorPanel errorPanel;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private GamePanel gamePanel;
    private BuildingModePanel buildingModePanel;
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
        Board gameBoard = Board.changeToGamingPanel(gamePanel);
        return gamePanel;
    }

    public RegisterPanel getRegisterPanel() {
        this.registerPanel = RegisterPanel.getInstance();
        return registerPanel;
    }

    public BuildingModePanel getBuildingModePanel(BuildingMode bm) {
        this.buildingModePanel =  BuildingModePanel.getInstance(bm);
        Board gameBoard = Board.getInstance(buildingModePanel);
        return buildingModePanel;
    }
}
