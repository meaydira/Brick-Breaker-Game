package model.aliens;

import game_engine.GameConstants;
import model.GameObject;

import java.awt.*;

public abstract class Alien extends GameObject implements GameConstants {
    public Alien(int x_coordianate, int y_coordinate, int width, int height, Color color) {
        super(x_coordianate, y_coordinate, width, height, color);
    }

}
