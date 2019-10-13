package observer.StockApplication;

public class StockObserver implements Observer {


    private double ibmPrice;
    private double googPrice;
    private double applPrice;

    private static int observerIDTracker = 0;

    private int observerId = 0;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber){
        this.stockGrabber = stockGrabber;
        this.observerId = ++observerIDTracker;
        System.out.println("New Observer: " + this.observerId);
        this.stockGrabber.register(this);
    }


    @Override
    public void update(double applePrice,  double ibmPrice ,double googlePrice) {
        this.applPrice = applePrice;
        this.ibmPrice = ibmPrice;
        this.googPrice = googlePrice;

        printPrices();
    }

    public void printPrices(){
        System.out.println(observerId + "\nIBM: " + ibmPrice + "\nAPPL: "+applPrice+"\nGOGL: "+googPrice +"\n");

    }

}
