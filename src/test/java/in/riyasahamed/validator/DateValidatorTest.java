package in.riyasahamed.validator;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class DateValidatorTest {

	/**
	 * In this Test Case Date before the Current Date is Entered
	 */
	@Test
	public void testwithBeforeDate() {

		String dateStr = "2021-05-21";
		LocalDate date = LocalDate.parse(dateStr);
		boolean valid = DateValidator.isAfterDate(date);
		assertFalse(valid);

	}
	
	/**
	 * In this Test Case Date After the Current Date is Entered
	 */
	@Test
	public void testwithAfterDate() {
		String dateStr = "2021-05-28";
		LocalDate date = LocalDate.parse(dateStr);
		boolean valid = DateValidator.isAfterDate(date);
		assertTrue(valid);
	}
	
	/**
	 * In this Test Case Current Date is Entered
	 */
	@Test
	public void testwithCurrentDate() {
		String dateStr = "2021-05-27";
		LocalDate date = LocalDate.parse(dateStr);
		boolean valid = DateValidator.isAfterDate(date);
		assertFalse(valid);
	}
	
	

}
