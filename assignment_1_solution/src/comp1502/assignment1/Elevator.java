package comp1502.assignment1;

import java.util.ArrayList;

public class Elevator {

	private enum Direction {MOVING_UP, MOVING_DOWN, HOLDING}; 
	
	private String name;
	private ArrayList<Floor> floors;
	
	private Floor currentFloor;
	private Floor destinationFloor;
	
	private Person rider;
	
	private Direction elevatorDirection;
	
	public Elevator(String name, ArrayList<Floor> floors) {
		this.name = name;
		this.floors = floors;
		this.currentFloor = floors.get(0);
		this.destinationFloor = null;
		this.rider = null;
		this.elevatorDirection = Direction.HOLDING;
		
	}

	public String getName() {
		return name;
	}

	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public Floor getDestinationFloor() {
		return destinationFloor;
	}

	public Person getPersonRiding() {
		return rider;
	}

	public boolean isMoving() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOnFloor(Floor floor) {
		return currentFloor.equals(floor);
		
	}

	public void enter(Person p) {
		rider = p;
		
	}

	public boolean hasPersonRiding() {
		return rider != null;
		
	}

	public void call(Floor floor) {
		this.destinationFloor = floor;
		
	}

	public Person exit() {
		Person exiter = rider;
		rider = null;
		return exiter;
	}

	public void move() {
		if (elevatorDirection == Direction.HOLDING) {
			return;
		}
		
		
	}

}
