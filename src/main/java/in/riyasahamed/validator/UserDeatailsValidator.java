package in.riyasahamed.validator;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.User;

public class UserDeatailsValidator {

	private UserDeatailsValidator() {
		// Default Constructor
	}

	public static void isUserExists(User user) {
		
		System.out.println("Function Calls");
		
		System.out.println(user);

		if (user.getUserName() == null) {
			System.out.println("No User");
			throw new ValidationException("User Does Not Exists");
			
		}
	}

}
