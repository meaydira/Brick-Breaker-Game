package observer.BaseObserver;

public class Main {
    public static void main(String[] args) {
        Subject subject=new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        new DecimalObserver(subject);

        System.out.println("First ass.7");
        subject.setNumber(7);
        System.out.println("\nFirst ass.18");
        subject.setNumber(18);

    }
}
