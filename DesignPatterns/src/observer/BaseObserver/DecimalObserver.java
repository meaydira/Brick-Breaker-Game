package observer.BaseObserver;

public class DecimalObserver extends Observer{

    public DecimalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Decimal String: "+subject.getNumber() );
    }
}
