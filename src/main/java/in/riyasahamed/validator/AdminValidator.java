package in.riyasahamed.validator;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Admin;

public class AdminValidator {

	private AdminValidator() {
		// Default Constructor
	}

	/**
	 * This Method Validates the Admin User Name and Password
	 * @param userName
	 * @param password
	 */
	public static void validateAdmin(String userName, String password) {
		Admin admin = new Admin();
		String adminUserName=admin.getUserName();
		String adminPassword=admin.getPassword();
		if (userName == null || userName.trim().equals("")) {
			throw new ValidationException("User Name Cannot be Null");
		}
		if (password == null || password.trim().equals("")) {
			throw new ValidationException("Password Cannot be Null");
		}
		if (!userName.equals(adminUserName)) {
			throw new ValidationException("Invalid UserName");
		}
		if (!password.equals(adminPassword)) {
			throw new ValidationException("Invalid Password");
		}

	}
}
