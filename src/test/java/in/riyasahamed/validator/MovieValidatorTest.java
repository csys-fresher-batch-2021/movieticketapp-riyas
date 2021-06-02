package in.riyasahamed.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

public class MovieValidatorTest {

	/**
	 * In this Test Case Valid Movie Details are entered
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void testwithValidMovieNameForCheckMovie() throws ClassNotFoundException, SQLException {
		try {
			MovieValidator.checkMovie("master", "vijay");
			assertTrue(true);
		} catch (RuntimeException e) {
			fail();
		}
	}

	/**
	 * In this Test Case Invalid Movie Details are entered
	 * 
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
