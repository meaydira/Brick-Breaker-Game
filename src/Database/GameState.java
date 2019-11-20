package Database;

import java.io.Serializable;

import game_engine.Map;

import static game_engine.GameConstants.*;

import model.balls.Ball;
import model2.Paddle;

public class GameState implements Serializable {
	public int score;
	public Paddle paddleState;
	public Ball ballState;
	public int lives;
	public int time; //GAME DOESN'T HAVE TIME, GONNA BE IMPLEMENTED WHEN IT DOES ONE.
	public Map mapState;
	public int playerid;

	public GameState(int score, int lives, int time, Paddle p, Ball b, Map m,int playerid) {
		this.score=score;
		this.paddleState= p;
		this.ballState= b;
		this.lives=lives;
		this.time=time;
		this.mapState= m;
		this.playerid = playerid;
	}
	public GameState(Paddle p, Ball b, Map m) {
		this.score=0;
		this.paddleState= p;
		this.ballState= b;
		this.lives=MAX_LIVES;
		this.time=500; //JUST AN ARBITRARY NUMBER. GONNA CHANGE WHEN TIME IMPLEMENTED.
		this.mapState= m;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Paddle getPaddleState() {
		return paddleState;
	}

	public void setPaddleState(Paddle paddleState) {
		this.paddleState = paddleState;
	}

	public Ball getBallState() {
		return ballState;
	}

	public void setBallState(Ball ballState) {
		this.ballState = ballState;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Map getMapState() {
		return mapState;
	}

	public void setMapState(Map mapState) {
		this.mapState = mapState;
	}
	public int getPlayerid() {
		return playerid;
	}
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	
	

	

}
