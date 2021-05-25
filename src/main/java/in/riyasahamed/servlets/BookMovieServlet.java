package in.riyasahamed.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.riyasahamed.dto.MovieDTO;
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
      //Default Constructor
    }

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieName=request.getParameter("name");
		String actor=request.getParameter("actor");
		String dateStr=request.getParameter("date");
		String seatType=request.getParameter("seat");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("LOGGED_IN_USER");
		try {
			LocalDate showDate = LocalDate.parse(dateStr);
			LocalDateTime bookingDate=LocalDateTime.now();
			Integer numberOfTickets=Integer.parseInt(request.getParameter("tickets"));
			UserDTO user=UserService.findByUserName(username);
			MovieDTO movie = MovieService.findByMovieName(movieName);
			String name=user.getName();
			Integer movieId=movie.getMovieId();
			Integer userId=user.getUserId();
			Float totalPrice=PricingService.getPrice(seatType, numberOfTickets);
			TicketDTO ticket=new TicketDTO();
			ticket.setMovieName(movieName);
			ticket.setName(name);
			ticket.setSeatType(seatType);
			ticket.setNoOfTickets(numberOfTickets);
			ticket.setActor(actor);
			ticket.setTotalPrice(totalPrice);
			ticket.setShowDate(showDate);
			ticket.setBookingDate(bookingDate);
			ticket.setUserId(userId);
			ticket.setMovieId(movieId);
			TicketService.addTicketDetails(ticket);
			response.sendRedirect("BookingDetails.jsp");
	}catch(Exception e) {
		String message=e.getMessage();
		e.printStackTrace();
		response.sendRedirect("BookingDetails.jsp?message=" + message);		
	}

}
}
