  package in.riyasahamed.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.riyasahamed.dto.SeatDTO;

public class SeatServiceTest {

	/**
	 * This Method checks whether all the seat types are added or not
	 */
	@Test
	public void testGetSeatTypes() {
		List<SeatDTO> seats=SeatService.getSeatTypes();
		assertEquals(3,seats.size());
	}

}
