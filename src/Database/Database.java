package Database;

import game_engine.Player;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Player> players_DB;
    private static int count = 0;
    private static Database db_instance = null;

    public Database(){
        players_DB = new ArrayList<Player>();
    }

    public static Database getInstance(){
        if(db_instance == null){
            db_instance = new Database();
            return db_instance;
        }else{
            return db_instance;
        }

    }

    public Player getPlayer(int id){
        Player player = null;
         for(Player p : players_DB){
             if(p.getID() == id){
                 player = p;
             }
         }

         return player;
    }

    public Player getPlayer(String username){
        Player player = null;
        for(Player p : players_DB){
            if(p.getUsername() == username){
                player = p;
            }
        }

        return player;
    }

    public Player addNewPlayer(String username, String password){
        for(Player p : players_DB){
            if(p.getUsername().equals(username))return null;
        }
        Player p = new Player( count++, username,password);
        players_DB.add(p);
        return p;
    }

    public List<Player> getPlayers(){
        return players_DB;
    }


}
