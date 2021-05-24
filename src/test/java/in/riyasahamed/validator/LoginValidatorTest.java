package in.riyasahamed.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginValidatorTest {

	@Test
	public void testwithValidLogin() {

		try {
			LoginValidator.isValidLogin("riyas21052", "Riiyas@12");
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testwithInValidLogin() {

		try {
			LoginValidator.isValidLogin("riyas", "Riiyas@12");
			fail();
		} catch (Exception e) {
			assertEquals("Invalid Login", e.getMessage());
		}
	}

	@Test
	public void testwithNullInputs() {

		try {
			LoginValidator.isValidLogin(null, "Riiyas@12");
			fail();
		} catch (Exception e) {
			assertEquals("User Name or Password cannot be Null", e.getMessage());
		}
	}

}
