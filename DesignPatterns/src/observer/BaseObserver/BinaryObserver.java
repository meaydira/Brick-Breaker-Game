package observer.BaseObserver;

public class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject) {
        super.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
    System.out.println("Binary String: "+Integer.toBinaryString(subject.getNumber()));
    }
}
