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
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
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
				</tr>
			</thead>
			<tbody>
				<%
			List<Movie> movies = MovieService.getMovies();
		int i =0;
		for(Movie movie: movies){
		i++;				
			%>
			<tr>
			<td ><%=i%></td>
			<td ><%=movie.getName() %></td>
			<td ><%=movie.getActor() %></td>
			<td ><%=movie.getRating() %></td>
			<td ><%=movie.getTickets() %></td>
			</tr>
		<%} %>
			</tbody>
		</table>

	</main>
</body>
</html>
