package in.riyasahamed.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.riyasahamed.validator.AdminValidator;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Getting Form Values
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		try {
			// validating UserName and Password
			AdminValidator.validateAdmin(userName, password);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", userName);
			String infoMessage="Successfully Logged In";
			// Redirecting to Add Movie Page
			response.sendRedirect("addMovie.jsp?infoMessage=" + infoMessage);
		}
		catch(Exception e){
			String errorMessage=e.getMessage();
			// Printing Error Message
			response.sendRedirect("AdminLogin.jsp?errorMessage=" + errorMessage);			
		}

	}

}
