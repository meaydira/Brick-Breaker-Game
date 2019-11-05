package game_engine;

import gui.*;

public class GameController implements GameConstants {
    //Game-objects on screen

    private Renderer renderer;
    private Game game;
    private Player player;

    //Constructor
    public GameController() {
        renderer = Renderer.getInstance();
        Redirection rd = renderer.getMainMenu().getDesiredPage();
        if (authenticated(redirectDesiredPage(rd))){
            playGame();
        }else{
            showErrorPanel();
        }
    }

    public boolean authenticated(Player player){
        //TODO: We must add authentication information to this line of code.
        //TODO: Here we will check db, it the username record exits but the password does not match auth fails.
        //TODO: If the username does not lie in the database, it means we will create a new record.
        return false;
    }
    public void playGame(){

    }
    public void showErrorPanel(){
        renderer.getErrorPanel();
    }

    public Player redirectDesiredPage(Redirection rd) {
        if (rd == Redirection.gamePage) {
            return null;
        }
        else if (rd == Redirection.loginPage) {
            LoginPanel lp = renderer.getLoginPanel();
            Player player = new Player(lp.getUsername(),lp.getPassword());
            return player;
        }
        else if (rd == Redirection.registerPage) {
            RegisterPanel rp = RegisterPanel.getInstance();
            Player player = new Player(rp.getUsername(),rp.getPassword());
            //TODO insert this player to the database.
            return null;
        }
        return null;
    }
}




