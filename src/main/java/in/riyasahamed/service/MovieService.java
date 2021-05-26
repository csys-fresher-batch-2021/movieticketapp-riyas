package in.riyasahamed.service;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.convertor.MovieConvertor;
import in.riyasahamed.dao.MovieDAO;
import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Movie;
import in.riyasahamed.validator.MovieValidator;

public class MovieService {

	private MovieService() {
		// Default Constructor
	}

	private static MovieDAO movieDAO = MovieDAO.getInstance();

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
			throw new ServiceException(e.getMessage());
		}
	}

	public static void deleteMovieDetails(String name, String actor) {
		try {
			MovieValidator.checkMovie(name, actor);
			movieDAO.deleteMovie(name, actor);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public static List<MovieDTO> getAllMovies() {

		List<Movie> movies = new ArrayList<>();
		try {

			movies = movieDAO.getAllMovies();

		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return MovieConvertor.toMovieDTO(movies);
	}

	public static MovieDTO findByMovieName(String movieName) {
		Movie movie = movieDAO.findByMovieName(movieName);
		return MovieConvertor.toMovieDTO(movie);
	}

	public static List<MovieDTO> findMovieByKeyword(String keyword) {

		List<Movie> movies = null;

		try {
			movies = movieDAO.findMovieByKeyword(keyword);
			MovieValidator.isMovieExists(movies);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}

		return MovieConvertor.toMovieDTO(movies);
	}

}
