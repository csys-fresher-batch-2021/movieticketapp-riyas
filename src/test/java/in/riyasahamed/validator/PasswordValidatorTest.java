package in.riyasahamed.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordValidatorTest {

	/**
	 * This test case is for valid Password
	 */
	@Test
	public void testValidPassword() {
		try {
			PasswordValidator.isValidPassword("riyas@1212");
			assertTrue(true);
		} catch (RuntimeException e) {
			fail();
		}
	}

	/**
	 * In this Test Case Password which has more than fifteen character is entered
	 */
	@Test
	public void testWithUserNameMoreThanSpecifiedChar() {
		try {
			PasswordValidator.isValidPassword("riyasahamed123456");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Password", e.getMessage());
		}
	}
	
	/**
	 * In this Test Password which has less than seven characters is entered
	 */
	@Test
	public void testWithUserNameLessThanSpecifiedChar() {
		try {
			PasswordValidator.isValidPassword("riyas");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Password", e.getMessage());
		}
	}
}
