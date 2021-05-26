package in.riyasahamed.validator;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.User;

public class UserDeatailsValidator {

	private UserDeatailsValidator() {
		// Default Constructor
	}

	public static void isUserExists(User user) {

		if (user.getUserName() == null) {
			throw new ValidationException("User Does Not Exists");
			
		}
	}

}
