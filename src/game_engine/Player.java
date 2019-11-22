package game_engine;

import Database.GameState;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private String username;
    private String password;
    private int id;
    private ArrayList<Map> savedMaps;
    private ArrayList<GameState> savedGames;
    private boolean isAuth;
    private static final long serialVersionUID = 9L;
    public Player(int id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
        this.savedMaps = new ArrayList<Map>();
        this.savedGames = new ArrayList<GameState>();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {    return id; }

	public ArrayList<GameState> getSavedGames() {
		return savedGames;
	}

	public ArrayList<Map> getSavedMaps() {
		return savedMaps;
	}
    
	
    
}
