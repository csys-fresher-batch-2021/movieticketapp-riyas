package in.riyasahamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.riyasahamed.dto.SeatDTO;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.SeatService;

/**
 * Servlet implementation class SeatDetailsServlet
 */
@WebServlet("/SeatDetailsServlet")
public class SeatDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SeatDetailsServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			List<SeatDTO> seats = SeatService.getSeatTypes();
			Gson gson = new Gson();
			String json = gson.toJson(seats);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
		} catch (ServiceException e) {
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);			
		}
		out.flush();
	}

}
