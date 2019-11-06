package game_engine;

import gui.GamePanel;
import gui.LoginPanel;
import gui.RegisterPanel;
import gui.Renderer;

public class GameController implements GameConstants {
    //Game-objects on screen

    private Renderer renderer;
    private Game game;
    private Player player;
    private Authentication auth;
    //Constructor
    public GameController() {
        renderer = Renderer.getInstance();
        auth = Authentication.getInstance();
        Redirection rd = renderer.getMainMenu().getDesiredPage();
        if (authenticated(redirectDesiredPage(rd))){
            playGame();
        }else{
            showErrorPanel();
        }
    }
    public boolean authenticated(Player player){
     //   if(player == null){return false;}
        //TODO: Authentication will be implemented.
        return true;
    }
    public void playGame(){
        //TODO: Normally we will call game here. That object will be responsible from every third party in the game.
        renderer.getGamePanel();
    }
    public void showErrorPanel(){
        renderer.getErrorPanel();
    }

    public Player redirectDesiredPage(Redirection rd) {
        if (rd == Redirection.gamePage) {
        //    GamePanel gp = renderer.getGamePanel();
            return player;
        }
        else if (rd == Redirection.loginPage) {
            LoginPanel lp = renderer.getLoginPanel();
            //auth.loginUser(lp.getUsername(),lp.getPassword());
            return player;
        }

        else if (rd == Redirection.registerPage) {
            RegisterPanel rp = renderer.getRegisterPanel();
            return auth.registerUser(rp.getUsername(),rp.getPassword());
        }
        return null;
    }
}




