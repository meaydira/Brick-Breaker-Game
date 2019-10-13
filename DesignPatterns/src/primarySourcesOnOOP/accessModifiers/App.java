package accessModifiers;

public class App {

	public static void main(String[] args) {
		
		Plant plant1 = new Plant();
		int result=0;
		result+= plant1.a;
		//The above operation is an unecessary operation!!
		
		System.out.println("The integer from the other class is: "+result);
		//Because the variable a is a static variable, you can access that variable without creating an object
		int try2 =Plant.a;
		
		System.out.println(try2);
		//Because ID is a final variable, you can no more change the variable to a another value.
		//Plant.ID=10; This would not work!!
		//However the Plant.a is a modifiable variable!!
		
		Plant.a=15;
		int try3=Plant.a;
		System.out.println(try3);
		
		
		
	}
	
}
