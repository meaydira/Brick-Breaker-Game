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
        if(player == null){return false;}
        return true;
    }
    public void playGame(){
        renderer.getGamePanel();
    }
    public void showErrorPanel(){
        renderer.getErrorPanel();
    }

    public Player redirectDesiredPage(Redirection rd) {
        if (rd == Redirection.gamePage) {
            GamePanel gp = renderer.getGamePanel();
            return player;
        }
        else if (rd == Redirection.loginPage) {
            LoginPanel lp = renderer.getLoginPanel();
            return auth.loginUser(lp.getUsername(),lp.getPassword());


        }
        else if (rd == Redirection.registerPage) {
            RegisterPanel rp = renderer.getRegisterPanel();
            return  auth.registerUser(rp.getUsername(),rp.getPassword());
        }
        return null;
    }
}




