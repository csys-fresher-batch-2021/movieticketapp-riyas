package in.riyasahamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.MovieService;

/**
 * Servlet implementation class AddMovieServletJSON
 */
@WebServlet("/AddMovieServletJSON")
public class AddMovieServletJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddMovieServletJSON() {
        super();
        //Default Constructor
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movieName=request.getParameter("movieName");
		String actorName=request.getParameter("actorName");
		String screen = request.getParameter("screen");
		PrintWriter out = response.getWriter();
		try {
			Float rating=Float.parseFloat(request.getParameter("rating"));
			MovieDTO movie = new MovieDTO();
			movie.setName(movieName);
			movie.setActor(actorName);
			movie.setRating(rating);
			movie.setScreen(screen);
			MovieService.addMovieDetails(movie);
			JsonObject object = new JsonObject();
			object.addProperty("infoMessage", "Successfully Added");
			out.println(object); 	
		} catch (ServiceException e) {
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);
		}
		out.flush();
		
	}

}
