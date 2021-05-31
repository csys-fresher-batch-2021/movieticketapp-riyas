<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="in.riyasahamed.model.Seat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Booking</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	Integer movieId = Integer.parseInt(request.getParameter("movieId"));
	String name = request.getParameter("name");
	Integer tickets = Integer.parseInt(request.getParameter("tickets"));
	 String showDate =request.getParameter("showDate"); 
	 String showTime = request.getParameter("time");
	%>
	<main class="container-fluid">
		<h3>Booking</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form action=BookMovieServlet?movieId= <%=movieId%>>
			<input type="hidden" name="movieId" value="<%=movieId%>" required readonly/>
			<br> <label for="name">Movie Name: </label> <input type="text"
				name="name" id="name" value="<%=name%>" readonly><br />
			<br> <label for="actor">Actor Name: </label> <input type="text"
				name="actor" id="actor" value="<%=request.getParameter("actor")%>" readonly><br />
			<br> <label for="date"> Date: </label> <input type="date"
				id="date" name="date"  value=<%=showDate%> required readonly><br/>
				<br><label for="time"> Show Time: </label> <input type="time"
				id="time" name="time"  value=<%=showTime%> required readonly><br/>
			<%
			List<SeatDTO> seats = SeatService.getSeatTypes();
			%>
			<br> <label for=" seat"> Seat Type: </label> 
				<%
				for (SeatDTO seat : seats) {
				%>
				<input type="radio" name="seat" id ="seat" value="<%=seat.getSeatType()%>" required ><%=seat.getSeatType()%>
				<%
				}
				%>
			 <br /> <br> <label for="tickets">Number of Tickets : </label>
			<input type="number" name="tickets" id="tickets" min=1 max=<%=tickets%> value=1 required> (Available Tickets = <%=tickets%>)<br />
			<br>
			<button class="btn btn-primary" type="submit">Book</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>


	</main>
</body>
</html>
