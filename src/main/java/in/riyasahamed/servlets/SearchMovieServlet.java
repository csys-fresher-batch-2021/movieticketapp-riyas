package in.riyasahamed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.riyasahamed.dto.MovieDTO;
import in.riyasahamed.service.MovieService;

/**
 * Servlet implementation class SearchMovieServlet
 */
@WebServlet("/SearchMovieServlet")
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchMovieServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		try {
			List<MovieDTO> movies=MovieService.findMovieByKeyword(keyword);
			request.setAttribute("MOVIE_LIST", movies);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SearchMovie.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("SearchMovie.jsp?errorMessage=" + errorMessage);
		}
	}

	


}
