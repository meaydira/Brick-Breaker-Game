package game_engine;

import Database.Database;
import Database.GameState;

import java.io.IOException;

public class SaveLoadManager{

    private static Authentication auth_instance = null;
    private Database db;
    
    /*public Authentication(){
          db = Database.getInstance();
    }
    */
    public static Authentication getInstance(){
        if(auth_instance == null){
            auth_instance = new Authentication();
            return auth_instance;
        }else{
            return auth_instance;
        }

    }
    
    public void saveGame(Game G) {
    	
    	GameState currentGameState= new GameState(G.getScore(),G.getlives(),500, G.getPaddle(),G.getBall(),G.getMap(),G.getPlayer().getID());

    	try {
			db.save(currentGameState);
		} catch (IOException e) {
			// TODO error message should be sent to controller to display.
			e.printStackTrace();
		}
    }
    
    public GameState loadGame(int gameid, int playerid) throws ClassNotFoundException, IOException {
    	return db.load(gameid,playerid);
    }



}
