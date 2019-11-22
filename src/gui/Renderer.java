package gui;

import game_engine.Board;
import game_engine.BuildingMode;
import game_engine.Game;

public class Renderer {
    private MainMenuPanel mainMenu;
    private ErrorPanel errorPanel;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private GamePanel gamePanel;
    private BuildingModePanel buildingModePanel;
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

    public GamePanel getGamePanel(Game game){
        this.gamePanel = GamePanel.getInstance(game);
        Board gameBoard = Board.getInstance(gamePanel);
        return gamePanel;
    }

    public RegisterPanel getRegisterPanel() {
        this.registerPanel = RegisterPanel.getInstance();
        return registerPanel;
    }

    public BuildingModePanel getBuildingModePanel(BuildingMode bm) {
        this.buildingModePanel =  BuildingModePanel.getInstance(bm);
        return buildingModePanel;
    }
}
