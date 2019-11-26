package database;

import game_engine.Player;

import java.io.IOException;

public class Database {

    //private ArrayList<Player> players_DB;
    private DataBaseAdapter db_version= new FileManager();
    private static Database db_instance = null;

    public Database() {
        //players_DB = new ArrayList<Player>();
    }

    public static Database getInstance(){
        if(db_instance == null){
            db_instance = new Database();
            return db_instance;
        }else{
            return db_instance;
        }

    }

    public Player getPlayer(int id)  {
        return db_version.getPlayer(id);
    }

    public Player getPlayer(String username){
        return db_version.getPlayer(username);
    }

    public Player addNewPlayer(String username, String password){
            return db_version.addNewPlayer(username,password);
    }
    
    public GameState save(GameState G) throws IOException {
    	return db_version.save(G);

	}

	public GameState load(Player player) throws IOException,ClassNotFoundException{
		return db_version.load(player);
	}
    
    
    
    
    /*
    public List<Player> getPlayers(){
        return players_DB;
    }
    */


}
