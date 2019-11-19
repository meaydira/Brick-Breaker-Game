package model;

import java.awt.*;

public abstract class GameObject {
    protected double x_coordinate;
    protected double y_coordinate;
    protected int width;
    protected int height;
    protected Color color;

    //Constructor
    public GameObject(double x_coordianate, double y_coordinate, int width, int height, Color color) {
        this.setX(x_coordianate);
        setY(y_coordinate);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public void setX(double x) {
        this.x_coordinate = x;
    }

    public void setY(double y) {
        this.y_coordinate = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public double getX() {
        return this.x_coordinate;
    }

    public double getY() {
        return this.y_coordinate;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}
