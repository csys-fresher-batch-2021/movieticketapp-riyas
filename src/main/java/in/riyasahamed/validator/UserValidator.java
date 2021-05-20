package in.riyasahamed.validator;

import java.util.List;

import in.riyasahamed.dao.UserDAO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.User;
import in.riyasahamed.util.EmailValidator;
import in.riyasahamed.util.MobileNumberValidator;
import in.riyasahamed.util.NameValidator;

public class UserValidator {

	public static void isValidUser(UserDTO user) {

		try {
			UserValidator.isSameUser(user);
			NameValidator.isValidName(user.getName());
			EmailValidator.isValidEmail(user.getEmail());
			MobileNumberValidator.isValidMobileNumber(user.getMobileNumber());
			UserNameValidator.isValidUserName(user.getUserName());
			PasswordValidator.isValidPassword(user.getPassword());
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
	}

	public static void isSameUser(UserDTO userDTO) {
		UserDAO userDAO = UserDAO.getInstance();
		List<User> allUsers = userDAO.getAllUsers();

		for (User userObj : allUsers) {
			if (userDTO.getEmail().equals(userObj.getEmail())) {
				throw new ValidationException("UserName Already Exists");
			}
			if (userDTO.getMobileNumber().equals(userObj.getMobileNumber())) {
				throw new ValidationException("Mobile Number Already Exists");
			}
			if (userDTO.getUserName().equals(userObj.getUserName())) {
				throw new ValidationException("Mobile Number Already Exists");
			}
		}
	}
}
