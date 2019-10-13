package singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        Singleton mySingleton1 = Singleton.getInstance();
        Singleton mySingleton2 = Singleton.getInstance();
        mySingleton1.doSmth();

        System.out.println(mySingleton1.hashCode());
        System.out.println(mySingleton2.hashCode());
    }

}
