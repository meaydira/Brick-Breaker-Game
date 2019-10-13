package observer.StockApplication;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable{

    private int startTime;
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(int startTime, String stock, double price, Subject stockGrabber) {
        this.startTime = startTime;
        this.stock = stock;
        this.price = price;
        this.stockGrabber = stockGrabber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            double randomNumber = (Math.random() * 2.00) - 1.00;

            DecimalFormat df = new DecimalFormat("##.##");
            int delay = 0;
            this.price = Double.valueOf(df.format(this.price + randomNumber));
            if (stock == "IBM") {
                delay=1;
                sleep(delay);
                ((StockGrabber) stockGrabber).setIbmPrice(this.price);
            }
            if (stock == "AAPL") {
                delay=2;
                sleep(delay);
                ((StockGrabber) stockGrabber).setApplPrice(this.price);
            }
            if (stock == "GOOGL") {
                delay=3;
                sleep(delay);
                ((StockGrabber) stockGrabber).setGooglPrice(this.price);
            }

            System.out.println(stock + " : " + df.format(this.price -randomNumber)+" -> "+df.format(this.price) + " delta: " + df.format(randomNumber));
            System.out.println();

        }
    }
    void sleep(int delay){
        try {
            Thread.sleep(2000+delay);
        } catch (InterruptedException e) {
        }
    }
}
