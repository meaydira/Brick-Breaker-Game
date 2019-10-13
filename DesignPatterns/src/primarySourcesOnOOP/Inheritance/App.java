package Inheritance;

public class App {

	public static void main(String[] args) {

		Machine mach1 = new Machine(100.4, 10.2);
		mach1.start();
		mach1.stop();
		
		Car car1 = new Car(100, "Blue", 420, 1.8);
		car1.start();
		car1.wipingWindShield();
		car1.showInfo();
		
		double area=car1.calculateArea();
		System.out.println("The lateral surface area of a car is: "+area);
		
		
		

	}

}
