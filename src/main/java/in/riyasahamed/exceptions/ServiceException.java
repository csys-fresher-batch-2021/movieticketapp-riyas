package in.riyasahamed.exceptions;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method will rise exception if there is any problem in servoce class
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}
}
