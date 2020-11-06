package inheritance;

public class Animal {
	
	private String name;

	/**
	 * @param name
	 */
	public Animal(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void speak() {
		System.out.println(name + " spoke.");
	}
	
	public void eat() {
		System.out.println(name + " ate.");
	}
	
	
	

}
