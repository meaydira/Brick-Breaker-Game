package Database;

import game_engine.Player;

public interface DataBaseAdapter {
    public Player getPlayer(int id);
    public Player getPlayer(String username);
    public Player addNewPlayer(String username, String password);




    }
