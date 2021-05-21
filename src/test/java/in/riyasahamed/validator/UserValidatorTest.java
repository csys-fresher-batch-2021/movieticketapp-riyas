package in.riyasahamed.validator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.riyasahamed.dto.UserDTO;

public class UserValidatorTest {

	/**
	 * This test case is for valid Details
	 * @throws SQLException 
	 */
	@Test
	public void testValidUserDetails(){
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas Ahamed");
			user.setEmail("riyas21054@gmail.com");
			user.setMobileNumber(8345442550l);
			user.setUserName("riyas2105289");
			user.setPassword("riyas_12");
			UserValidator.isValidUser(user);	
			assertTrue(true);
		} catch (RuntimeException e) {
			fail();
		}

	}

	/**
	 * This test case is for Invalid User Name
	 */
	@Test
	public void testWithInvalidUserName() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas Ahamed");
			user.setEmail("rias21052@gmail.com");
			user.setMobileNumber(9345442290l);
			user.setUserName("riyas");
			user.setPassword("riyas_12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid User Name", e.getMessage());
		}
	}
	
	/**
	 * This test case is for Invalid Name
	 */
	@Test
	public void testWithInvalidName() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas12");
			user.setEmail("riyas210525@gmail.com");
			user.setMobileNumber(9445442250l);
			user.setUserName("riyas31052");
			user.setPassword("riyas_12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid Name", e.getMessage());
		}
	}
	
	/**
	 * This test case is for Invalid Password
	 */
	@Test
	public void testWithInvalidPassword() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas");
			user.setEmail("riyas210524@gmail.com");
			user.setMobileNumber(9345442280l);
			user.setUserName("riyas41052");
			user.setPassword("riyas");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid Password", e.getMessage());
		}
	}
	
	/**
	 * This test case is for Invalid Email
	 */
	@Test
	public void testWithInvalidEmail() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas");
			user.setEmail("riyas21052@gmail");
			user.setMobileNumber(9655442250l);
			user.setUserName("riyas2105289");
			user.setPassword("riyas@12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid Email", e.getMessage());
		}
	}
	
	/**
	 * This test case is for Invalid Mobile Number
	 */
	@Test
	public void testWithInvalilMobileNumber() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas");
			user.setEmail("riyas210582@gmail.com");
			user.setMobileNumber(2345442250l);
			user.setUserName("riyas21982");
			user.setPassword("riyas@12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Invalid Mobile Number", e.getMessage());
		}
	}
	
	/**
	 * This test case is for Same Mobile Number
	 */
	@Test
	public void testWithSameMobileNumber() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas");
			user.setEmail("riyas2105280@gmail.com");
			user.setMobileNumber(9345442250l);
			user.setUserName("riyas210521");
			user.setPassword("riyas@12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Mobile Number Already Registered", e.getMessage());
		}
	}
	
	/**
	 * This test case is for Same Email
	 */
	@Test
	public void testWithSameEmail() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas");
			user.setEmail("riyas21052@gmail.com");
			user.setMobileNumber(9375442250l);
			user.setUserName("riyas210521");
			user.setPassword("riyas@12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("Email ID Already Registered", e.getMessage());
		}
	}
	/**
	 * This test case is for Same User Name
	 */
	@Test
	public void testWithSameUserName() {
		try {
			UserDTO user = new UserDTO();
			user.setName("Riyas");
			user.setEmail("riyas21053@gmail.com");
			user.setMobileNumber(9375442250l);
			user.setUserName("riyas21052");
			user.setPassword("riyas@12");
			UserValidator.isValidUser(user);
			fail();
		} catch (Exception e) {
			assertEquals("User Name Already Registered", e.getMessage());
		}
	}
	
	
}
