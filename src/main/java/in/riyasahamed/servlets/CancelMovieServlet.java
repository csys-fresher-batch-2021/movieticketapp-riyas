 package in.riyasahamed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			TicketService.cancelBooking(bookingId);
			response.sendRedirect("UserBookingsServlet");
		} catch (Exception e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("UserBookingDetails.jsp?errorMessage=" + errorMessage);			
		}
	}

}
