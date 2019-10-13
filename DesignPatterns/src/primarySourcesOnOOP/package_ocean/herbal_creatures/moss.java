package package_ocean.herbal_creatures;

import package_ocean.Fish;

//moss is located in a sub-package  

//You can not give another class name as public class etc.
//You can have as many class as you want in a class but they must have only a class name!

class Dummhead{
	
	private String color="blue";
	public Dummhead() {
		System.out.println(color);
	}
	
}

public class moss extends Fish {

	String eyeColor;
	
	public moss(int height, int weight, String eyeColor) {

		super(height,weight);
		this.eyeColor=eyeColor;
		
		//Even though moss is a subclass of Fish, you can not access an instance variable of Fish from another package since it is not visible.
		System.out.println("The height of the fish is: "+/*this.height --> won't workk!*/" You must use a public accesss modifier for this operation!" );
		
		
		
		
	}
	public static void main(String[] args) {
		
//		moss moss1 = new moss();
		Dummhead person1 = new Dummhead();
		
		//Below instance variable is unvisible
		//person1.color
		
	}
	
	
}
