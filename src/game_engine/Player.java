package game_engine;

public class Player {

    private String username;
    private String password;
    private String isAuth;


    public Player(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
