package in.riyasahamed.validator;

import java.time.LocalDate;

import in.riyasahamed.dao.MovieDAO;
import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Movie;

public class TicketValidator {
	
	private TicketValidator() {
		// Default Constructor
	}

	
	public static void checkAvailabilty(Integer id , Integer noOfTickets) {
		
		MovieDAO dao = MovieDAO.getInstance();
		
		Movie movie = dao.findMovieByMovieId(id);
		
		int availableTickets = movie.getTickets();
		
		if(noOfTickets>availableTickets) {
			throw new ValidationException("Tickets Not Available");
		}
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
