package in.riyasahamed.service;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.model.Seat;

public class SeatService {

	private SeatService() {
		// Default Constructor
	}
	
	private static final List<Seat> seats=new ArrayList<>();
	
	static {
	Seat seatType1= new Seat("Silver", 60);
	seats.add(seatType1);
	Seat seatType2= new Seat("Gold", 120);
	seats.add(seatType2);
	Seat seatType3= new Seat("Platinum", 180);
	seats.add(seatType3);	
	}
	
	/**
	 * This Method returns all the Seat Types
	 * @return
	 */
	public static List<Seat> getSeatTypes() {
		return seats;
	}

}
