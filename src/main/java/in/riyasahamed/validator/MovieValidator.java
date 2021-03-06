package in.riyasahamed.validator;

import java.sql.SQLException;
import java.util.List;

import in.riyasahamed.dao.MovieDAO;
import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Movie;

public class MovieValidator {

	private MovieValidator() {
		// Default Constructor
	}

	/**
	 * This Method Validates the Movie Details
	 * 
	 * @param name
	 * @param actor
	 * @param rating
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void validateMovieDetails(String name, String actor, Float rating){
		MovieDAO movieDAO = MovieDAO.getInstance();
		List<Movie> movies = movieDAO.getAllMovies();
		for (Movie movie : movies) {
			if (name == null || name.trim().equals("")) {
				throw new ValidationException("Invalid Movie Name");
			} else if (actor == null || actor.trim().equals("")) {
				throw new ValidationException("Invalid Actor Name");
			} else if (rating < 0 || rating > 10) {
				throw new ValidationException("Invalid Rating - Rating Must be 1 to 10");
			} else if (name.equalsIgnoreCase(movie.getName()) && actor.equalsIgnoreCase(movie.getActor())) {
				throw new ValidationException("Movie Already Added");
			}
		}
	}

	/**
	 * This Method checks whether the movie already entered in Database
	 * @param name
	 * @param actor
	 */
	public static void checkMovie(String name, String actor){
		MovieDAO movieDAO = MovieDAO.getInstance();
		List<Movie> movies = movieDAO.getAllMovies();
		boolean valid = false;
		for (Movie movie : movies) {
			if (name.equalsIgnoreCase(movie.getName()) && actor.equalsIgnoreCase(movie.getActor())) {
				valid = true;
				break;
			}
		}
		if (!valid) {
			throw new ValidationException("Movie Does Not Exists");
		}
	}
	
	/**
	 * This method Validates the list returned by the DAO
	 * @param movies
	 */
	public static void isMovieExists(List<Movie> movies) {
		if(movies.isEmpty()) {
			throw new ValidationException("Movie Not Found");
		}
	}
}