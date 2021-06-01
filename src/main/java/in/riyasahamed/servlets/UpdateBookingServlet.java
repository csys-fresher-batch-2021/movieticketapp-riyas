package in.riyasahamed.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.service.TicketService;

/**
 * Servlet implementation class UpdateBookingServlet
 */
@WebServlet("/UpdateBookingServlet")
public class UpdateBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateBookingServlet() {
        super();
       //Default Constructor
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			TicketService.updateAllBookings();
			String infoMessage="Successfully Updated Statuses";
			response.sendRedirect("AllBookingsServlet?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("AllBookingDetails.jsp?errorMessage=" + errorMessage);	
		}
		
	}

}
