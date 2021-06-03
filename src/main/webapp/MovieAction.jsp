<!DOCTYPE html>
<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="in.riyasahamed.dto.MovieDTO"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="in.riyasahamed.model.Seat"%>
<%@page import="in.riyasahamed.model.Movie"%>
<%@page import="in.riyasahamed.model.Ticket"%>
<html lang="en">
<head>
<title>Movie Details</title>
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
	<div class="text-center">
	<main class="container-fluid">
	    <br><h3>Movie Details</h3><br/>
		<%
			MovieDTO movie = (MovieDTO) request.getAttribute("MOVIE");
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
		<tr><td>Rating </td> <td> <%=movie.getRating()%></td></tr>
		<tr><td>Screen </td> <td> <%=movie.getScreen()%></td></tr>		
		</tbody>
		</table>
			<%
						if (loggedInUsername != null && role.equalsIgnoreCase("ADMIN") && movie.getStatus().equalsIgnoreCase("ACTIVE")) {
						%><a
						href="UpdateMovieStatusServlet?name=<%=movie.getName()%>&actor=<%=movie.getActor()%>
						&screen=<%=movie.getScreen()%>"	class=" btn btn-danger">Remove</a>
				
				<%} else { %>
					 <a
						href="ActivateMovie.jsp?name=<%=movie.getName()%>&actor=<%=movie.getActor()%>
						&screen=<%=movie.getScreen()%>"	class=" btn btn-primary">ADD</a>
				
				<%
				 }%>
	</main>
	</div>
</body>
</html>
