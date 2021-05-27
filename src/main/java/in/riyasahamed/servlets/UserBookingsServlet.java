package in.riyasahamed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.riyasahamed.dto.TicketDTO;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.TicketService;
import in.riyasahamed.service.UserService;

/**
 * Servlet implementation class UserBookingsServlet
 */
@WebServlet("/UserBookingsServlet")
public class UserBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserBookingsServlet() {
        super();
        //Default Constructor
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
			UserDTO user=UserService.findByUserName(loggedInUsername);
			Integer userId=user.getUserId();
			List<TicketDTO> tickets = TicketService.getUserBookingDetails(userId);
			request.setAttribute("TICKET_DETAILS", tickets);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserBookingDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException  | ServiceException e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("UserBookingDetails.jsp?errorMessage=" + errorMessage);
		}			
	}

}
