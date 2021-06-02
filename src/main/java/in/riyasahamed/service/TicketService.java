package in.riyasahamed.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import in.riyasahamed.convertor.TicketConvertor;
import in.riyasahamed.dao.TicketDAO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Ticket;

public class TicketService {

	private TicketService() {
		// Default Constructor
	}

	private static TicketDAO ticketDAO = TicketDAO.getInstance();

	/**
	 * This Method will store the Booking Details
	 * 
	 * @param ticketDTO
	 */
	public static void addTicketDetails(TicketDTO ticketDTO) {
		try {
			Ticket ticket = TicketConvertor.toTicket(ticketDTO);
			ticketDAO.addTicketDetails(ticket);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * This Method will return the Booking Details of all Users
	 * @return
	 */
	public static List<TicketDTO> getAllBookingDetails() {

		List<Ticket> tickets = null;

		try {
			tickets = ticketDAO.getAllBookings();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return TicketConvertor.toTicketDTO(tickets);

	}

	/**
	 * This Method will return the Booking Details of Particular User
	 * @return
	 */
	public static List<TicketDTO> getUserBookingDetails(Integer userId) {

		List<Ticket> tickets = null;

		try {
			tickets = ticketDAO.getUserBookings(userId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return TicketConvertor.toTicketDTO(tickets);

	}
	
	/**
	 * This Method will Cancel the Booking Details
	 * @param id
	 */
	public static void cancelBooking(Integer id) {
		
		try {
			ticketDAO.cancelBooking(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * This Method is Used to update the status of booking after the show is finished
	 */
	public static void updateAllBookings() {
		
		try {
				LocalDate showDate = LocalDate.now();
				ticketDAO.updateAllBookings(showDate);
		} catch (Exception e) {
			 throw new ServiceException(e.getMessage());
		}		
	}
	
	/**
	 * This Method is used to fetch all the show times
	 * @return
	 */
	public static List<LocalTime> getShowTimes() {
		List<LocalTime> showTimes = null;

		try {
			showTimes = ticketDAO.getShowTimes();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return showTimes;

	}

}
