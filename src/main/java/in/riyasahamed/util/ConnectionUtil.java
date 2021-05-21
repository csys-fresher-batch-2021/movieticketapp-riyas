package in.riyasahamed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.riyasahamed.exceptions.DBException;

public class ConnectionUtil {
	/**
	 * This Method Will get the Connection from the Data BAse
	 * 
	 * @return
	 * @throws DBException
	 */
	public static Connection getConnection() throws DBException {
		// Step 2: Get the connection
		Connection connection = null;
		try {
			String driverClass = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost/movieticketapp_db";
			String username = "postgres";
			String password = "Riiyas@12";
			// Step 1: Load the jdbc driver in memory
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get Connection From Data Base");
		}
		return connection;
	}

	public static void closeConnection(Statement pst, Connection connection) {
		try {
			if (pst != null) {
				pst.close();
				System.out.println("Statement Closed");
			}

			if (connection != null) {
				connection.close();
				System.out.println("Connection Closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to CLose the connection");
		}

	}

	public static void closeConnection(ResultSet rs, Statement pst, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
				System.out.println("Result Set Closed");
			}
			if (pst != null) {
				pst.close();
				System.out.println("Statement Closed");
			}

			if (connection != null) {
				connection.close();
				System.out.println("Connection Closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to CLose the connection");
		}

	}

}
