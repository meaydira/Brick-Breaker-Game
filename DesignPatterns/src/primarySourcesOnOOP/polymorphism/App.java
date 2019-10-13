package polymorphism;

public class App {

	public static void main(String[] args) {
		Plant plant1 = new Plant();
		Tree tree1 = new Tree();
		
		Plant plant2=plant1;//plant1 refers to the object Plant.
		//Also we could use !!tree1!! as a reference since we guarantee that tree1 is a Plant type.
		
		Plant plant3=tree1;
		
		tree1.grow();//What matters is the actual type of object that it is being pointed!!
		plant3.grow();//What matters is the actual type of object that it is being pointed!!
		plant2.grow();
		
		tree1.leavesSheding();
		//plant3.leavesSheding();
		//This won't work since the method is not inherited from the superclass!!
		
		doGrow(plant2);
		doGrow(plant3);
		
	}
	//Polymorphism guarantees me wherever a parent class is expected, I can use the child class of that parent class as a reference but 
	//in that case, I would call the methods of the child class in our example doGrow(plant3) will call The tree is growing!!
	public static void doGrow(Plant plant) {
		plant.grow();
	}
	
	
}
