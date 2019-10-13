package Inheritance;

public class Car extends Machine {

	
	String color;
	int topSpeed;
	
	public Car(int topSpeed, String color, double w, double h) {
		super(w,h);
		this.color=color;
		this.topSpeed=topSpeed;
	}
	
	public double calculateArea() {
		return super.weight * super.height;
	}
	
	
	
	public void wipingWindShield() {
		System.out.println("The windshild is being wiped!");
	}

	@Override//This annotation is necessary when you want to check if you are overriding the method or not!!
	
	public void start() {
		super.start();
		System.out.println("The car started working!");
	}

	@Override
	public void stop() {
		System.out.println("The car stopped!");
	}
	
	public void showInfo() {
		System.out.println("Info is shown: "+name);
	}
	
	
	
}
