package game_engine;

import factories.AlienFactory;
import factories.Brickfactory;
import gui.MainMenuPanel;

enum GameStatus {
    Won,Lost,Undecided
}
public class Game {

    private Player player;
    private Board board;
    private MainMenuPanel initiater ;
    private Brickfactory brickFactory;
    private AlienFactory alienFactory;
    private GameStatus status;

    public Game(){
        this.board = Board.getInstance();
//        this.initiater =
    }

}
