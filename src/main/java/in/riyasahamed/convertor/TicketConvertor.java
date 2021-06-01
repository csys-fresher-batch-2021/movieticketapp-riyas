package in.riyasahamed.convertor;

import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.dto.SeatDTO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.model.Movie;
import in.riyasahamed.model.Seat;
import in.riyasahamed.model.Ticket;
import in.riyasahamed.model.User;

public class TicketConvertor {

	private TicketConvertor() {
		// Default Constructor
	}

	/**
	 * This Method will Converts Ticket DTO objects to Model Objects
	 * 
	 * @param dto
	 * @return
	 */
	public static Ticket toTicket(TicketDTO dto) {
		Ticket ticket = new Ticket();

		ticket.setBookingDate(dto.getBookingDate());
		ticket.setNoOfTickets(dto.getNoOfTickets());

		// copy movie dto to model
		Movie movie = MovieConvertor.toMovie(dto.getMovie());
		Seat seat = SeatConvertor.toSeat(dto.getSeat());
		User user = UserConverter.toUser(dto.getUser());
		ticket.setMovie(movie);
		ticket.setSeat(seat);
		ticket.setUser(user);
		ticket.setShowDate(dto.getShowDate());
		ticket.setStatus(dto.getStatus());
		ticket.setTicketId(dto.getTicketId());
		ticket.setTotalPrice(dto.getTotalPrice());
		ticket.setShow_time(dto.getShowTime());
		ticket.setScreen(dto.getScreen());
		return ticket;
	}

	/**
	 * This Method will Converts Model object to Ticket DTO Objects
	 * 
	 * @param dto
	 * @return
	 */
	public static TicketDTO toTicketDTO(Ticket ticket) {
		TicketDTO dto = new TicketDTO();
		MovieDTO movieDTO = MovieConvertor.toMovieDTO(ticket.getMovie());
		SeatDTO seatDTO = SeatConvertor.toSeatDTO(ticket.getSeat());
		UserDTO userDTO = UserConverter.toUserDTO(ticket.getUser());
		dto.setBookingDate(ticket.getBookingDate());
		dto.setMovie(movieDTO);
		dto.setSeat(seatDTO);
		dto.setUser(userDTO);
		dto.setNoOfTickets(ticket.getNoOfTickets());
		dto.setShowDate(ticket.getShowDate());
		dto.setStatus(ticket.getStatus());
		dto.setTicketId(ticket.getTicketId());
		dto.setTotalPrice(ticket.getTotalPrice());
		dto.setShowTime(ticket.getShow_time());
		dto.setScreen(ticket.getScreen());
		return dto;
	}

	/**
	 * This Method will Converts List of Model objects to List of Ticket DTO Objects
	 * 
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
	 * This Method will Converts List of DTO objects to Model Objects
	 * 
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
