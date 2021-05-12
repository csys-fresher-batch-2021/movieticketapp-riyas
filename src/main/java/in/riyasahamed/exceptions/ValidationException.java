package in.riyasahamed.exceptions;

public class ValidationException extends RuntimeException {
	
	/**
	 * This Exception is for Invalid Details
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}

}
