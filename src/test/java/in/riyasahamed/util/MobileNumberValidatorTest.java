package in.riyasahamed.util;

import static org.junit.Assert.*;

import org.junit.Test;


public class MobileNumberValidatorTest {

	/**
	 * In this test Case Valid Mobile Number is Entered
	 */
	@Test
	public void testwithValidMobileNumber() {
		
		try {
			MobileNumberValidator.isValidMobileNumber(8345442250l);
			assertTrue(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();			
		}
	}

	/**
	 * In this test Case InValid Mobile Number is Entered
	 */
	@Test
	public void testwithInValidMobileNumber() {
		
		try {
			MobileNumberValidator.isValidMobileNumber(1234567890l);
			fail();
		}
		catch(Exception e) {
			e.printStackTrace();
			assertEquals("Invalid Mobile Number",e.getMessage());			
		}
	}
	
	/**
	 * In this test Case Mobile Number which has less than 10 numbers is Entered 
	 */
	
	@Test
	public void testwithMobileNumberLessThanTenNumbers() {		
		try {
			MobileNumberValidator.isValidMobileNumber(123456l);
			fail();
		}
		catch(Exception e) {
			e.printStackTrace();
			assertEquals("Invalid Mobile Number",e.getMessage());			
		}
	}
	
	/**
	 * In this test Case Mobile Number is Entered as Null
	 */	
	@Test
	public void testwithMobileNumberAsNull() {		
		try {
			MobileNumberValidator.isValidMobileNumber(null);
			fail();
		}
		catch(Exception e) {
			assertEquals("Mobile Number Cannot be Null",e.getMessage());			
		}
	}
	
	


}
