package in.riyasahamed.convertor;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.model.Movie;

public class MovieConvertor {

	private MovieConvertor() {
		// Default Constructor	
	}

	/**
	 * This Method Converts Model Objects into DTO objects
	 * 
	 * @param movie
	 * @return
	 */
	public static MovieDTO toMovieDTO(Movie movie) {

		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setName(movie.getName());
		movieDTO.setActor(movie.getActor());
		movieDTO.setRating(movie.getRating());
		movieDTO.setMovieId(movie.getMovieId());
		movieDTO.setScreen(movie.getScreen());
		movieDTO.setStatus(movie.getStatus());

		return movieDTO;

	}

	/**
	 * This Method Converts DTO object into Model Object
	 * 
	 * @param movieDTO
	 * @return
	 */
	public static Movie toMovie(MovieDTO movieDTO) {

		Movie movie = new Movie();
		movie.setName(movieDTO.getName());
		movie.setActor(movieDTO.getActor());
		movie.setRating(movieDTO.getRating());
		movie.setMovieId(movieDTO.getMovieId());
		movie.setScreen(movieDTO.getScreen());
		movie.setStatus(movieDTO.getStatus());
		return movie;

	}

	/**
	 * This Method Converts List of Model Objects into List of DTO Objects
	 * 
	 * @param movies
	 * @return
	 */
	public static List<MovieDTO> toMovieDTO(List<Movie> movies) {
		List<MovieDTO> dtoList = new ArrayList<>();
		for (Movie movie : movies) {
			MovieDTO dto = MovieConvertor.toMovieDTO(movie);
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * This Method Converts List of DTO Objects into List of Model Objects
	 * 
	 * @param movies
	 * @return
	 */
	public static List<Movie> toMovie(List<MovieDTO> movies) {
		List<Movie> movieList = new ArrayList<>();
		for (MovieDTO movie : movies) {
			Movie movieModel = MovieConvertor.toMovie(movie);
			movieList.add(movieModel);
		}
		return movieList;
	}

}
