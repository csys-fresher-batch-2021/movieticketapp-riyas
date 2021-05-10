package in.riyasahamed.validator;

public class MovieValidator {

	public static void validateMovieDetails(String name, String actor, Float rating) {
		if (name == null || name.trim().equals("")) {
			throw new RuntimeException("Invalid Movie Name");
		}
		else if(actor == null || actor.trim().equals("")) {
			throw new RuntimeException("Invalid actor Name");
		}
		else if(rating < 0 || rating > 10 ) {
			throw new RuntimeException("Invalid Rating");
		}
	}

}
