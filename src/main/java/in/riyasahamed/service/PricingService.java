package in.riyasahamed.service;

import java.util.List;

import in.riyasahamed.dao.SeatDAO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Seat;

public class PricingService {

	private PricingService() {
		// Default Constructor
	}

	/**
	 * This Method is Used to Calculate Total Price for the Booking
	 * @param seatType
	 * @param noOfTickets
	 * @return
	 */
	public static Float getPrice(String seatType, int noOfTickets) {

		Float totalPrice=(float) 0;
		try {
			SeatDAO seatDAO = SeatDAO.getInstance();
			List<Seat> seats = seatDAO.getSeatTypes();
			int price = 0;
			for (Seat seat : seats) {
				if (seatType.equalsIgnoreCase(seat.getSeatType())) {
					price = seat.getPrice();
					break;
				}
			}

			int baseFare = price * noOfTickets;

			totalPrice = (float) (baseFare + (baseFare * 0.18));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Unable to Calculate Price");
		}

		return totalPrice;

	}

}
