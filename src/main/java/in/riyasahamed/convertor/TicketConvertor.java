package in.riyasahamed.convertor;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.model.Ticket;

public class TicketConvertor {

	private TicketConvertor() {
		// Default Constructor
	}

	/**
	 * This Method will Converts Ticket DTO  objects to Model Objects
	 * @param dto
	 * @return
	 */
	public static Ticket toTicket(TicketDTO dto) {
		Ticket ticket = new Ticket();
		ticket.setActor(dto.getActor());
		ticket.setBookingDate(dto.getBookingDate());
		ticket.setMovieId(dto.getMovieId());
		ticket.setMovieName(dto.getMovieName());
		ticket.setName(dto.getName());
		ticket.setNoOfTickets(dto.getNoOfTickets());
		ticket.setSeatType(dto.getSeatType());
		ticket.setShowDate(dto.getShowDate());
		ticket.setStatus(dto.getStatus());
		ticket.setTicketId(dto.getTicketId());
		ticket.setTotalPrice(dto.getTotalPrice());
		ticket.setUserId(dto.getUserId());
		ticket.setUserName(dto.getUserName());

		return ticket;
	}

	/**
	 * This Method will Converts Model  object to Ticket DTO Objects
	 * @param dto
	 * @return
	 */
	public static TicketDTO toTicketDTO(Ticket ticket) {
		TicketDTO dto = new TicketDTO();
		dto.setActor(ticket.getActor());
		dto.setBookingDate(ticket.getBookingDate());
		dto.setMovieId(ticket.getMovieId());
		dto.setMovieName(ticket.getMovieName());
		dto.setName(ticket.getName());
		dto.setNoOfTickets(ticket.getNoOfTickets());
		dto.setSeatType(ticket.getSeatType());
		dto.setShowDate(ticket.getShowDate());
		dto.setStatus(ticket.getStatus());
		dto.setTicketId(ticket.getTicketId());
		dto.setTotalPrice(ticket.getTotalPrice());
		dto.setUserId(ticket.getUserId());
		dto.setUserName(ticket.getUserName());

		return dto;
	}

	/**
	 * This Method will Converts List of Model  objects to  List of Ticket DTO Objects
	 * @param dto
	 * @return
	 */
	public static List<TicketDTO> toTicketDTO(List<Ticket> tickets) {
		List<TicketDTO> dtoList = new ArrayList<>();
		for (Ticket ticket : tickets) {
			TicketDTO ticketDTO = TicketConvertor.toTicketDTO(ticket);
			dtoList.add(ticketDTO);
		}
		return dtoList;
	}

	/**
	 * This Method will Converts List of DTO  objects to Model Objects
	 * @param dto
	 * @return
	 */
	public static List<Ticket> toTicket(List<TicketDTO> dto) {
		List<Ticket> ticketList = new ArrayList<>();
		for (TicketDTO ticketdto : dto) {
			Ticket ticket = TicketConvertor.toTicket(ticketdto);
			ticketList.add(ticket);
		}

		return ticketList;
	}
}
