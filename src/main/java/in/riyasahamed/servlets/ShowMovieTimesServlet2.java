package in.riyasahamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.riyasahamed.service.TicketService;
import in.riyasahamed.util.LocalTimeAdapter;

/**
 * Servlet implementation class ShowMovieTimesServlet2
 */
@WebServlet("/ShowMovieTimesServlet2")
public class ShowMovieTimesServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowMovieTimesServlet2() {
        super();
        //Default Constructor
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
    		List<LocalTime> showTimes = TicketService.getShowTimes();
    		Gson gson = new GsonBuilder().setPrettyPrinting()
			        .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();

			String json = gson.toJson(showTimes);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Unable to Fetch Movie Details";
			response.sendRedirect("movieDetails.jsp?errorMessage=" + errorMessage);
		}
	
	}

	
}
