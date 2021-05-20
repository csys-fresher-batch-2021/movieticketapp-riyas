package in.riyasahamed.service;

import in.riyasahamed.dao.MovieDAO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.validator.MovieValidator;

public class MovieService {
	
	private MovieService() {
		// Default Constructor
	}

	private static  MovieDAO movieDAO=MovieDAO.getInstance();
	
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
			movieDAO.addMovie(movie);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	public static void deleteMovieDetails(String name, String actor){ 	
		try {
			MovieValidator.checkMovie(name, actor);
			movieDAO.deleteMovie(name,actor);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
