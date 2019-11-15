package game_engine;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private String username;
    private String password;
    private int id;
    private ArrayList<Map> savedMaps;
    private ArrayList<Game> savedGames;
    private boolean isAuth;

    public Player(int id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
        this.savedMaps = new ArrayList<Map>();
        this.savedGames = new ArrayList<Game>();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {    return id; }
}
