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
	out.println(movieId);
	%>
	<main class="container-fluid">
		<h3>Booking</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form action=BookMovieServlet?movieId= <%=movieId%>>
			<input type="hidden" name="movieId" value="<%=movieId%>" required />
			<br> <label for="name">Movie Name: </label> <input type="text"
				name="name" id="name" value=<%=request.getParameter("name")%>><br />
			<br> <label for="actor">Actor Name: </label> <input type="text"
				name="actor" id="actor" value=<%=request.getParameter("actor")%>><br />
			<br> <label for="date"> Date: </label> <input type=date
				id="date" name="date" required><br />
			<%
			List<SeatDTO> seats = SeatService.getSeatTypes();
			%>
			<br> <label for=" seat"> Seat Type: </label> <select name="seat">
				<%
				for (SeatDTO seat : seats) {
				%>
				<option value="<%=seat.getSeatType()%>"><%=seat.getSeatType()%>
				</option>
				<%
				}
				%>
			</select> <br /> <br> <label for="tickets">Number of Tickets : </label>
			<input type="number" name="tickets" id="tickets" min=1 required><br />
			<br>
			<button class="btn btn-primary" type="submit">Book</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>

		<script>
			let date = new Date();
			date.setDate(date.getDate() + 1);
			let tommorow = date.toJSON().substring(0, 10);
			//document.querySelector("#date").setAttribute("min", tommorow);
			
			let endDate = new Date();
			endDate.setDate(endDate.getDate() + 10);
			let maxDate=endDate.toJSON().substring(0, 10);
			document.querySelector("#date").setAttribute("max", maxDate);			
		</script>


	</main>
</body>
</html>
