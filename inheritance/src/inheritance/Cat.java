package inheritance;

public class Cat extends Animal {

	private String favouriteToy;
	
	public Cat(String name) {
		super(name);
	}

	/**
	 * @return the favouriteToy
	 */
	public String getFavouriteToy() {
		return favouriteToy;
	}

	/**
	 * @param favouriteToy the favouriteToy to set
	 */
	public void setFavouriteToy(String favouriteToy) {
		this.favouriteToy = favouriteToy;
	}
	
	

	
	
}
