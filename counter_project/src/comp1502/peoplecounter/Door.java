package comp1502.peoplecounter;

/**
 * 
 * Keeps track of the number of people entering and exiting a building
 * through a specific door.
 * 
 * @author tjkendon
 *
 */
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
