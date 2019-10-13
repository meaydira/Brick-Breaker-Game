package Inheritance;

public class Machine {
	
	double weight;
	double height;
	
	
	public Machine(double we, double he) {
		this.weight = we;
		this.height = he;
	}

	//If you do not declare any access modifier, your method or variable will be visible in the package only by default.
	public String name= "I am a machine";
	// In the case of declaring this variable private, you will not access the above variable in other classes.
	public void start() {
		System.out.println("The machine has started");
	}
	
	public void stop() {
		System.out.println("The machine has stopped");
	}
	
	
	
}
