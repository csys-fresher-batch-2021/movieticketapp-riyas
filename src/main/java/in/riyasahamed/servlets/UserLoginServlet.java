package in.riyasahamed.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.riyasahamed.validator.LoginValidator;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Getting Form Values
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			// validating UserName and Password
			LoginValidator.isValidLogin(userName, password);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", userName);
			String infoMessage = "Successfully Logged In";
			// Redirecting to Add Movie Page
			response.sendRedirect("index.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			// Printing Error Message
			response.sendRedirect("UserLogin.jsp?errorMessage=" + errorMessage);
		}
	}

}
