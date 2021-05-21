package in.riyasahamed.service;

import java.util.List;

import in.riyasahamed.convertor.UserConverter;
import in.riyasahamed.dao.UserDAO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.User;
import in.riyasahamed.validator.UserValidator;

public class UserService {

	private UserService() {
		// Default Constructor
	}

	/**
	 * This Method is used to Register the User
	 * @param userDTO
	 */
	public static void registerUser(UserDTO userDTO) {

		try {
			UserValidator.isValidUser(userDTO);
			UserDAO userDAO = UserDAO.getInstance();
			User user = UserConverter.toUser(userDTO); // Input :dto output: model
			userDAO.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method is Used to Fetch All Users
	 * @return 
	 */
	public static List<UserDTO> getUsers() {
		UserDAO userDAO = UserDAO.getInstance();
		List<User> allUsers = userDAO.getAllUsers();
		return UserConverter.toUserDTO(allUsers);
	}

}
