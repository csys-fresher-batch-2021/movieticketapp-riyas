package in.riyasahamed.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.dto.SeatDTO;
import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.PricingService;
import in.riyasahamed.service.TicketService;
import in.riyasahamed.service.UserService;

/**
 * Servlet implementation class BookMovieServlet
 */
@WebServlet("/BookMovieServlet")
public class BookMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookMovieServlet() {
		// Default Constructor
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String movieName = request.getParameter("name");
		String actor = request.getParameter("actor");
		String dateStr = request.getParameter("date");
		String seatType = request.getParameter("seat");
		String showTimeStr = request.getParameter("time");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("LOGGED_IN_USER");
		try {
			LocalDate showDate = LocalDate.parse(dateStr);
			LocalTime showTime = LocalTime.parse(showTimeStr); 
			LocalDateTime bookingDate = LocalDateTime.now();
			Integer numberOfTickets = Integer.parseInt(request.getParameter("tickets"));
			UserDTO user = UserService.findByUserName(username);
			Integer userId = user.getUserId();
			Integer movieId = Integer.parseInt(request.getParameter("movieId"));
			Float totalPrice = PricingService.getPrice(seatType, numberOfTickets);
			MovieService.checkTickets(movieId, numberOfTickets);
			TicketDTO ticket = new TicketDTO();
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setMovieId(movieId);
			movieDTO.setName(movieName);
			movieDTO.setActor(actor);
			ticket.setMovie(movieDTO);
			SeatDTO seatDTO = new SeatDTO();
			seatDTO.setSeatType(seatType);
			ticket.setSeat(seatDTO);
			ticket.setNoOfTickets(numberOfTickets);
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(userId);
			ticket.setUser(userDTO);
			ticket.setTotalPrice(totalPrice);
			ticket.setShowDate(showDate);
			ticket.setBookingDate(bookingDate);
			ticket.setShowTime(showTime);
			TicketService.addTicketDetails(ticket);
			request.setAttribute("BOOKING_DETAILS", ticket);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("BookingDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage=e.getMessage();
			response.sendRedirect("movieDetails.jsp?errorMessage=" + errorMessage);
		}

	}
}
