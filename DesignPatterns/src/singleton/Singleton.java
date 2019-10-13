package singleton;

public class Singleton {

    private static Singleton myObject ;

    private Singleton() { }

    public static synchronized Singleton getInstance(){
        if (myObject == null)
            myObject = new Singleton();
        return myObject;
    }

    public void doSmth(){
        System.out.println("I am doing something!");
    }
}
