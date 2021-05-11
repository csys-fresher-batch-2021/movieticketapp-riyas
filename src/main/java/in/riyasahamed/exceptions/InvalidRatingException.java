package in.riyasahamed.exceptions;

public class InvalidRatingException extends RuntimeException {
	
	/**
	 * This Exception is for Invalid rating
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRatingException(String message) {
		super(message);
	}

}

