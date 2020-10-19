package comp1502.peoplecounter;

public class Door {
	
	private int numberOfEnterances;
	private int numberOfExits;
	
	public Door() {
		numberOfEnterances = 0;
		numberOfExits = 0;
	}
	
	public void countEnterance() {
		numberOfEnterances++;
		
	}
	
	public void countExit() {
		numberOfExits++;
		
	}
	
	public int getNumberOfEnterances() {
		return numberOfEnterances;
	}

	/**
	 * @return the numberOfExits
	 */
	public int getNumberOfExits() {
		return numberOfExits;
	}
	
	
	
}
