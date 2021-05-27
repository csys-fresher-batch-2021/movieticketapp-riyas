package in.riyasahamed.service;

import java.util.List;

import in.riyasahamed.convertor.UserConverter;
import in.riyasahamed.dao.UserDAO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.User;
import in.riyasahamed.validator.AdminValidator;
import in.riyasahamed.validator.LoginValidator;
import in.riyasahamed.validator.UserDeatailsValidator;
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
		List<User> allUsers = null;
		try {
			UserDAO userDAO = UserDAO.getInstance();
			allUsers = userDAO.getAllUsers();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return UserConverter.toUserDTO(allUsers);
	}
	
	/**
	 * This Method is Used to Find the User Details by UserName
	 * @param userName
	 * @return
	 */
	public static UserDTO findByUserName(String userName) {
		User user = new User();
		try {
			UserDAO userDAO = UserDAO.getInstance();
			user = userDAO.findByUserName(userName);
			UserDeatailsValidator.isUserExists(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return UserConverter.toUserDTO(user);
	}
	
	/**
	 * This Methods Validates the User Login
	 * @param userName
	 * @param password
	 */
	public static void checkUserLogin(String userName, String password) {
		try {
			LoginValidator.isValidLogin(userName, password);
		} catch (Exception e) {
			throw new ServiceException("Invalid Login Credentails");
		}
	}
	
	public static void checkAdminLogin(String userName, String password) {
		try {
			AdminValidator.validateAdmin(userName, password);
		} catch (Exception e) {
			throw new ServiceException("Invalid Login Credentials");
		}
	}

}
