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
import in.riyasahamed.validator.TicketValidator;

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

	/**
	 * This Method is Used to Delete the Movie Details
	 * @param name
	 * @param actor
	 */
	public static void deleteMovieDetails(String name, String actor) {
		try {
			MovieValidator.checkMovie(name, actor);
			movieDAO.deleteMovie(name, actor);
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

	public static void checkTickets(Integer id, Integer noOfTickets) {
		try {
			TicketValidator.checkAvailabilty(id, noOfTickets);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Tickets Not Available");
		}
	}

	
	/**
	 * This Method is Used to Fetch Available Tickets of the Particular Movie
	 * @param id
	 * @return
	 */
	public static Integer getAvailableTickets(Integer id) {

		Movie movie = movieDAO.findMovieByMovieId(id);

		int availableTickets = movie.getTickets();

		return availableTickets;
	}

	public static Map<Integer, Integer> getBookedTickets(LocalDate showDate , LocalTime showTime) {

		Map<Integer, Integer> bookedTickets = null;
		try {
			bookedTickets = movieDAO.getBookedTickets(showDate, showTime);
		} catch (Exception e) {
			throw new ServiceException("Unable to Get Available Tickets");
		}
		return bookedTickets;
		
	}


}
