package in.riyasahamed.exceptions;

public class InvalidMovieNameException extends RuntimeException{
	
	/**
	 * This Exception is for Invalid Movie Name.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMovieNameException(String message) {
		super(message);
	}

}
