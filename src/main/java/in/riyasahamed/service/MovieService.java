package in.riyasahamed.service;

import in.riyasahamed.model.Movie;
import in.riyasahamed.validator.MovieValidator;

public class MovieService {

	public static void addMovieDetails(String name, String actor, Float rating) {
		Movie movie1 = null;
		try {
			MovieValidator.validateMovieDetails(name, actor, rating);
			movie1 = new Movie(name, actor, rating);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(movie1);

	}

}
