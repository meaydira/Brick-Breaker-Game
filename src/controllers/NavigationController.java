package controllers;

import game_engine.*;
import gui.BuildingModePanel;
import gui.LoginPanel;
import gui.RegisterPanel;

public class NavigationController implements GameConstants {
    //Game-objects on screen
    private static NavigationController controller_instance = null;
    private UIController uiController;
    private Player player;
    private Authentication auth;
    //Constructor
    private NavigationController() {

    }
    public static NavigationController getInstance(){
        if(controller_instance == null){
            controller_instance = new NavigationController();
            controller_instance.uiController = UIController.getInstance();
            controller_instance.auth = Authentication.getInstance();
            Redirection rd = controller_instance.uiController.getMainMenu().getDesiredPage();
            Player player_to_authenticate =  controller_instance.redirectDesiredPage(rd);

            boolean authentication_succesfull =controller_instance.authenticated(player_to_authenticate);
            if (authentication_succesfull){
                controller_instance.startBuildingMode();

            }else{
                controller_instance.showErrorPanel();
                System.exit(0);
            }
            return controller_instance;
        }else{
            return controller_instance;
        }
    }

    public boolean authenticated(Player player){
        if(player == null){return false;}
        //TODO: Authentication will be implemented.

        this.player = player;
        return true;
    }

    public void playGame(Map map){
        Game game = new Game(this.player, map);
        GameController g_controller = GameController.getInstance(game);
        uiController.getGamePanel(g_controller);
        Thread thread = new Thread(game);
        thread.run();

    }

    public void startBuildingMode(){
        //TODO: Normally we will call game here. That object will be responsible from every third party in the game.

        BuildingMode buildingMode = new BuildingMode(this.player);
        BuildingModePanel panel = uiController.getBuildingModePanel(buildingMode);
        Thread thread = new Thread(buildingMode);
        thread.run();
        controller_instance.playGame(buildingMode.getCurrentMap());

    }

    public void showErrorPanel(){
        uiController.getErrorPanel();
    }

    public Player redirectDesiredPage(Redirection rd) {
        if (rd == Redirection.gamePage) {
            return player;
        }
        else if (rd == Redirection.loginPage) {
            LoginPanel lp = uiController.getLoginPanel();
            return auth.loginUser(lp.getUsername(),lp.getPassword());

        }

        else if (rd == Redirection.registerPage) {
            RegisterPanel rp = uiController.getRegisterPanel();
            return auth.registerUser(rp.getUsername(),rp.getPassword());
        }
        return null;
    }
}




