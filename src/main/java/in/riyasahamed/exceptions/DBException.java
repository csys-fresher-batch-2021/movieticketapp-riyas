package in.riyasahamed.exceptions;

public class DBException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This Method will give exception for Database exceptions
	 * @param message
	 */
	public DBException(String message) {
		super(message);
	}

}
