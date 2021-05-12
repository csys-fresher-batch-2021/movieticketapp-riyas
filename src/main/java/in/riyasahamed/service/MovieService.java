package in.riyasahamed.service;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.validator.MovieValidator;

public class MovieService {
	
	private MovieService() {
		// Default Constructor
	}

	private static final  List<Movie> movies=new ArrayList<>();
	
	/**
	 * This Method adds Movie Details..
	 * 
	 * @param name
	 * @param actor
	 * @param rating
	 */
	public static void addMovieDetails(String name, String actor, Float rating) {
		try {
			MovieValidator.validateMovieDetails(name, actor, rating);
			Movie movie = new Movie(name, actor, rating);
			movies.add(movie);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException(e.getMessage());
		}
	}
	
	public static List<Movie> getMovies() {
		return movies;
	}

}
