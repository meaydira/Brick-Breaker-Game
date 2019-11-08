package factory;

public class Train implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Train is driving");
    }
}
