package comp1502.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testConstruction() {
		String name = "Testy";
		Person p = new Person(name);
		assertEquals(name, p.getName());
	}

}
