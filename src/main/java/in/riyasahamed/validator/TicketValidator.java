package in.riyasahamed.validator;

import java.time.LocalDate;

public class TicketValidator {
	
	private TicketValidator() {
		// Default Constructor
	}

	

	public static boolean checkShowDate(LocalDate showDate) {
		LocalDate date = LocalDate.now();
		boolean valid = false;
		if(showDate.isBefore(date)) {
			valid = true;
		}		
		return valid;
	}
	

}
