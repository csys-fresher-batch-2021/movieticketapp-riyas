package in.riyasahamed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.TicketService;

/**
 * Servlet implementation class AllBookingsServlet
 */
@WebServlet("/AllBookingsServlet")
public class AllBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AllBookingsServlet() {
        super();
       //Default Constructor
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<TicketDTO> tickets = TicketService.getAllBookingDetails();
			request.setAttribute("TICKET_DETAILS", tickets);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AllBookingDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException | ServiceException e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("AllBookingDetails.jsp?errorMessage=" + errorMessage);
		}
	}

}
