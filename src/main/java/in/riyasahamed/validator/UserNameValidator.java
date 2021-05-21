package in.riyasahamed.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.riyasahamed.exceptions.ValidationException;

public class UserNameValidator {

	public static void isValidUserName(String userName) {
		if (userName == null || userName.trim().equals("")) {
			throw new ValidationException("User Name Cannot be Null");
		}
		String condition = "[a-zA-z0-9]{7,15}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(userName);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid User Name");
		}
	}
}
