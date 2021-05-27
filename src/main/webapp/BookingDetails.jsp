<!DOCTYPE html>
<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="in.riyasahamed.dto.MovieDTO"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="in.riyasahamed.model.Seat"%>
<%@page import="in.riyasahamed.model.Movie"%>
<%@page import="in.riyasahamed.model.Ticket"%>
<html lang="en">
<head>
<title>Booking Details</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="text-center">
	<main class="container-fluid">
		<br><h2>Ticket Booked Successfully</h2><br/>
	    <br><h3>Booking Details</h3><br/>
		<%
			TicketDTO ticket = (TicketDTO)request.getAttribute("BOOKING_DETAILS");
			MovieDTO movie = ticket.getMovie();			
			SeatDTO seat = ticket.getSeat();			
		%>
		<table class="table table-bordered">
		<caption>This Table is for Showing Booking Details</caption>
		<thead>
		<tr><th id="particulars">Particulars</th>
			<th id="Details">Details</th></tr>
			</thead>
			<tbody>
		<tr><td>Movie Name</td> <td><%=movie.getName()%></td> </tr>
		<tr><td>Actor </td> <td> <%=movie.getActor()%></td> </tr>
		<tr><td>Seat Type </td> <td> <%=seat.getSeatType()%></td> </tr>
		<tr><td>Show Date </td> <td> <%=ticket.getShowDate()%></td> </tr>
		<tr><td>Number of Tickets </td> <td> <%=ticket.getNoOfTickets()%></td> </tr>
		<tr><td>Total Bill(inclusive of all taxes) </td> <td>Rs: <%=ticket.getTotalPrice()%></td> </tr>
		</tbody>
		</table>
		<br><a href="index.jsp" class="btn btn-primary">Home Page</a>
	</main>
	</div>
</body>
</html>
