<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="java.time.LocalTime"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="java.util.Map"%>
<%@page import="in.riyasahamed.dto.MovieDTO"%>
<%@page import="in.riyasahamed.dao.MovieDAO"%>
<%@page import="in.riyasahamed.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.service.MovieService"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Movies</title>
</head>
<body>
	<%
	String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
	String role = (String) session.getAttribute("ROLE");
	if (role == null) {
		role = "USER";
	}
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
		<jsp:include page="Message.jsp"></jsp:include>
				<%
				LocalTime time =(LocalTime) request.getAttribute("SHOW_TIME");
				String seatType = (String) request.getAttribute("SEAT");
				%>
		
		<%
		LocalDate showDate = (LocalDate) request.getAttribute("DATE");
		
		List<LocalTime> showTimes = (List<LocalTime>) request.getAttribute("SHOW_TIMES");
		%>
		<div class="text-center">
			<h4>Show Timings</h4>
			<form action=MovieDetailsServlet>
				<br> <label for="showDate">Show Date :</label> <input
					type="date" placeholder="ShowDate" id="showDate" name="showDate"
					required value=<%=showDate%> readonly><br /> <label for="showTime">Enter
					Show Time :</label>
				<%
				if (showTimes != null) {
					for (LocalTime showTime : showTimes) {
						if(showDate.isEqual(LocalDate.now())){
						if (showTime.isAfter(LocalTime.now())) {
							String checked = showTime.equals(time) ?"checked":"";
				%>
				<input type="radio" name="showTime" id="showTime"
					value="<%=showTime%>" <%=checked %>  required>
				<%=showTime%>
				<%
				}
				}else{ 
					String checked = showTime.equals(time) ?"checked":"";
				%>
					<input type="radio" name="showTime" id="showTime"
							value="<%=showTime%>" <%=checked %> >
						<%=showTime%>
					
				<% }
				}}
				%>
				<%
					List<SeatDTO> seats = SeatService.getSeatTypes();
			%>
				<br> <label for=" seat"> Seat Type: </label>
				<%
				for (SeatDTO seat : seats) {
					String checked = seat.getSeatType().equals(seatType) ?"checked":"";
				%>
				<input type="radio" name="seat" id="seat"
					value="<%=seat.getSeatType()%>" required <%=checked%>><%=seat.getSeatType()%>
				<%
				}
				%>
				<br>
				<button type="submit" class="btn btn-primary">Search</button>
				<a href="ShowDetails.jsp" class="btn btn-secondary">Change Date</a>
				<br />
		</form>
		</div>
		<br>
		<h3>Movies And Ticket Details</h3>
		<table class="table table-bordered">
			<caption>This Table is for Showing Movie Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="movieName">Movie Name</th>
					<th id="actorName">Actor</th>
					<th id="movieRating">Rating</th>
					<th id="movieTickets">Tickets Available</th>
					<th id="screen">Screen</th>
					<th id="action">
				 <%
 					if (loggedInUsername != null && !role.equalsIgnoreCase("ADMIN")) {
					 %>Book
					</th>
					<%
					}
					%>
				</tr>
			</thead>
			<tbody>
				<%
				List<MovieDTO> movies = (List<MovieDTO>) request.getAttribute("MOVIE_LIST");
				Map<Integer, Integer> bookedTickets = (Map<Integer, Integer>) request.getAttribute("BOOKED_TICKETS");
				if (movies != null) {
					int i = 0;
					for (MovieDTO movie : movies) {
						Integer noOfTicketsBooked = bookedTickets.get(movie.getMovieId());
						Integer ticketsAvailable = 0;
						if(seatType.equalsIgnoreCase("Platinum")){
						 ticketsAvailable = 50;
						}else if(seatType.equalsIgnoreCase("Gold")){
							ticketsAvailable = 80;
						}else if(seatType.equalsIgnoreCase("Silver")){
							ticketsAvailable = 20;
						}
						if (noOfTicketsBooked != null) {
					ticketsAvailable = ticketsAvailable - noOfTicketsBooked;
						}
						i++;
						if(movie.getStatus().equalsIgnoreCase("ACTIVE")){
				%>
			
				<tr>
					<td><%=i%></td>
					<td><%=movie.getName()%></td>
					<td><%=movie.getActor()%></td>
					<td><%=movie.getRating()%></td>
					<td><%=ticketsAvailable%></td>
					<td><%=movie.getScreen()%>

					<td>
						 <%
 						if (loggedInUsername != null && role.equalsIgnoreCase("USER")) {
 						%> <a
						href="Booking.jsp?name=<%=movie.getName()%>&actor=<%=movie.getActor()%>&movieId=<%=movie.getMovieId()%>
						&showDate=<%=showDate%>&tickets=<%=ticketsAvailable%>&time=<%=time%>&seat=<%=seatType%>&screen=<%=movie.getScreen()%>"
						class=" btn btn-primary">Book</a>

					</td>
					<%
					}
					%>
				</tr>
				<%
				}
					}
				}
				%>
			</tbody>
		</table>

		<script>
			let date = new Date();
			date.setDate(date.getDate());
			let today = date.toJSON().substring(0, 10);
			document.querySelector("#showDate").setAttribute("min", today);

			let endDate = new Date();
			endDate.setDate(endDate.getDate() + 10);
			let maxDate = endDate.toJSON().substring(0, 10);
			document.querySelector("#showDate").setAttribute("max", maxDate);
		</script>
	</main>
</body>
</html>
