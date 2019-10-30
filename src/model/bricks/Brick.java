package model.bricks;

public abstract class Brick {
    private int x_coordinate;
    private int y_coordinate;
    int strength;
    boolean isVisible = true;

    public Brick(int x_coordinate,int y_coordinate){
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
    public void disappear(){
        if (strength == 0) isVisible = false;
    };

    public void hasBeenHit(){
        this.strength--;
    }


}
