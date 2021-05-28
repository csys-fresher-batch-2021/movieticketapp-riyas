package in.riyasahamed.servlets;

import java.io.IOException;
import java.time.LocalDate;
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
    	
    	
    	String dateStr = request.getParameter("showDate");
    	LocalDate showDate = dateStr != null && !dateStr.trim().equals("") ? LocalDate.parse(dateStr) : LocalDate.now() ;
    	Map<Integer, Integer> bookedTickets = MovieService.getBookedTickets(showDate);
		List<MovieDTO> movies=MovieService.getAllMovies();
		request.setAttribute("MOVIE_LIST", movies);
		request.setAttribute("BOOKED_TICKETS", bookedTickets);
		request.setAttribute("DATE", showDate);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("movieDetails.jsp");
		requestDispatcher.forward(request, response);
	}


}
