package comp1502.packages;
//package command tells Java which package the file belongs to
//package must match the directories holding the file


public class ExampleA {

	public static int nextID = 0;
	// shared variable 
	
	public static final double tax = 0.05;
	// constant
	
	private int x;
	private int id;

	
	public ExampleA(int x) {
		this.x = x;
		id = nextID;
		nextID++;
	}
	
	int getX() {
		return x;
	}
	
	public void print() {
		System.out.println(x +" " + id);
	}
	
	public static void classMethod() {
		System.out.println(nextID);
	}
	

}
