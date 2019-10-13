package encapsulation;

class Plant{
	
	
//	When you encapsulate, you try to keep the data private in a class! Other classes must reach the data of that class through methods 

	public static final int a=10;
	private String name;
	
	public String getData() {
		
		String data = "The weather forecast is : "+calculateWeatherForecast()+" .";
		return data;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private int calculateWeatherForecast() {
		return 9;
	}
	
	
	
	
	
	
	
}


public class App {

	public static void main(String[] args) {

	}

}
