package in.riyasahamed.util;

import static org.junit.Assert.*;

import org.junit.Test;


public class NameValidatorTest {

	/**
	 * This test case is for valid Name
	 */
	@Test
	public void testValidName() {
		try {
			NameValidator.isValidName("Riyas Ahamed Umar Ali");
			assertTrue(true);
		} catch (RuntimeException e) {
			fail();
		}

	}

	/**
	 * In this Test Case Name is Entered as Null
	 */
	@Test
	public void testwithNameAsNull() {
		try {
			NameValidator.isValidName(null);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Name Cannot be Null", e.getMessage());
		}
	}
	
	/**
	 * In this Test Case Name is Entered Which has Numbers
	 */
	@Test
	public void testwithNameHasNumber() {
		try {
			NameValidator.isValidName("Riyas12");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}
	/**
	 * In this Test Case Name is Entered Which has Special Characters
	 */
	@Test
	public void testwithNameHasSpecialCharacters() {
		try {
			NameValidator.isValidName("Riiyas@!");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}
}
