package model;

public class Player {

    private static Player player_instance = null;
    private String username;
    private String password;
    private int numberOfLivesRemaining;
    

    private int score = 0;
    public Player(){

    }
    public Player getInstance(){
        if(player_instance==null) {
            player_instance = new Player();
            return player_instance;
        }else return this.player_instance;
    }

}
