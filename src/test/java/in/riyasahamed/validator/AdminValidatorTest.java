package in.riyasahamed.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminValidatorTest {

	/**
	 * In this Test Case Valid Username and Password are Entered.
	 */
	@Test
	public void testWithValidUserNameAndPassword() {
		try {
			AdminValidator.validateAdmin("admin", "Admin@12");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * In this Test Case invalid Username and Valid Password are Entered.
	 */
	@Test
	public void testWithInvalidUserNameAndValidPassword() {
		try {
			AdminValidator.validateAdmin("riyas", "Admin@12");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid UserName",e.getMessage());			
		}
	}
	
	/**
	 * In this Test Case Valid Username and Invalid Password are Entered.
	 */
	@Test
	public void testWithValidUserNameAndInvalidPassword() {
		try {
			AdminValidator.validateAdmin("admin", "admin@12");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Password",e.getMessage());			
		}
	}
	
	/**
	 * In this Test case user name is Entered as Null
	 * 
	 */
	@Test
	public void testWithUserNameAsNull() {
		try {
			AdminValidator.validateAdmin(null, "Admin@12");
			fail();
		} catch (RuntimeException e) {
			assertEquals("User Name Cannot be Null",e.getMessage());			
		}
	}
	
	/**
	 * In this Test case Password is Entered as Null
	 * 
	 */
	@Test
	public void testWithPasswordAsNull() {
		try {
			AdminValidator.validateAdmin("admin",null);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Password Cannot be Null",e.getMessage());			
		}
	}
}



