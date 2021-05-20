package in.riyasahamed.service;

import java.util.List;

import in.riyasahamed.convertor.UserConverter;
import in.riyasahamed.dao.UserDAO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.User;
import in.riyasahamed.validator.UserValidator;

public class UserService {

	public static void registerUser(UserDTO userDTO) {

		try {
			UserValidator.isValidUser(userDTO);
			UserDAO userDAO = UserDAO.getInstance();
			User user = UserConverter.toUser(userDTO); // Input :dto output: model
			userDAO.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to Register User");
		}
	}

	public static List<UserDTO> getUsers() {
		UserDAO userDAO = UserDAO.getInstance();
		List<User> allUsers = userDAO.getAllUsers();
		List<UserDTO> userDTOList = UserConverter.toUserDTO(allUsers);
		return userDTOList;
	}

}
