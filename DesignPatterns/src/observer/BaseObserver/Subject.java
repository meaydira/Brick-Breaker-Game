package observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerlist = new ArrayList<Observer>() ;
    private int number;


    public void setNumber(int number) {
        this.number = number;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        this.observerlist.add(observer);
    }

    public int getNumber() {
        return number;
    }

    public void notifyAllObservers(){
        for (Observer observer: observerlist) {
            observer.update();
        }
    }
}
