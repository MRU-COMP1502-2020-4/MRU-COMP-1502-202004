package comp1502.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ElevatorTest {

	@Test
	void testConstructor() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		assertEquals(name, e.getName());
		assertEquals(floors.get(0), e.getCurrentFloor());
		assertNull(e.getDestinationFloor());
		assertNull(e.getPersonRiding());
		assertFalse(e.isMoving());
		assertTrue(e.isOnFloor(floors.get(0)));
		assertFalse(e.isOnFloor(floors.get(1)));
		assertFalse(e.isOnFloor(floors.get(2)));
	}
	
	@Test
	void testEnter() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		Person p = new Person("Tester");
		e.enter(p);
		assertTrue(e.hasPersonRiding());
		assertEquals(p, e.getPersonRiding());
	}
	
	@Test
	void testExit() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		
		Person p = new Person("Tester");
		e.enter(p);
		Person exiter = e.exit();
		assertFalse(e.hasPersonRiding());
		assertNull(e.getPersonRiding());
		assertEquals(p, exiter);
	}
	
	@Test
	void testCall() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		e.call(floors.get(2));
		assertEquals(floors.get(2), e.getDestinationFloor());
	}
	
	@Test
	void testMoveUp() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		
		e.call(floors.get(2));
		e.move();
		assertTrue(e.isMoving());
		assertEquals(floors.get(1), e.getCurrentFloor());
	}
	
	@Test
	void testMoveUpStops() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		
		e.call(floors.get(2));
		e.move();
		e.move();
		assertEquals(floors.get(2), e.getCurrentFloor());
		assertFalse(e.isMoving());
		
	}

	@Test
	void testMoveDown() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		
		e.call(floors.get(2));
		e.move();
		e.move();
		e.call(floors.get(0));
		assertTrue(e.isMoving());
		e.move();
		assertEquals(floors.get(1), e.getCurrentFloor());
	}
	
	@Test
	void testMoveDownStops() {
		ArrayList<Floor> floors = new ArrayList<>();
		floors.add(new Floor("1"));
		floors.add(new Floor("2"));
		floors.add(new Floor("3"));
		floors.add(new Floor("4"));
		
		String name = "Test";
		
		Elevator e = new Elevator(name, floors);
		
		e.call(floors.get(3));
		e.move();
		e.move();
		e.call(floors.get(1));
		e.move();
		e.move();
		assertEquals(floors.get(1), e.getCurrentFloor());
		assertFalse(e.isMoving());
	}

	
}
