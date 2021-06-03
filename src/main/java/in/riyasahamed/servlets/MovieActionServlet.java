package in.riyasahamed.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.MovieService;


@WebServlet("/MovieActionServlet")
public class MovieActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MovieActionServlet() {
        super();
        // Default Constructor
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			MovieDTO movie = MovieService.findByMovieId(id);
			request.setAttribute("MOVIE", movie);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MovieAction.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServiceException e) {
				String errorMessage = e.getMessage();
				response.sendRedirect("ListMovies.jsp?errorMessage=" + errorMessage);
		}
		
	}

}
