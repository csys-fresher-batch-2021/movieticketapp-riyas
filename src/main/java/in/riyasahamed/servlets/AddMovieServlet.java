package in.riyasahamed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.SeatService;


@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieServlet() {
        super();
    }

	/**
	 * This Servlet is used to add the user Details..
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie=request.getParameter("movie");
		String actor=request.getParameter("actor");	
		String screen = request.getParameter("screen");
		try{
		Float rating=Float.parseFloat(request.getParameter("rating"));
		MovieDTO dto = new MovieDTO();
		dto.setName(movie);
		dto.setActor(actor);
		dto.setRating(rating);
		dto.setScreen(screen);
		MovieService.addMovieDetails(dto);
		SeatService.updateScreenStatus( "ACTIVE" ,screen);
		String infoMessage="Successfully added movie";
		response.sendRedirect("addMovie.jsp?infoMessage=" + infoMessage);
		}
		catch(Exception e){
			String errorMessage=e.getMessage();
			response.sendRedirect("addMovie.jsp?errorMessage=" + errorMessage);
	}

	
}
}
