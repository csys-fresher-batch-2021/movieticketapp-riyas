package in.riyasahamed.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class MovieServiceTest {

	/**
	 * This test case is for Delete Movie Feature
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testWithValidMovieDetails() throws ClassNotFoundException, SQLException {
		try {
			MovieService.deleteMovieDetails("Master","vijay");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}

}
