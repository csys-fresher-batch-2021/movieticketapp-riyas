package in.riyasahamed.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValidatorTest {
	
	/**
	 *In this test case Valid Email Id is Entered 
	 */
	@Test
	public void testwithValidEmail() {

		try {
			EmailValidator.isValidEmail("riyas21052@gmail.com");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 *In this test case Email Id is Entered as Empty String
	 */
	@Test
	public void testwithEmailAsEmptyString() {
		try {
			EmailValidator.isValidEmail("");
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Email Cannot be Null", e.getMessage());
		}
	}

	/**
	 *In this test case Email Id is Entered as Empty String
	 */
	@Test
	public void testwithEmailAsNull() {
		try {
			EmailValidator.isValidEmail(null);
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Email Cannot be Null", e.getMessage());
		}
	}

	/**
	 *In this test case Invalid Email is Entered
	 */
	@Test
	public void testwithInvalidEmail() {
		try {
			EmailValidator.isValidEmail("riyas21052");
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Invalid Email", e.getMessage());
		}
	}
}
