package in.riyasahamed.validator;



import in.riyasahamed.exceptions.ValidationException;

public class PasswordValidator {

	public static void isValidPassword(String password) {

		if (password == null || password.trim().equals("")) {
			throw new ValidationException("Password Cannot be Null");
		}
		if(password.length()<7 || password.length()>15) {
			throw new ValidationException("Invalid Password");
		}	
	}
}
