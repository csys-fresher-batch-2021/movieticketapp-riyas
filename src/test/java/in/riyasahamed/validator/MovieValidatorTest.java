package in.riyasahamed.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import in.riyasahamed.service.MovieService;

public class MovieValidatorTest {

	/**
	 * This test case is for valid Movie Details
	 */
	@Test
	public void testValidMovieDetails() {
		try {
			MovieService.addMovieDetails("Riyas", "riyas", (float) 8.5);
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * This test case is for Invalid Movie Name
	 */
	@Test
	public void testwithinvalidMovieName() {
		try {
			MovieService.addMovieDetails(null, "vijay", (float) 8.0);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Movie Name", e.getMessage());
		}
	}

	/**
	 * This test case is for Invalid Actor Name
	 */
	@Test
	public void testwithinvalidActorName() {
		try {
			MovieService.addMovieDetails("Master", null, (float) 8.0);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Actor Name", e.getMessage());
		}
	}

	/**
	 * This test case is for Invalid Rating
	 */
	@Test
	public void testwithinvalidRating() {
		try {
			MovieService.addMovieDetails("Master", "vijay", (float) 12);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Invalid Rating - Rating Must be 1 to 10", e.getMessage());
		}
	}

	/**
	 * This test case is for Already Added Movie
	 */
	@Test
	public void testwithAlreadyAddedMovie() {
		try {
			MovieService.addMovieDetails("Master", "vijay", (float) 8);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Movie Already Added", e.getMessage());
		}
	}

	/**
	 * This test case is for Already Added Movie
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testwithValidMovieNameForCheckMovie() throws ClassNotFoundException, SQLException {
		try {
			MovieValidator.checkMovie("master", "vijay");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * This test case is for Already Added Movie
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testwithInvalidMovieForCheckMovie() throws ClassNotFoundException, SQLException {
		try {
			MovieValidator.checkMovie("24", "surya");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Movie Does Not Exists", e.getMessage());
		}
	}
}
