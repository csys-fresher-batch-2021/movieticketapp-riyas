package in.riyasahamed.validator;

import in.riyasahamed.exceptions.InvalidActorNameException;
import in.riyasahamed.exceptions.InvalidMovieNameException;
import in.riyasahamed.exceptions.InvalidRatingException;

public class MovieValidator {

	private MovieValidator() {
		//Default Constructor
	}
	
	/**
	 * This Method Validates the Movie Details
	 * @param name
	 * @param actor
	 * @param rating
	 */
	public static void validateMovieDetails(String name, String actor, Float rating) {
		if (name == null || name.trim().equals("")) {
			throw new InvalidMovieNameException("Invalid Movie Name");
		}
		else if(actor == null || actor.trim().equals("")) {
			throw new InvalidActorNameException("Invalid actor Name");
		}
		else if(rating < 0 || rating > 10 ) {
			throw new InvalidRatingException("Invalid Rating - Rating Must be 1 to 10");
		}
	}

}
