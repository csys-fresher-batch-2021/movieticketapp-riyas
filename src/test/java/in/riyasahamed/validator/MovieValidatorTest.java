package in.riyasahamed.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import in.riyasahamed.service.MovieService;


public class MovieValidatorTest {

	@Test
	public void testValidMovieDetails() {
		try {
			//MovieValidator.validateMovieDetails("Master", "vijay", (float) 8.0);
			MovieService.addMovieDetails("Master", "Vijay", (float) 8.5);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testinvalidMovieDetails() {
		try {
			MovieService.addMovieDetails(null, "vijay", (float) 8.0);
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertEquals("Invalid Movie Name",e.getMessage());
		}
	}

}
