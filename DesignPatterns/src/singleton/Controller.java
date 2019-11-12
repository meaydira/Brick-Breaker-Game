package singleton;

public class Controller {

    private static Controller myObject ;
    private int number;
    private Controller() { }

    public static synchronized Controller getInstance(int number){
        if (myObject == null){
            myObject = new Controller();
            myObject.number =number;
        }
        return myObject;
    }

    public void doSmth(){
        System.out.println("I am doing something!");
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
