package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import game_engine.Player;

public interface DataBaseAdapter {
    public Player getPlayer(int id);
    public Player getPlayer(String username);
    public Player addNewPlayer(String username, String password);
    
    public GameState save(GameState G) throws IOException;


	public GameState load(int gameid, int playerid) throws IOException,ClassNotFoundException;



    }
