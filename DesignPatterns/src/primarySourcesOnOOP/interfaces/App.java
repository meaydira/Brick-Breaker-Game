package interfaces;

public class App {

	public static void main(String[] args) {
		
		Machine mach1 = new Machine();
		mach1.start();
		
		Person person1 = new Person("Emre");
		person1.showInfo();
		
		Info info1 = new Machine();
		//I can do that because Machine is a class which implements Info interface. 
		info1.showInfo();
		
		
		Info info2 = person1;
		// You use person1 as a reference to the Person object.
		info2.showInfo();
		
		outputInfo(info1);// You can call the showInfo method my using a method outside of App class.
		outputInfo(info2);
	}
	
	//This must be a static method because it is not in a class. It would not be instantiated by an object. That's why it must be static.
	public static void outputInfo(Info info) {
		info.showInfo();
	}
	//You must do it in order to reach the interface
	
}
