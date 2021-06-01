package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.util.ConnectionUtil;

public class MovieDAO {

	private MovieDAO() {
		// Default Constructor

	}

	// Creating Object
	private static final MovieDAO instance = new MovieDAO();

	// This Method returns the object which can be used for access methods in DAO
	public static MovieDAO getInstance() {
		return instance;
	}

	private static final String MOVIE = "movie_name";
	private static final String ACTOR = "actor_name";
	private static final String RATING = "rating";
	private static final String SCREEN = "screen";
	private static final String STATUS = "status";
	private static final String FETCH_ERROR = "Unable to Fetch Movies";

	/**
	 * This Method Add Movie Details in Movie
	 * 
	 * @param movie
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addMovie(Movie movie) throws DBException {

		Connection connection = null;

		PreparedStatement pst = null;

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "insert into movies( movie_name,actor_name,rating,screen) values (?,?,?,?)";

			// Execution Step
			pst = connection.prepareStatement(sql);

			pst.setString(1, movie.getName());
			pst.setString(2, movie.getActor());
			pst.setFloat(3, movie.getRating());
			pst.setString(4, movie.getScreen());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add Movie");
		} finally {

			// Closing the Session
			ConnectionUtil.closeConnection(pst, connection);

		}
	}

	/**
	 * This Method Will returns all Movie Details Stored in DataBase
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Movie> getAllMovies() throws DBException {

		final List<Movie> movies = new ArrayList<>();

		Connection connection = null;

		PreparedStatement pst = null;

		ResultSet result = null;

		try {
			// Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select * from movies order by rating desc";

			// Executing Query Statement

			pst = connection.prepareStatement(sql);

			result = pst.executeQuery();

			while (result.next()) {

				// Getting the Values

				String movieName = result.getString(MOVIE);
				String actorName = result.getString(ACTOR);
				float rating = result.getFloat(RATING);
				Integer movieId = result.getInt("id");
				String screen = result.getString(SCREEN);
				String status = result.getString(STATUS);

				// Store the value in an object

				Movie movie = new Movie();
				movie.setName(movieName);
				movie.setActor(actorName);
				movie.setRating(rating);
				movie.setMovieId(movieId);
				movie.setScreen(screen);
				movie.setStatus(status);
				movies.add(movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(FETCH_ERROR);
		} finally {
			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		return movies;

	}

	/**
	 * This Method will Delete the Movie in DataBase
	 * 
	 * @param name
	 * @param actor
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateMovieStatus(String name, String actor) throws DBException {

		Connection connection = null;

		PreparedStatement pst = null;

		try {
			// Get the Connection
			connection = ConnectionUtil.getConnection();

			// SQL Command
			String sql = "update movies set status= 'INACTIVE' where movie_name = ? and actor_name= ? ";

			// Executing the Query
			pst = connection.prepareStatement(sql);

			pst.setString(1, name);
			pst.setString(2, actor);

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Delete Movie");
		} finally {
			// Closing the Connection
			ConnectionUtil.closeConnection(pst, connection);
		}

	}

	/**
	 * This Method will return the list of movie details which contains the keyword.
	 * 
	 * @return
	 * @throws DBException
	 */
	public List<Movie> findMovieByKeyword(String keyword) throws DBException {

		final List<Movie> movies = new ArrayList<>();

		Connection connection = null;

		PreparedStatement pst = null;

		ResultSet result = null;

		try {
			// Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select * from movies where movie_name ILIKE  ? OR actor_name ILIKE ?;";

			// Executing Query Statement

			pst = connection.prepareStatement(sql);

			pst.setString(1, "%" + keyword + "%");

			pst.setString(2, "%" + keyword + "%");

			result = pst.executeQuery();

			while (result.next()) {

				// Getting the Values

				String movieName = result.getString(MOVIE);
				String actorName = result.getString(ACTOR);
				float rating = result.getFloat(RATING);
				Integer movieId = result.getInt("id");
				String screen = result.getString(SCREEN);
				String status = result.getString(STATUS);


				// Store the value in an object

				Movie movie = new Movie();
				movie.setName(movieName);
				movie.setActor(actorName);
				movie.setRating(rating);
				movie.setMovieId(movieId);
				movie.setScreen(screen);
				movie.setStatus(status);
				
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(FETCH_ERROR);
		} finally {
			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);
		}
		return movies;
	}

	/**
	 * This Method will return the list of movie details which contains the keyword.
	 * 
	 * @return
	 * @throws DBException
	 */
	public Movie findMovieByMovieId(Integer id) throws DBException {

		Movie movie = new Movie();

		Connection connection = null;

		PreparedStatement pst = null;

		ResultSet result = null;
		try {
			// Get the Connection

			connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select * from movies where id= ? ;";

			// Executing Query Statement

			pst = connection.prepareStatement(sql);

			pst.setInt(1, id);

			result = pst.executeQuery();

			while (result.next()) {

				// Getting the Values

				String movieName = result.getString(MOVIE);
				String actorName = result.getString(ACTOR);
				float rating = result.getFloat(RATING);
				Integer movieId = result.getInt("id");
				String screen = result.getString(SCREEN);
				String status = result.getString(STATUS);


				// Store the value in an object

				movie.setName(movieName);
				movie.setActor(actorName);
				movie.setRating(rating);
				movie.setMovieId(movieId);
				movie.setScreen(screen);
				movie.setStatus(status);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(FETCH_ERROR);
		} finally {

			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);

		}
		return movie;
	}

	public Map<Integer, Integer> getBookedTickets(LocalDate date , LocalTime time , String seatType) {

		Connection connection = null;

		PreparedStatement pst = null;

		ResultSet result = null;

		Map<Integer, Integer> bookedTickets = new HashMap<>();

		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "select  b.movie_id , SUM(b.tickets) AS total_tickets  from booking_details b, movies m \r\n"
					+ "where b.status !='CANCELLED' and showdate = ? and show_time = ? and seat_type ILIKE ? and b.movie_id = m.id group by b.movie_id;\r\n"
					+ " ";

			// Execution Step
			pst = connection.prepareStatement(sql);
			Date showDate = Date.valueOf(date);
			pst.setDate(1, showDate);
			Time showTime = Time.valueOf(time);
			pst.setTime(2, showTime);
			pst.setString(3, seatType);
			result = pst.executeQuery();
			while (result.next()) {
				Integer id = result.getInt("movie_id");
				Integer tickets = result.getInt("total_tickets");
				bookedTickets.put(id, tickets);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to get Booked Tickets");
		} finally {

			// Closing the Session
			ConnectionUtil.closeConnection(pst, connection);

		}

		return bookedTickets;
	}

}
