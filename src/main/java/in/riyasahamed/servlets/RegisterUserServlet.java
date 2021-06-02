package in.riyasahamed.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.riyasahamed.dto.UserDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.UserService;



@WebServlet(description = "This Servlet is Used to Register User", urlPatterns = { "/RegisterUserServlet" })
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterUserServlet() {
        super();
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		try {
			Long mobileNumber=Long.parseLong(request.getParameter("mobileNumber"));
			UserDTO user=UserDTO.getInstance();
			user.setName(name);
			user.setEmail(email);
			user.setMobileNumber(mobileNumber);
			user.setUserName(userName);
			user.setPassword(password);
			UserService.registerUser(user);
			String infoMessage="Successfully Registerd User";
			response.sendRedirect("RegisterUser.jsp?infoMessage=" + infoMessage);
		}catch(ServiceException e) {
			String errorMessage=e.getMessage();
			response.sendRedirect("RegisterUser.jsp?errorMessage=" + errorMessage);
		}
	}

	

}
