package comp1502.assignment1;

import java.util.ArrayList;

public class Simulation {

	public static void main(String[] args) {

		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("A"));
		floors.add(new Floor("B"));
		floors.add(new Floor("C"));
		floors.add(new Floor("D"));
		
		Elevator e = new Elevator("Simulation Elevator", floors);
		Person p = new Person("Persephony");
		Building b = new Building("Simulation Building", floors, e, p);
		
		for (int i = 1; i <= 100; i++) {
			System.out.println("Step " + i);
			System.out.println(b.getBuildingVisualization());
			b.simulate();
		}
		

	}

}
