package game_engine;

import factories.AlienFactory;
import factories.Brickfactory;
import model.Player;

enum GameStatus {
    Won,Lost,Undecided
}
public class Game {

    private Player player;
    private Board board;
    private Brickfactory brickFactory;
    private AlienFactory alienFactory;
    private GameStatus status;

    public Game(){

    }

}
