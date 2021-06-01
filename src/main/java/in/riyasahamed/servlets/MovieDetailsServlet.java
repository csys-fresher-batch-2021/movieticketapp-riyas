package in.riyasahamed.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.TicketService;

/**
 * Servlet implementation class MovieDetailsServlet
 */
@WebServlet("/MovieDetailsServlet")
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MovieDetailsServlet() {
        super();
    }

	/**
	 * This Servlet is used to diplay movie Details
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	try {
			String dateStr = request.getParameter("showDate");
			String timeStr = request.getParameter("showTime");
			String seatType = request.getParameter("seat");
			LocalTime showTime = LocalTime.of(10, 0);
			LocalDate showDate = dateStr != null && !dateStr.trim().equals("") ? LocalDate.parse(dateStr) : LocalDate.now() ;
			showTime = timeStr != null && !timeStr.trim().equals("") ? LocalTime.parse(timeStr) : showTime ;
			Map<Integer, Integer> bookedTickets = MovieService.getBookedTickets(showDate , showTime , seatType);
			List<MovieDTO> movies=MovieService.getAllMovies();
			List<LocalTime> showTimes = TicketService.getShowTimes();
			request.setAttribute("MOVIE_LIST", movies);
			request.setAttribute("BOOKED_TICKETS", bookedTickets);
			request.setAttribute("SHOW_TIMES", showTimes);
			request.setAttribute("DATE", showDate);
			request.setAttribute("SHOW_TIME", showTime);
			request.setAttribute("SEAT", seatType);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("movieDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Unable to Fetch Movie Details";
			response.sendRedirect("ShowDetails.jsp?errorMessage=" + errorMessage);
		}
	}


}
