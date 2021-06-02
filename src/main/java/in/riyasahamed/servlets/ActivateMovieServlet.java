package in.riyasahamed.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.MovieService;
import in.riyasahamed.service.SeatService;

@WebServlet("/ActivateMovieServlet")
public class ActivateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ActivateMovieServlet() {
        super();
        // Default Constructor
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie=request.getParameter("movie");
		String actor=request.getParameter("actor");	
		String screen = request.getParameter("screen");
		try{
		MovieService.updateMovieStatus("ACTIVE",movie, actor);
		SeatService.updateScreenStatus("ACTIVE", screen);
		MovieService.updateScreenStatus(screen, movie, actor);
		String infoMessage="Successfully Added movie";
		response.sendRedirect("ListMovies.jsp?infoMessage=" + infoMessage);
		}
		catch(ServiceException e){
			String errorMessage=e.getMessage();
			response.sendRedirect("ListMovies.jsp.jsp?errorMessage=" + errorMessage);
	}
		
	}

}
