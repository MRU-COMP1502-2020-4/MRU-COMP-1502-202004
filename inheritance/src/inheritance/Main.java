package inheritance;

public class Main {

	public static void main(String[] args) {
		
		Animal animal = new Animal("Fluffly");
		
		animal.eat();
		animal.speak();
		
		Cat rover = new Cat("Rover");
		
		rover.eat();
		rover.speak();
	
		rover.setFavouriteToy("Ball of String");
		
		Marmot gold = new Marmot("Gold");
		
		gold.eat();
		gold.speak();
		
		gold.dig();
		
		
				
		
	}

}
