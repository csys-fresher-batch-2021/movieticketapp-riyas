 package in.riyasahamed.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.TicketService;

/**
 * Servlet implementation class CancelMovieServlet
 */
@WebServlet("/CancelMovieServlet")
public class CancelMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CancelMovieServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer bookingId=Integer.parseInt(request.getParameter("orderId"));
			Integer movieId=Integer.parseInt(request.getParameter("movieId"));
			String dateStr=request.getParameter("showDate");
			LocalDate showDate = LocalDate.parse(dateStr);
			Integer noOfTickets = Integer.parseInt(request.getParameter("tickets"));
			TicketService.cancelBooking(bookingId, showDate);
			MovieService.updateTickets(movieId, noOfTickets, "CANCEL");
			String infoMessage="Successfully Cancelled movie";
			response.sendRedirect("UserBookingDetails.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("UserBookingDetails.jsp?errorMessage=" + errorMessage);			
		}
	}

}
