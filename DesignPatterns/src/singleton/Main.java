package singleton;

public class Main {

    public static void main(String[] args) {
//
        Controller mySingleton1 = Controller.getInstance(5);
        mySingleton1.setNumber(3);

        System.out.println(mySingleton1.getNumber());

//      mySingleton1.doSmth();

        System.out.println(mySingleton1.hashCode());
        System.out.println(mySingleton1.hashCode());
    }

}
