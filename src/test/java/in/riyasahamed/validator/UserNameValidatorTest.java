package in.riyasahamed.validator;

import static org.junit.Assert.*;

import org.junit.Test;


public class UserNameValidatorTest {

	/**
	 * This test case is for valid User Name
	 */
	@Test
	public void testValidUserName() {
		try {
			UserNameValidator.isValidUserName("riyas21052");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * In this Test Case User Name is Entered as Null
	 */
	@Test
	public void testwithUserNameAsNull() {
		try {
			UserNameValidator.isValidUserName(null);
			fail();
		} catch (RuntimeException e) {
			assertEquals("User Name Cannot be Null", e.getMessage());
		}
	}
	
	/**
	 * In this Test Case User Name which has more than fifteen character is entered
	 */
	@Test
	public void testWithUserNameMoreThanSpecifiedChar() {
		try {
			UserNameValidator.isValidUserName("riyasahamed123456");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid User Name", e.getMessage());
		}
	}
	
	/**
	 * In this Test Case User Name which has less than seven characters is entered
	 */
	@Test
	public void testWithUserNameLessThanSpecifiedChar() {
		try {
			UserNameValidator.isValidUserName("riyas");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid User Name", e.getMessage());
		}
	}
	
	
}
