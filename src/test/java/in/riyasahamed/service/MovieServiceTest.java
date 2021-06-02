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
			MovieService.updateMovieStatus("INACTIVE","Master","vijay");
			assertTrue(true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	/**
	 * This test case is for Delete Movie Feature 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testWithInValidMovieDetails() throws ClassNotFoundException, SQLException {
		try {
			MovieService.updateMovieStatus("INACTIVE","vikaram","kamal");
			fail();
		} catch (RuntimeException e) {
			assertEquals("Movie Does Not Exists",e.getMessage());
		}

	}

}
