package Database;

import game_engine.Player;

import java.io.*;
import java.util.ArrayList;

public class FileManager implements DataBaseAdapter {
	private  String playerTable= "src/Database/playerTable.txt";
	private static int count = 0;


	private ArrayList<Player> getPlayerList(){
		ArrayList<Player> players_DB =new ArrayList<>();

		try{
			File f = new File(playerTable);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			players_DB=(ArrayList<Player>)ois.readObject();

			ois.close();
			fis.close();


		}catch (EOFException e){

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		return players_DB;
	}
	@Override
	public Player getPlayer(int id) {
		//I created players_DB here since I had doubts making it a db field.
		//I know we would have to read players again when we have to get one in the future
		//But this seemed more natural, since other databases don't read and store at first as well.
		//Open to discussion though :)
		ArrayList<Player> players_DB =new ArrayList<Player>();

		players_DB= getPlayerList();


		Player player = null;
		for(Player p : players_DB){
			if(p.getID() == id){
				player = p;
			}
		}

		return player;
	}

	@Override
	public Player getPlayer(String username) {
		ArrayList<Player> players_DB = getPlayerList();

		Player player = null;
		for(Player p : players_DB){
			if(p.getUsername().equals(username)){
				player = p;
			}
		}

		return player;
	}

	@Override
	public Player addNewPlayer(String username, String password) {

		ArrayList<Player> players_DB =getPlayerList();

		for(Player p : players_DB){
			if(p.getUsername().equals(username))return null;
		}
		Player p = new Player( count++, username,password);
		players_DB.add(p);


		try {
			File f = new File(playerTable);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(players_DB);
			oos.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return p;
	}

	public ArrayList<GameState> getSavedGames(Player player) {
		ArrayList<GameState> states_DB =new ArrayList<>();

		try{
			File f = new File("berk"+"_savedgames.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			states_DB=(ArrayList<GameState>)ois.readObject();

			ois.close();
			fis.close();


		}catch (EOFException e){

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		return states_DB;
	}


	public GameState save(GameState GS) throws IOException {


		String filename = GS.getPlayer().getUsername()+"_savedgames.txt";
		File f= new File(filename); //Name includes Player's name & index.
		System.out.println("Save file "+ filename+"created.");
		FileOutputStream fos= new FileOutputStream(f);
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(GS);


		return GS;

	}


	@Override
	public GameState load(Player player) throws IOException,ClassNotFoundException{

		File f= new File(player.getUsername()+"_savedgames.txt");
		FileInputStream fis= new FileInputStream(f);
		ObjectInputStream ois= new ObjectInputStream(fis);

		GameState gameToLoad = (GameState) ois.readObject();
		return gameToLoad;
	}

}