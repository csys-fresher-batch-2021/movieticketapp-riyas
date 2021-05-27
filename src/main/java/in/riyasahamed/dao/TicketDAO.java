package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.model.Seat;
import in.riyasahamed.model.Ticket;
import in.riyasahamed.model.User;
import in.riyasahamed.util.ConnectionUtil;

public class TicketDAO {

	private static final TicketDAO instance = new TicketDAO();

	public static TicketDAO getInstance() {
		return instance;
	}

	/**
	 * This Methods stores Booking Details in DataBase
	 * 
	 * @param ticket
	 * @throws DBException
	 */
	public void addTicketDetails(Ticket ticket) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into booking_details(user_id,movie_id,showdate,booking_date,total_price,seat_type,tickets) values( ?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			Movie movie = ticket.getMovie();
			Seat seat = ticket.getSeat();
			User user = ticket.getUser();
			pst.setInt(1, user.getUserId());
			pst.setInt(2, movie.getMovieId());
			Date showDate = Date.valueOf(ticket.getShowDate());
			pst.setDate(3, showDate);
			Timestamp bookingDate = Timestamp.valueOf(ticket.getBookingDate());
			pst.setTimestamp(4, bookingDate);
			pst.setFloat(5, ticket.getTotalPrice());
			pst.setString(6, seat.getSeatType());
			pst.setInt(7, ticket.getNoOfTickets());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Book Movie");
		} finally {
			ConnectionUtil.closeConnection(pst, connection);
		}
	}
	
	/*
	 * public void getAllBookings() { final List<Ticket> tickets = new
	 * ArrayList<>();
	 * 
	 * try { // Get the Connection
	 * 
	 * Connection connection = ConnectionUtil.getConnection();
	 * 
	 * // Query Statement
	 * 
	 * String sql = "";
	 * 
	 * // Executing Query Statement
	 * 
	 * PreparedStatement pst = connection.prepareStatement(sql);
	 * 
	 * ResultSet result = pst.executeQuery();
	 * 
	 * while (result.next()) {
	 * 
	 * // Getting the Values
	 * 
	 * }
	 * 
	 * // Closing the Connection ConnectionUtil.closeConnection(result, pst,
	 * connection); } catch (SQLException e) { e.printStackTrace(); throw new
	 * DBException("Unable to Fetch Movies"); } //return movies;
	 * 
	 * }
	 */
	
}
