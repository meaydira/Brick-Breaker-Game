package observer.StockApplication;

import java.util.ArrayList;

public class StockGrabber implements Subject{

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double googPrice;
    private double applPrice;

    public StockGrabber(){

        observers = new ArrayList<Observer>();

    }

    @Override
    public void register(Observer newObserver) {

        observers.add(newObserver);

    }

    @Override
    public void unregister(Observer deletedObserver) {

        int deletedIndex = observers.indexOf(deletedObserver);
        System.out.println("The observer "+(deletedIndex + 1)+" is deleted!");
        observers.remove(deletedIndex);

    }

    @Override
    public void notifyObserver() {

        for ( Observer o : observers) {
            o.update(applPrice,ibmPrice,googPrice);
        }

    }

    public void setIbmPrice(double newIbmPrice){

        this.ibmPrice = newIbmPrice;
        notifyObserver();

    }

    public void setGooglPrice(double newGooglPrice){

        this.googPrice = newGooglPrice;
        notifyObserver();

    }

    public void setApplPrice(double newApplPrice){

        this.applPrice = newApplPrice;
        notifyObserver();
    }


}
