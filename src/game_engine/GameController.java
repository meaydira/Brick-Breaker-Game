package game_engine;

import gui.BuildingModePanel;
import gui.LoginPanel;
import gui.RegisterPanel;
import gui.Renderer;

public class GameController implements GameConstants {
    //Game-objects on screen
    private static GameController controller_instance = null;
    private Renderer renderer;
    private Game game;
    private Player player;
    private Authentication auth;
    //Constructor
    public GameController() {

    }
    public static GameController getInstance(){
        if(controller_instance == null){
            controller_instance = new GameController();
            controller_instance.renderer = Renderer.getInstance();
            controller_instance.auth = Authentication.getInstance();
            Redirection rd = controller_instance.renderer.getMainMenu().getDesiredPage();
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
    public void playGame(){
        Game game = new Game(this.player);
        renderer.getGamePanel(game);
        Thread thread = new Thread(game);
        thread.run();

    }

    public void playGame(Map map){
        Game game = new Game(this.player, map);
        renderer.getGamePanel(game);
        Thread thread = new Thread(game);
        thread.run();

    }

    public void startBuildingMode(){
        //TODO: Normally we will call game here. That object will be responsible from every third party in the game.

        BuildingMode buildingMode = new BuildingMode(this.player);
        BuildingModePanel panel = renderer.getBuildingModePanel(buildingMode);
        Thread thread = new Thread(buildingMode);
        thread.run();
        controller_instance.playGame(buildingMode.getCurrentMap());

    }

    public void showErrorPanel(){
        renderer.getErrorPanel();
    }

    public Player redirectDesiredPage(Redirection rd) {
        if (rd == Redirection.gamePage) {
            return player;
        }
        else if (rd == Redirection.loginPage) {
            LoginPanel lp = renderer.getLoginPanel();
            return auth.loginUser(lp.getUsername(),lp.getPassword());

        }

        else if (rd == Redirection.registerPage) {
            RegisterPanel rp = renderer.getRegisterPanel();
            return auth.registerUser(rp.getUsername(),rp.getPassword());
        }
        return null;
    }
}




