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

/**
 * Servlet implementation class DeleteMovieServlet
 */
@WebServlet("/UpdateMovieStatusServlet")
public class UpdateMovieStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieStatusServlet() {
       //Default Constructor
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie=request.getParameter("name");
		String actor=request.getParameter("actor");	
		String screen = request.getParameter("screen");
		try{
		MovieService.updateMovieStatus("INACTIVE",movie, actor);
		SeatService.updateScreenStatus("INACTIVE", screen);
		String infoMessage="Successfully Deleted movie";
		response.sendRedirect("ListMovies.jsp?infoMessage=" + infoMessage);
		}
		catch(ServiceException e){
			String errorMessage=e.getMessage();
			response.sendRedirect("ListMovies.jsp.jsp?errorMessage=" + errorMessage);
	}
	}

	

}
