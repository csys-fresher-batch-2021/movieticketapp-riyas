package in.riyasahamed.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public static void addMovieDetails(MovieDTO movieDTO ) {
		try {
			
			MovieValidator.validateMovieDetails(movieDTO.getName(), movieDTO.getActor(), movieDTO.getRating());
			Movie movie = MovieConvertor.toMovie(movieDTO);			
			movieDAO.addMovie(movie);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method is Used to Delete the Movie Details
	 * @param name
	 * @param actor
	 */
	public static void updateMovieStatus(String name, String actor) {
		try {
			MovieValidator.checkMovie(name, actor);
			movieDAO.updateMovieStatus(name, actor);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method is Used to get All Movies from the DataBase
	 * @return
	 */
	public static List<MovieDTO> getAllMovies() {

		List<Movie> movies = new ArrayList<>();
		try {

			movies = movieDAO.getAllMovies();

		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return MovieConvertor.toMovieDTO(movies);
	}

	/**
	 * This Method is Used to Search Movie Details by using movie name or actor name
	 * @param keyword
	 * @return
	 */
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


	

	public static Map<Integer, Integer> getBookedTickets(LocalDate showDate , LocalTime showTime , String seatType) {

		Map<Integer, Integer> bookedTickets = null;
		try {
			bookedTickets = movieDAO.getBookedTickets(showDate, showTime , seatType);
		} catch (Exception e) {
			throw new ServiceException("Unable to Get Available Tickets");
		}
		return bookedTickets;
		
	}


}
