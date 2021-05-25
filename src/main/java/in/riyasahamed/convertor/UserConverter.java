package in.riyasahamed.convertor;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.model.User;

public class UserConverter {

	private UserConverter() {
		// Default COnstructor
	}

	/**
	 * This Method Converts DTO object to Model Object
	 * 
	 * @param dto
	 * @return
	 */
	public static User toUser(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setUserName(dto.getUserName());
		user.setMobileNumber(dto.getMobileNumber());
		user.setUserId(dto.getUserId());
		return user;
	}

	/**
	 * This Method Converts Model object to DTO object
	 * 
	 * @param user
	 * @return
	 */
	public static UserDTO toUserDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setUserName(user.getUserName());
		dto.setPassword(user.getPassword());
		dto.setMobileNumber(user.getMobileNumber());
		dto.setUserId(user.getUserId());
		return dto;
	}

	/**
	 * This method converts List of Model objects to List of DTO objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<UserDTO> toUserDTO(List<User> users) {
		List<UserDTO> dtoList = new ArrayList<>();
		for (User user : users) {
			UserDTO dto = toUserDTO(user);
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * This Method Converts List of DTO objects into Model Objects
	 * 
	 * @param users
	 * @return
	 */
	public static List<User> toUser(List<UserDTO> users) {
		List<User> userList = new ArrayList<>();
		for (UserDTO user : users) {
			User dto = toUser(user);
			userList.add(dto);
		}
		return userList;
	}

}
