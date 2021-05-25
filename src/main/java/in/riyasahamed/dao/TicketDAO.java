package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.model.Ticket;
import in.riyasahamed.util.ConnectionUtil;

public class TicketDAO {

	private static final TicketDAO instance = new TicketDAO();
	
	public static TicketDAO getInstance() {
		return instance;
	}
	
	/**
	 * This Methods stores Booking Details in DataBase
	 * @param ticket
	 * @throws DBException
	 */
	public void addTicketDetails(Ticket ticket)throws DBException{

			Connection connection = null;
			PreparedStatement pst = null;

			try {
				connection = ConnectionUtil.getConnection();

				String sql = "insert into booking_deatails(user_id,movie_id,showdate,booking_date,total_price) values( ?,?,?,?,?)";

				pst = connection.prepareStatement(sql);
				pst.setInt(1, ticket.getUserId());
				pst.setInt(2,ticket.getMovieId());
				Date showDate=Date.valueOf(ticket.getShowDate());
				pst.setDate(3, showDate);
				Timestamp bookingDate = Timestamp.valueOf(ticket.getBookingDate());
				pst.setTimestamp(4, bookingDate);
				pst.setFloat(5,ticket.getTotalPrice());		
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Unable to Book Movie");
			} finally {
				ConnectionUtil.closeConnection(pst, connection);
			}
		}
	}

