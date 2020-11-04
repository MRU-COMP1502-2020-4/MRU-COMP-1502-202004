package comp1502.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FloorTest {

	@Test
	void testConstructor() {
		String expectedName = "Test";
		Floor f  = new Floor(expectedName);
		assertEquals(expectedName, f.getName());
		assertNull(f.getPersonWaiting());
		assertFalse(f.hasPersonWaiting());
	}
	
	@Test
	void testArrive() {
		Floor f  = new Floor("Test");
		Person p = new Person("Tester");
		f.arrive(p);
		assertTrue(f.hasPersonWaiting());
		assertEquals(p, f.getPersonWaiting());
	}
	
	@Test 
	void testToStringWithoutPerson() {
		String expectedName = "Test";
		Floor f  = new Floor(expectedName);
		assertEquals(expectedName+"-Nobody", f.toString());
	}
	
	@Test 
	void testToStringWithPerson() {
		String expectedName = "Test";
		String personName = "Alice";
		Floor f  = new Floor(expectedName);
		Person p = new Person(personName);
		f.arrive(p);
		assertEquals(expectedName+"-"+personName, f.toString());
	}
	
	@Test
	void testDepart() {
		Floor f  = new Floor("Test");
		Person p = new Person("Tester");
		f.arrive(p);
		Person exiter = f.depart();
		assertFalse(f.hasPersonWaiting());
		assertNull(f.getPersonWaiting());
		assertEquals(p, exiter);
	}

}
