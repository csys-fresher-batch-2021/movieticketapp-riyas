package in.riyasahamed.service;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dao.SeatDAO;
import in.riyasahamed.dto.SeatDTO;

public class SeatService {

	private SeatService() {
		// Default Constructor
	}
	
	private static List<SeatDTO> seats=new ArrayList<>();
	
	/**
	 * This Method returns all the Seat Types
	 * @return
	 */
	public static List<SeatDTO> getSeatTypes() {
		SeatDAO seat=SeatDAO.getInstance();
		try {
			seats=seat.getSeatTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seats;
	}

}
