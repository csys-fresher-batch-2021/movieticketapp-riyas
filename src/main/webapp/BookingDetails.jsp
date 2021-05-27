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
		<br><a>Movie Name : <%=movie.getName()%></a><br/>
		<br><a>Actor : <%=movie.getActor()%></a><br/>
		<br><a>Seat Type : <%=seat.getSeatType()%></a><br/>
		<br><a>Show Date : <%=ticket.getShowDate()%></a><br/>
		<br><a>Number of Tickets : <%=ticket.getNoOfTickets()%></a><br/>
		<br><a>Total Bill : <%=ticket.getTotalPrice()%></a><br/>
		<br><a href="index.jsp" class="btn btn-primary">Home Page</a><br/>
	</main>
	</div>
</body>
</html>
