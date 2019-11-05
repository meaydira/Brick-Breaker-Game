package game_engine;

public class Player {

    private String username;
    private String password;
    private int numberOfLivesRemaining;


    public Player(String username,String password){
        this.username = username;
        this.password = password;
        this.numberOfLivesRemaining = 3;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
