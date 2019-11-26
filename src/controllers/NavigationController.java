package controllers;

import game_engine.*;
import gui.BuildingModePanel;
import gui.LoginPanel;
import gui.NotificationPanel;
import gui.RegisterPanel;

public class NavigationController implements GameConstants {
    //Game-objects on screen
    private static Redirection desiredPage;
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
            desiredPage = controller_instance.uiController.getMainMenu().getMainMenuRedirection();
            Player player_to_authenticate =  controller_instance.redirectDesiredPage(desiredPage);

            boolean authentication_succesfull =Authentication.authenticated(player_to_authenticate);
            if (authentication_succesfull){
                NotificationPanel panel = new NotificationPanel("Authentication Successful");
                controller_instance.player=player_to_authenticate;
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

    public Player redirectDesiredPage(Redirection desiredPage) {
      Player player_to_play = null;
        while(desiredPage != Redirection.gamePage){

            if (desiredPage == Redirection.loginPage) {
                LoginPanel lp = uiController.getLoginPanel();
                desiredPage = lp.getDesiredPage();
                if(desiredPage == Redirection.gamePage){
                    player_to_play = auth.loginUser(lp.getUsername(),lp.getPassword());
                }
            }

            else if (desiredPage == Redirection.registerPage) {
                RegisterPanel rp = uiController.getRegisterPanel();
                desiredPage = rp.getDesiredPage();
                if(desiredPage == Redirection.gamePage){
                    player_to_play = auth.registerUser(rp.getUsername(),rp.getPassword());
                }

            }
            else if (desiredPage == Redirection.mainPage){
                desiredPage = controller_instance.uiController.getMainMenu().getMainMenuRedirection();
            }

        }
        return player_to_play;
    }
}




