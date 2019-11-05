package game_engine;

public class Player {

    private static Player player_instance = null;
    private String username;
    private String password;
    private int numberOfLivesRemaining;


    public Player(){
    }
    public Player getInstance(){
        if(player_instance==null) {
            player_instance = new Player();
            return player_instance;
        }else return this.player_instance;
    }

}
