package database;

import game_engine.Player;

import java.io.IOException;

public interface DataBaseAdapter {
    public Player getPlayer(int id);
    public Player getPlayer(String username);
    public Player addNewPlayer(String username, String password);
    
    public GameState save(GameState G) throws IOException;


	public GameState load(Player player) throws IOException,ClassNotFoundException;



    }
