package comp1502.peoplecounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoorTest {

	@Test
	void testConstructor() {
		Door testDoor = new Door();
		assertEquals(0, testDoor.getNumberOfEnterances());
		assertEquals(0, testDoor.getNumberOfExits());
	}

}
