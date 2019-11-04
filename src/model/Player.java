package model;

import java.util.ArrayList;

public class Player {

    private static Player player_instance = null;
    private boolean isAuth;
    private String username;
    private String password;
    private ArrayList<Integer> savedMapList;
    private ArrayList<Integer> savedGameList;
    public Player(){
             //Leave it blank since this is a Singleton
    }
    public Player getInstance(){
        if(player_instance==null) {
            player_instance = new Player();
            isAuth = false;
            return player_instance;
        }else return this.player_instance;
    }


    //TODO: private question and answer should be added.

    public void setAuth(boolean auth) {
        this.isAuth = auth;
    }

    public boolean getAuth(boolean Auth) {
        return this.isAuth;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Integer> getSavedMapList() {
        return savedMapList;
    }
    public void saveMap() {
        //TODO: saveMap() function should be written
    }
    public ArrayList<Integer> getSavedGameList() {
        return savedGameList;
    }
    public void saveGame() {
        //TODO: saveMap() function should be written
        //this.savedGameList.add(Game);
    }


}
