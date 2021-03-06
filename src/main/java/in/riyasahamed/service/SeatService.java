package in.riyasahamed.service;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.convertor.SeatConvertor;
import in.riyasahamed.dao.SeatDAO;
import in.riyasahamed.dto.SeatDTO;
import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Seat;

public class SeatService {

	private SeatService() {
		// Default Constructor
	}
	
	
	/**
	 * This Method returns all the Seat Types
	 * @return
	 */
	public static List<SeatDTO> getSeatTypes() {
		SeatDAO seat=SeatDAO.getInstance();
		List<Seat> seats=new ArrayList<>();
		List<SeatDTO> seatsList= new ArrayList<>();
		try {
			seats=seat.getSeatTypes();
		    seatsList=SeatConvertor.toSeatDTO(seats);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		return seatsList;
	}
	
	/**
	 * This Method is used to Update the Screen Status after addition or deletion of movie
	 * @param status
	 * @param screen
	 */
	public static void updateScreenStatus(String status , String screen) {
		
		SeatDAO dao = new SeatDAO();
		
		try {
			dao.updateScreenStatus(status ,screen);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
