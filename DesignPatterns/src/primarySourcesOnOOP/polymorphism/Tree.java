package polymorphism;

public class Tree extends Plant{

	@Override
	public void grow() {
		System.out.println("The tree is growing!!");
	}

	public void leavesSheding() {
		System.out.println("Leaves are sheding!!");
	}
	
}
