package in.riyasahamed.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserServiceTest {

	@Test
	public void testWithValidUserName() {

		try {
			UserService.findByUserName("riyas21052");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testWithInValidUserName() {

		try {
			UserService.findByUserName("riyas21054");
			fail();
		} catch (Exception e) {
			assertEquals("User Does Not Exists",e.getMessage());
		}

	}
	
	

}
