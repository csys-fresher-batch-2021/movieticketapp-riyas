package in.riyasahamed.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.service.TicketService;

/**
 * Servlet implementation class ShowTimingServlet
 */
@WebServlet("/ShowTimingServlet")
public class ShowTimingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTimingServlet() {
        super();
        //Default Constructor
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	try {
    		String dateStr = request.getParameter("showDate");
			String timeStr = request.getParameter("showTime");
			LocalTime showTime = LocalTime.of(10, 0);
			LocalDate showDate = dateStr != null && !dateStr.trim().equals("") ? LocalDate.parse(dateStr) : LocalDate.now() ;
			showTime = timeStr != null && !timeStr.trim().equals("") ? LocalTime.parse(timeStr) : showTime ;
			List<LocalTime> showTimes = TicketService.getShowTimes();
			request.setAttribute("SHOW_TIMES", showTimes);
			request.setAttribute("DATE", showDate);
			request.setAttribute("SHOW_TIME", showTime);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("movieDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Unable to Fetch Movie Details";
			response.sendRedirect("movieDetails.jsp?errorMessage=" + errorMessage);
		}
		
	}
}
