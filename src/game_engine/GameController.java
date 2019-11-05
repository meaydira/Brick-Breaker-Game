package game_engine;

import gui.ErrorPanel;
import gui.MainMenuPanel;

public class GameController implements GameConstants {
    //Game-objects on screen

    private MainMenuPanel mainMenu;
    private ErrorPanel errorPanel;
    private Game game;
    private Player player;

    //Constructor
    public GameController() {
        mainMenu = new MainMenuPanel();
        Redirection rd = mainMenu.getDesiredPage();
        if (authenticated(redirectDesiredPage(rd))){
            playGame();
        }else{
            showErrorPanel();
        }
    }


    public boolean authenticated(Player player){
        //TODO: We must add authentication information to this line of code.
        return true;
    }
    public void playGame(){

    }
    public void showErrorPanel(){
        errorPanel = new ErrorPanel();
    }

    public Player redirectDesiredPage(Redirection rd) {
        if (rd == Redirection.gamePage) {
            return null;
        } else if (rd == Redirection.loginPage) {
            Player dummyAutheticatedPlayer = new Player();
            return dummyAutheticatedPlayer;
        } else if (rd == Redirection.loginPage) {
            Player dummyAutheticatedPlayer = new Player();
            return dummyAutheticatedPlayer;
        }
        return null;
    }
}




