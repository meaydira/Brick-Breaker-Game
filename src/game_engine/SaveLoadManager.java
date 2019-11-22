package game_engine;

import Database.Database;
import Database.GameState;

import java.io.IOException;

public class SaveLoadManager{

    private Database db;

    private static SaveLoadManager SLM_instance = null;

    public SaveLoadManager() {
        db = Database.getInstance();
    }

    public static SaveLoadManager getInstance(){
        if(SLM_instance == null){
            SLM_instance = new SaveLoadManager();
            return SLM_instance;
        }else{
            return SLM_instance;
        }

    }

    public void saveGame(Game G) {

        GameState currentGameState= new GameState(G.getScore(),G.getlives(),500, G.getPaddle(),G.getBall(),G.getMap(),G.getPlayer());
        try {
            db.save(currentGameState);
        } catch (IOException e) {
            // TODO error message should be sent to controller to display.
            e.printStackTrace();
        }
    }

    public GameState loadGame(Player p) throws ClassNotFoundException, IOException {
        return db.load(p);
    }



}