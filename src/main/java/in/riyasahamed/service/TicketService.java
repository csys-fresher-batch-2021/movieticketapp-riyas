package in.riyasahamed.service;

import in.riyasahamed.convertor.TicketConvertor;
import in.riyasahamed.dao.TicketDAO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Ticket;

public class TicketService {
	
	private TicketService() {
		//Default Constructor
	}
	
	/**
	 * This Method will store the Booking Details 
	 * @param ticketDTO
	 */
	public static void addTicketDetails(TicketDTO ticketDTO) {
		try {
			Ticket ticket = TicketConvertor.toTicket(ticketDTO);
			TicketDAO ticketDAO= TicketDAO.getInstance();
			ticketDAO.addTicketDetails(ticket);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
