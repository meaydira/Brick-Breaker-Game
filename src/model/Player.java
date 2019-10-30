package models;

public class Player {

    private static Player player_instance = null;
    private int score = 0;
    public Player(){
             //Leave it blank since this is a Singleton
    }
    public Player getInstance(){
        if(player_instance==null) {
            player_instance = new Player();
            return player_instance;
        }else return this.player_instance;
    }

}
