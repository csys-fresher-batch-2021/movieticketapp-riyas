package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.model.Seat;
import in.riyasahamed.util.ConnectionUtil;

public class SeatDAO {

	// Creating Object
	private static final SeatDAO instance = new SeatDAO();

	// This Method returns the object which can be used for access methods in DAO
	public static SeatDAO getInstance() {
		return instance;
	}

	public List<Seat> getSeatTypes() {

		List<Seat> seatTypes = new ArrayList<>();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from seat_types";

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {
				String seatType = result.getString("seat_type");
				int price = result.getInt("price");
				Seat seat = new Seat(seatType, price);
				seatTypes.add(seat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get Seat Types");

		} finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}

		return seatTypes;
	}

	public Map<String, String> getAllScreens() {

		Map<String, String> screens = new HashMap<>();
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from screens";

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {
				String screen = result.getString("name");
				String status = result.getString("status");
				screens.put(screen, status);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get Available Screens");

		} finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}

		return screens;

	}
	
	public void updateScreenStatus( String status ,String screen) {
		Connection connection = null;

		PreparedStatement pst = null;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			
			String sql = "update  screens set status= ? where name = ? ";
			
			

			// Execution Step
			pst = connection.prepareStatement(sql);
			
			pst.setString(1, status);
			pst.setString(2, screen);
			

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Update Screen Status");
		} finally {

			// Closing the Session
			ConnectionUtil.closeConnection(pst, connection);

		}

	}

}
