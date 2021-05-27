package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

	public List<Ticket> getAllBookings() {
	
		final List<Ticket> tickets = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try { // Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "\r\n"
					+ "select b.id, u.name as user, b.movie_id, m.movie_name as movie_name, u.mobile_number as mobile_number , b.booking_date ,b.showdate , b.seat_type, b.tickets,b.total_price, b.status \r\n"
					+ "from users u, movies m , booking_details b  where b.user_id= u.id and b.movie_id=m.id;\r\n"
					+ "";

			// Executing Query Statement

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {
				
				Ticket ticket = new Ticket();
				Movie movie=new Movie();
				Seat seat = new Seat();
				User user = new User();
				Integer bookigId=result.getInt("id");
				String name=result.getString("user");
				Integer movieId=result.getInt("movie_id");
				String movieName=result.getString("movie_name");
				Long mobileNumber=result.getLong("mobile_number");
				Timestamp bookingDate=result.getTimestamp("booking_date");
				LocalDateTime bDate=bookingDate.toLocalDateTime();
				Date showDate=result.getDate("showdate");
				LocalDate sDate = showDate.toLocalDate();
				String seatType= result.getString("seat_type");
				Integer noOftickets=result.getInt("tickets");
				Float price=result.getFloat("total_price");
				String status=result.getString("status");
				user.setName(name);
				user.setMobileNumber(mobileNumber);
				seat.setSeatType(seatType);
				movie.setName(movieName);
				movie.setMovieId(movieId);
				ticket.setTicketId(bookigId);
				ticket.setBookingDate(bDate);
				ticket.setNoOfTickets(noOftickets);
				ticket.setShowDate(sDate);
				ticket.setTotalPrice(price);
				ticket.setStatus(status);
				ticket.setMovie(movie);
				ticket.setSeat(seat);
				ticket.setUser(user);
				
				tickets.add(ticket);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch Movies");
		} finally {
			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		
		return tickets;
	}
	
	public List<Ticket> getUserBookings(Integer userId) {
		
		final List<Ticket> tickets = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;

		try { // Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select b.id, u.name as user, b.movie_id, m.movie_name as movie_name, u.mobile_number as mobile_number , b.booking_date ,b.showdate , b.seat_type, b.tickets,b.total_price, b.status \r\n"
					+ "from users u, movies m , booking_details b  where b.user_id= u.id and b.movie_id=m.id and u.id= ? ;\r\n"
					+ "";

			// Executing Query Statement

			pst = connection.prepareStatement(sql);
			
			pst.setInt(1, userId);

			result = pst.executeQuery();

			while (result.next()) {
				
				Ticket ticket = new Ticket();
				Movie movie=new Movie();
				Seat seat = new Seat();
				User user = new User();
				Integer bookigId=result.getInt("id");
				String name=result.getString("user");
				Integer movieId=result.getInt("movie_id");
				String movieName=result.getString("movie_name");
				Long mobileNumber=result.getLong("mobile_number");
				Timestamp bookingDate=result.getTimestamp("booking_date");
				LocalDateTime bDate=bookingDate.toLocalDateTime();
				Date showDate=result.getDate("showdate");
				LocalDate sDate = showDate.toLocalDate();
				String seatType= result.getString("seat_type");
				Integer noOftickets=result.getInt("tickets");
				Float price=result.getFloat("total_price");
				String status=result.getString("status");
				user.setName(name);
				user.setMobileNumber(mobileNumber);
				seat.setSeatType(seatType);
				movie.setName(movieName);
				movie.setMovieId(movieId);
				ticket.setTicketId(bookigId);
				ticket.setBookingDate(bDate);
				ticket.setNoOfTickets(noOftickets);
				ticket.setShowDate(sDate);
				ticket.setTotalPrice(price);
				ticket.setStatus(status);
				ticket.setMovie(movie);
				ticket.setSeat(seat);
				ticket.setUser(user);
				
				tickets.add(ticket);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch Movies");
		} finally {
			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		
		return tickets;
	}

}
