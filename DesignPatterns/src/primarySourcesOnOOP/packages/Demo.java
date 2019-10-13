package packages;

import package_ocean.*;

public class Demo {

	
	public static void main(String[] args) {
	
	//You can not create an object of a class from a different package such as:
		
	// Machine mach1= new Machine(); would give you an error unless you do not import the package and class information!!
	
	Fish fish = new Fish(0, 0);
	fish.swim();
	
	SeaWeed weed = new SeaWeed();
		
	
			
}
}
