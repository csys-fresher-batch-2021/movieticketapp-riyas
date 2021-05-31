package in.riyasahamed.validator;

import java.util.List;

import in.riyasahamed.dao.UserDAO;
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
		
		UserDAO userDAO = UserDAO.getInstance();
		List<Admin> admins = userDAO.getAllAdminDetails();
		
		boolean valid = false;
		if ((userName != null) && (password != null)) {
			for (Admin admin : admins) {
				if (userName.equals(admin.getUserName()) && (password.equals(admin.getPassword()))) {
					valid = true;
					break;
				}
			}
			if (!valid) {
				throw new ValidationException("Invalid Login");
			}
		} else {
			throw new ValidationException("User Name or Password cannot be Null");
		}

	}
}
