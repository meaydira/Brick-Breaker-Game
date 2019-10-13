package observer.StockApplication;

public class GrabStocks {

    public static void main(String[] args) {

        StockGrabber stockGrabber = new StockGrabber();
//
//        StockObserver observer1 = new StockObserver(stockGrabber);
//
//        stockGrabber.setApplPrice(120.20);
//        stockGrabber.setIbmPrice(330.20);
//        stockGrabber.setGooglPrice(220.20);

        StockObserver observer1 = new StockObserver(stockGrabber);

//        stockGrabber.setApplPrice(200.00);
//        stockGrabber.setIbmPrice(350.20);
//        stockGrabber.setGooglPrice(100.00);

//        stockGrabber.unregister(observer1);

        stockGrabber.setIbmPrice(500.20);
        stockGrabber.setGooglPrice(80.20);
        stockGrabber.setApplPrice(400.20);

        Runnable getIBM = new GetTheStock(2,"IBM",500.20,stockGrabber);
        Runnable getGOOGL = new GetTheStock(2,"GOOGL",80.20,stockGrabber);
        Runnable getAPPL = new GetTheStock(2,"AAPL",400.20,stockGrabber);

        new Thread(getIBM).start();
        new Thread(getGOOGL).start();
        new Thread(getAPPL).start();


    }

}
