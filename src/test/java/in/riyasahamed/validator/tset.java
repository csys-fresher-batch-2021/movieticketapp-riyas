package in.riyasahamed.validator;

import java.util.List;

import in.riyasahamed.dao.UserDAO;
import in.riyasahamed.model.User;

public class tset {

	public static void main(String[] args) {
		UserDAO user=UserDAO.getInstance();
		List<User> users=user.getAllUsers();
		
		for (User user1: users) {
			System.out.println(user1.getEmail());
			System.out.println(user1.getName());
			System.out.println(user1.getPassword());
			
		}

	}

}
