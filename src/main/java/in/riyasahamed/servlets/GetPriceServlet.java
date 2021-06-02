package in.riyasahamed.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.service.PricingService;

@WebServlet("/GetPriceServlet")
public class GetPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public GetPriceServlet() {
        super();
       //Default Constructor
        }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seatType = request.getParameter("seatType");
			
		PrintWriter out = response.getWriter();
		try {
			Integer numberOfTickets = Integer.parseInt(request.getParameter("tickets"));
			Float totalPrice = PricingService.getPrice(seatType , numberOfTickets);
			Gson gson = new Gson();
			String json = gson.toJson(totalPrice);
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
