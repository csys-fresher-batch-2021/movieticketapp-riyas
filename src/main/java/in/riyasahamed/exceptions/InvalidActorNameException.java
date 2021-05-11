package in.riyasahamed.exceptions;

public class InvalidActorNameException extends RuntimeException{
	
	/**
	 * This Exception is for Invalid Movie Name.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidActorNameException(String message) {
		super(message);
	}

}
