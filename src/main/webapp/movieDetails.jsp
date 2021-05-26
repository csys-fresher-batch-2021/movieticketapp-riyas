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
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<jsp:include page="Message.jsp"></jsp:include>
		<h3>List Of Movies</h3>
		<table class="table table-bordered">
			<caption>This Table is for Showing Movie Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="movieName">Movie Name</th>
					<th id="actorName">Actor</th>
					<th id="movieRating">Rating</th>
					<th id="movieTickets">Tickets Available</th>
					<th id="action">
						<%
						if (loggedInUsername != null && loggedInUsername.equalsIgnoreCase("ADMIN")) {
						%>Delete<%
					}
					%>
						<%
						if (loggedInUsername != null && !loggedInUsername.equalsIgnoreCase("ADMIN")) {
						%>Book
					</th>
					<%
					}
					%>
				</tr>
			</thead>
			<tbody>
				<%				
				List<MovieDTO> movies=(List<MovieDTO>)request.getAttribute("MOVIE_LIST");
				if(movies!=null){
				int i = 0;
				for (MovieDTO movie : movies) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=movie.getName()%></td>
					<td><%=movie.getActor()%></td>
					<td><%=movie.getRating()%></td>
					<td><%=movie.getTickets()%></td>

					<td>
						<%
						if (loggedInUsername != null && loggedInUsername.equalsIgnoreCase("ADMIN")) {
						%> <a
						href="DeleteMovieServlet?name=<%=movie.getName()%>&actor=<%=movie.getActor()%>"
						class=" btn btn-danger">Delete</a> <%
					}
					%> <%
						if (loggedInUsername != null && !loggedInUsername.equalsIgnoreCase("ADMIN")) {
						%> <a
						href="Booking.jsp?name=<%=movie.getName()%>&actor=<%=movie.getActor()%>&movieId=<%=movie.getMovieId()%>"
						class=" btn btn-primary">Book</a>

					</td>
					<%
					}
					%>
				</tr>
				<%
				} }
				%>

			</tbody>
		</table>

	</main>
</body>
</html>
