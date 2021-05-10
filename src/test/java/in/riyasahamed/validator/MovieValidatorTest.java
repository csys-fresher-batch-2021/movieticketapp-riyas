package in.riyasahamed.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import in.riyasahamed.service.MovieService;

public class MovieValidatorTest {

	/**
	 * This test case is for valid Movie Details
	 */
	@Test
	public void testValidMovieDetails() {
		try {
			MovieService.addMovieDetails("Master", "Vijay", (float) 8.5);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * This test case is for Invalid Movie Details
	 */
	@Test
	public void testinvalidMovieDetails() {
		try {
			MovieService.addMovieDetails(null, "vijay", (float) 8.0);
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertEquals("Invalid Movie Name", e.getMessage());
		}
	}

}
