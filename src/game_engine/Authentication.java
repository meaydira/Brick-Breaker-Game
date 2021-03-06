package game_engine;

import database.Database;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class Authentication {

    private static Authentication auth_instance = null;
    private Database db;

    public Authentication(){
            db = Database.getInstance();
    }

    public static Authentication getInstance(){
        if(auth_instance == null){
            auth_instance = new Authentication();
            return auth_instance;
        }else{
            return auth_instance;
        }

    }

    public static boolean authenticated(Player player){
        if(player == null){
            return false;
        }else{
        return true;
        }
    }

    public Player loginUser(String username, String password)  {
        Player p =db.getPlayer(username);
        if(p != null){
            if(p.getPassword().equals(password)){
                return p;
            }else{
                //TODO: implement throw "Wrong password" error
                throw new SecurityException();
            }
        }
        //TODO: implement throw "No such user" error
        throw new IllegalArgumentException();
    }

    public Player registerUser(String username, String password){
        return db.addNewPlayer(username,password);
    }



}
