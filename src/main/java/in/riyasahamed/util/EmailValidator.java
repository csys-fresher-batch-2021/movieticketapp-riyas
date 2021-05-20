package in.riyasahamed.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.riyasahamed.exceptions.ValidationException;

public class EmailValidator {

	public static void isValidEmail(String email) {

		if (email == null || email.trim().equals("")) {
			throw new ValidationException("Email Cannot be Null");
		}
		String Condition = "[A-Za-z0-9+._-]+@[a-z]+[.][a-z]{2,3}";
		Pattern pattern = Pattern.compile(Condition);
		Matcher matcher = pattern.matcher(email);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Email");
		}
	}
}
