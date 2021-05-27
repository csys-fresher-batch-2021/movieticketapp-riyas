package in.riyasahamed.validator;

import in.riyasahamed.dao.MovieDAO;
import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Movie;

public class TicketValidator {
	
	public TicketValidator() {
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

	

}
