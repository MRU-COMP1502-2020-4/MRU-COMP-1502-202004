package comp1502.assignment1;

public class Floor {

	private String name;
	private Person waiter;
	
	
	/**
	 * @param name
	 */
	public Floor(String name) {
		this.name = name;
		waiter = null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the waiter
	 */
	public Person getPersonWaiting() {
		return waiter;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasPersonWaiting() {
		return waiter != null;
		
	}
	
	public void arrive(Person newPerson) {
		waiter = newPerson;
	}
	
	public Person depart() {
		Person departer = waiter;
		waiter = null;
		return departer;
	}
	
	public String toString() {
		if (waiter == null) {
			return name + "-Nobody";
		} 
		return name + "-" + waiter.getName();
	}
	
	
	
	
	
}
