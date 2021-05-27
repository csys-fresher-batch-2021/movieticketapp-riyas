<%@page import="in.riyasahamed.dto.UserDTO"%>
<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="in.riyasahamed.service.TicketService"%>
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
<title>My Bookings</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<jsp:include page="Message.jsp"></jsp:include>
		<h3>My Bookings</h3>
		<table class="table table-bordered">
			<caption>This Table is for Showing Booking Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.no</th>
					<th id="bookingId">Booking ID</th>
					<th id="user">Name of the User</th>
					<th id="mobileNumber">Mobile Number</th>
					<th id="movieId">Movie ID</th>
					<th id="movieName">Movie Name</th>
					<th id="bookedDate">Booked Date</th>
					<th id="showDate">Show Date</th>
					<th id="seatType">Seat Type</th>
					<th id="tickets">Number of Tickets</th>
					<th id="price">Total Price</th>
					<th id="status">Status</th>
					<th id="cancel">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%	
				List<TicketDTO> tickets = (List<TicketDTO>)request.getAttribute("TICKET_DETAILS");
				if(tickets!=null){
				int i = 0;
				for (TicketDTO ticket : tickets) {
					i++;
					MovieDTO movie = ticket.getMovie();
					SeatDTO seat = ticket.getSeat();
					UserDTO user = ticket.getUser();					
				%>
				<tr>
					<td><%=i%></td>
					<td><%=ticket.getTicketId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getMobileNumber()%></td>
					<td><%=movie.getMovieId()%></td>
					<td><%=movie.getName()%></td>
					<td><%=ticket.getBookingDate()%></td>
					<td><%=ticket.getShowDate()%></td>
					<td><%=seat.getSeatType()%></td>
					<td><%=ticket.getNoOfTickets()%></td>
					<td><%=ticket.getTotalPrice()%></td>
					<td><%=ticket.getStatus()%></td>
					<td><a
						href="CancelMovieServlet?orderId=<%=ticket.getTicketId()%>&movieId=<%=movie.getMovieId()%>&tickets=<%=ticket.getNoOfTickets()%>&showDate=<%=ticket.getShowDate()%>"
						class="btn btn-danger">Cancel</a> <%
					}
					%>
				</tr>
				<%
				} 
				%>
			</tbody>
		</table>

	</main>
</body>
</html>
