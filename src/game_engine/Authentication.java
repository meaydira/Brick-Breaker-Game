package game_engine;

import database.Database;

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

    public Player loginUser(String username, String password){
        Player p =db.getPlayer(username);
            if(p != null){
                if(p.getPassword().equals(password)){
                    return p;
                }else{
                    System.out.println("login error!");
                    //TODO: implement throw "Wrong password" error
                }
                //TODO: implement throw "No such user" error
            }
            return null;
    }

    public Player registerUser(String username, String password){
        return db.addNewPlayer(username,password);
    }



}
