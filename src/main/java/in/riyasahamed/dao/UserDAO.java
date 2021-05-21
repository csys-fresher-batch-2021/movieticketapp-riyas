package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.model.User;
import in.riyasahamed.util.ConnectionUtil;

public class UserDAO {

	// Creating Object
	private static final UserDAO instance = new UserDAO();

	// This Method returns the object which can be used for access methods in DAO
	public static UserDAO getInstance() {
		return instance;
	}

	public void addUser(User user) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into users(name,email,mobile_number,user_name,password) values( ?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setLong(3, user.getMobileNumber());
			pst.setString(4, user.getUserName());
			pst.setString(5, user.getPassword());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DBException("Unable to Add User");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}

	public List<User> getAllUsers()throws DBException {

		List<User> users = new ArrayList<>();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from users";

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {
				User user = new User();
				String name = result.getString("name");
				String userName = result.getString("user_name");
				String email = result.getString("email");
				String password = result.getString("password");
				Long mobileNumber = result.getLong("mobile_number");

				user.setName(name);
				user.setUserName(userName);
				user.setEmail(email);
				user.setMobileNumber(mobileNumber);
				user.setPassword(password);

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get User Details");

		} finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}

		return users;

	}

}
