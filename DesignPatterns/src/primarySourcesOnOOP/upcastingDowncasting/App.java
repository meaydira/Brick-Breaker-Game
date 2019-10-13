package upcastingDowncasting;

class Machine{
	public void start() {
		System.out.println("The machine has started!");
	}

}

class Camera extends Machine{

	@Override
	public void start() {
		System.out.println("The camera has started!");
		
	}
	public void snap() {
		System.out.println("The photo has been taken!!");
	}
	
}
public class App {

	public static void main(String[] args) {

	Machine mach1 = new Machine();
	Camera camera1 = new Camera();
	
	mach1.start();
	camera1.start();
	camera1.snap();
	
	System.out.println();
	
	//Upcasting (It is safe, guaranteed by the polymorphism!)
	
	Machine mach2 = camera1;// You can also use here the new Camera(); keyword!!
	mach2.start();//This method calls the start method of camera object!!
	//mach2.snap() would not work here since it is not inherited from the superclass. The type is still the camera!!!
		
	
	System.out.println();

	//This part is very important!!
	//Downcasting (It is unsafe, you can not downcast variables from an object to another! )
	
	Machine mach3 = new Camera();
	Camera camera2 = (Camera)mach3;//Java asks you for confirmation!!
	//It expects you to cast when you are going to used superclass specific methods!!
	camera2.start();
	camera2.snap();

	Machine mach4 = new Machine();
	Camera camera3 = (Camera)mach4;
	//camera3.snap();//This will give you an error since the mach4 can not be casted down to the subclass since its reference is a Machine() not Camera() 
	//camera3.start(); This will not work either!!
	
	
	
	
	
	
	}

}
