package in.riyasahamed.validator;

import java.time.LocalDate;

import in.riyasahamed.exceptions.ValidationException;

public class DateValidator {
	
	private DateValidator() {
		// Default Constructor
	}
	public static void isAfterDate(LocalDate showDate) {
		LocalDate date = LocalDate.now();
		boolean valid = showDate.isAfter(date);
		if(!valid) {
			throw new ValidationException("Cannot Cancel Movie After the Show");
		}
		
	}

	

}
