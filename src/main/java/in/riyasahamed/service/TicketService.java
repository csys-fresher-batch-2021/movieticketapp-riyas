package in.riyasahamed.service;

import java.util.List;

import in.riyasahamed.convertor.TicketConvertor;
import in.riyasahamed.dao.TicketDAO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Ticket;

public class TicketService {
	
	private TicketService() {
		//Default Constructor
	}
	
	private static TicketDAO ticketDAO= TicketDAO.getInstance();
	
	/**
	 * This Method will store the Booking Details 
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
	
	public static List<TicketDTO> getAllBookingDetails() {
		
		List<Ticket> tickets = null;
		
		try {
			tickets= ticketDAO.getAllBookings();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		 return TicketConvertor.toTicketDTO(tickets);
		
	}
	
public static List<TicketDTO> getUserBookingDetails(Integer userId) {
		
		List<Ticket> tickets = null;
		
		try {
			tickets= ticketDAO.getUserBookings(userId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		 return TicketConvertor.toTicketDTO(tickets);
		
	}
	
	
}
