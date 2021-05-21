package in.riyasahamed.validator;

import java.util.List;

import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.service.UserService;

public class LoginValidator {
	
	

	private LoginValidator() {
		// Default Constructor
	}

	public static void isValidLogin(String userName, String password) {
		List<UserDTO> users = UserService.getUsers();
		boolean valid = false;
		if ((userName != null) && (password != null)) {
			for (UserDTO userDTO : users) {
				if (userName.equals(userDTO.getUserName()) && (password.equals(userDTO.getPassword()))) {
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
