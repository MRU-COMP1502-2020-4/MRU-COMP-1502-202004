package comp1502.assignment1;

import java.util.List;
import java.util.Random;

public class Building {

	/**
	 * The different state the simulation can be in.
	 *
	 */
	private enum SimulationState {CALLING, WAITING, RIDING, AFTER};
	
	/**
	 * Building name
	 */
	private String name;
	
	/**
	 * List of all floors in the building
	 */
	private List<Floor> floors;
	
	/**
	 * The building's elevator
	 */
	private Elevator elevator;
	
	/**
	 * The current state the elevator can be in
	 */
	private SimulationState state;
	
	/**
	 * A random number generator to help decide which floors to go to
	 */
	private Random random;
	
	/**
	 * 
	 * <p>Creates a new building with the given name, floors elevator and occupant.</p>
	 * 
	 * <p>The occupant will be placed on the 0th element of floors (the "lowest floor") and
	 * the simulation will being with with the person calling the eleavtor.</p>
	 * 
	 * @param name the building name
	 * @param floors the list of floors in the building
	 * @param elevator the elevator servicing the building floors
	 * @param p the person entering the building
	 */
	public Building(String name, 
			List<Floor> floors,
			Elevator elevator,
			Person p) {
		this.name = name;
		this.floors = floors;
		this.elevator = elevator;
		floors.get(0).arrive(p);
		state = SimulationState.CALLING;
		random = new Random();
		
	}
	
	/**
	 * <p>Simulates a single step in the elevator simulation.</p>
	 * 
	 * <p>Each step in the simulation is effectively one move of the elevator up or down,
	 * or the one person stepping onto or off of the elevator.</p>
	 * 
	 * <p>The simulation has four states and it rotates between them:</p>
	 * <ol>
	 *     <li>Calling - the occupant is on a floor and calls the elevator to them and they begin Waiting/li>
	 *     <li>Waiting - the occupant is waiting for the elevator to move to them, when it arrives they stop on and being Riding</li>
	 *     <li>Riding - the occupant is going to a new floor on the elevator, when they arrive they stop off and the state becomes After</li>
	 *     <li>After - the elevator is sent to a different floor, so the simulataion can start over. When it arrives the state becomes Calling</li>
	 * </ol>
	 * 
	 * 
	 */
	public void simulate() {
		if (state.equals(SimulationState.CALLING)) {
			// we'll find the person and have them call 
			// we're doing it this way since it will help with later versions
			for (Floor floor : floors) {
				if (floor.hasPersonWaiting()) {
					elevator.call(floor);
					System.out.println(floor.getPersonWaiting().getName() 
							+ " has called the elevator to floor " 
							+ floor.getName());
					state = SimulationState.WAITING;
				}
			}
		} else if (state.equals(SimulationState.RIDING)) {
			if (!elevator.isMoving()) {
				// let the person off and send the elevator away
				Floor f = elevator.getCurrentFloor();
				f.arrive(elevator.exit());
				System.out.println(f.getPersonWaiting().getName() 
						+ " has has gotten off the elevator at floor " 
						+ elevator.getCurrentFloor().getName());
				
				Floor next = floors.get(random.nextInt(floors.size() - 1));
				while (next.equals(f)) {
					next = floors.get(random.nextInt(floors.size() - 1));
				}
				System.out.println("Elevator Sent to floor " + next.getName());
				elevator.call(next);
				state = SimulationState.AFTER;
			} else {
				System.out.println(elevator.getPersonRiding().getName() 
						+ " has is riding the elevator and is at floor " 
						+ elevator.getCurrentFloor().getName());
			}
		} else if (state.equals(SimulationState.WAITING)) {
			if (!elevator.isMoving()) {
				// let the person on and send the elevator to a random floor
				Floor f = elevator.getCurrentFloor();
				System.out.println("Elevator has arrived at floor " + elevator.getCurrentFloor().getName() 
					+ " and " + f.getPersonWaiting().getName() + " has stepped on."); 
				elevator.enter(f.depart());
				Floor next = floors.get(random.nextInt(floors.size() - 1));
				
				System.out.println(elevator.getPersonRiding().getName()
						+ " has called the elevator to floor " + next.getName());
				elevator.call(next);
				state = SimulationState.RIDING;
			}
		} else if (state.equals(SimulationState.AFTER)) {
			if (!elevator.isMoving()) {
				state = SimulationState.CALLING;
				System.out.println("The elevator has stopped at floor " 
						+ elevator.getCurrentFloor().getName());
			} else {
				System.out.println("The elevator is at floor " 
						+ elevator.getCurrentFloor().getName());
			}
		}
		elevator.move();
	}
	
	/**
	 * 
	 * <p>Provides a visualization of the building.</p>
	 * 
	 * </p>Shows each of the floors and where the elevator currently is. It also shows where the
	 * person is, either on a floor or in the elevator.</p> 
	 * 
	 * @return a string containing the visualization.
	 */
	public String getBuildingVisualization() {
		StringBuilder b = new StringBuilder();
		for (Floor f: floors) {
			b.append(f.toString());
			b.append("|");
			if (elevator.isOnFloor(f)) {
				b.append(elevator.toString());
			}
			b.append(System.lineSeparator());
		}
		b.append("Elevator destination:" + elevator.getDestinationFloor());
		return b.toString();
		
	}
	
	/**
	 * 
	 * Returns the name of the building
	 * 
	 * @return the name of the building
	 */
	public String getName() {
		return name;
	}
	
}
