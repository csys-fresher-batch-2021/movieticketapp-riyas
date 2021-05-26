package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * This Method Add Movie Details in Movie
	 * 
	 * @param movie
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addMovie(Movie movie) throws DBException {

		try {
			// Get Connection
			Connection connection = ConnectionUtil.getConnection();

			// Sql command
			String sql = "insert into movies( movie_name,actor_name,rating,available_tickets ) values (?,?,?,?)";

			// Execution Step
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, movie.getName());
			pst.setString(2, movie.getActor());
			pst.setFloat(3, movie.getRating());
			pst.setInt(4, movie.getTickets());
			pst.executeUpdate();

			// Closing the Session
			ConnectionUtil.closeConnection(pst, connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Add Movie");
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

		try {
			// Get the Connection

			Connection connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select * from movies";

			// Executing Query Statement

			PreparedStatement pst = connection.prepareStatement(sql);

			ResultSet result = pst.executeQuery();

			while (result.next()) {

				// Getting the Values

				String movieName = result.getString("movie_name");
				String actorName = result.getString("actor_name");
				float rating = result.getFloat("rating");
				Integer movieId = result.getInt("id");
				Integer tickets = result.getInt("available_tickets");

				// Store the value in an object

				Movie movie = new Movie();
				movie.setName(movieName);
				movie.setActor(actorName);
				movie.setRating(rating);
				movie.setMovieId(movieId);
				movie.setTickets(tickets);
				movies.add(movie);
			}

			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch Movies");
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
	public void deleteMovie(String name, String actor) throws DBException {

		try {
			// Get the Connection
			Connection connection = ConnectionUtil.getConnection();

			// SQL Command
			String sql = "delete from movies where movie_name = ? and actor_name= ? ";

			// Executing the Query
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, name);
			pst.setString(2, actor);

			pst.executeUpdate();

			// Closing the Connection
			ConnectionUtil.closeConnection(pst, connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Delete Movie");
		}

	}

	/**
	 * This Method will Search the movie from Database
	 * 
	 * @param movieName
	 * @return
	 * @return
	 */
	public Movie findByMovieName(String movieName) throws DBException {
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement pst = null;

		Movie movie = new Movie();

		try {

			connection = ConnectionUtil.getConnection();

			String sql = " select * from movies where movie_name ILIKE ? ";

			pst = connection.prepareStatement(sql);

			pst.setString(1, movieName);

			result = pst.executeQuery();

			while (result.next()) {

				// Getting the Values

				String name = result.getString("movie_name");
				String actorName = result.getString("actor_name");
				float rating = result.getFloat("rating");
				Integer movieId = result.getInt("id");
				Integer tickets = result.getInt("available_tickets");

				// Store the value in an object

				movie.setName(name);
				movie.setActor(actorName);
				movie.setRating(rating);
				movie.setMovieId(movieId);
				movie.setTickets(tickets);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Get Movie Details");

		} finally {
			ConnectionUtil.closeConnection(result, pst, connection);
		}

		return movie;

	}

	/**
	 * This Method will return the list of movie details which contains the keyword.
	 * @return
	 * @throws DBException
	 */
	public List<Movie> findMovieByKeyword(String keyword) throws DBException {

		final List<Movie> movies = new ArrayList<>();

		try {
			// Get the Connection

			Connection connection = ConnectionUtil.getConnection();

			// Query Statement

			String sql = "select * from movies where movie_name ILIKE  ? OR actor_name ILIKE ?;";

			// Executing Query Statement

			PreparedStatement pst = connection.prepareStatement(sql);
			
			
			
			pst.setString(1,"%" + keyword + "%" );
			
			pst.setString(2, "%" + keyword + "%");

			ResultSet result = pst.executeQuery();

			while (result.next()) {

				// Getting the Values

				String movieName = result.getString("movie_name");
				String actorName = result.getString("actor_name");
				float rating = result.getFloat("rating");
				Integer movieId = result.getInt("id");
				Integer tickets = result.getInt("available_tickets");

				// Store the value in an object

				Movie movie = new Movie();
				movie.setName(movieName);
				movie.setActor(actorName);
				movie.setRating(rating);
				movie.setMovieId(movieId);
				movie.setTickets(tickets);
				movies.add(movie);
			}

			// Closing the Connection
			ConnectionUtil.closeConnection(result, pst, connection);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Fetch Movies");
		}
		return movies;

	}
}
