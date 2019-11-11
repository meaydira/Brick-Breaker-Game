package observer.BaseObserver;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject) {
        super.subject=subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "+Integer.toHexString(subject.getNumber()));
    }
}
