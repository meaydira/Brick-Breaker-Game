package interfaces;

public class Machine implements Info{

	private int id = 7;
	
	public void start() {
			System.out.println("The machine has started!");
	}

	@Override
	public void showInfo() {
		System.out.println("The Machine has an Id of "+ id);
	}
	
}
