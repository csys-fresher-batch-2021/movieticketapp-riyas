<%@page import="in.riyasahamed.model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.service.MovieService"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<html>
<head>
<title>Movies</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List Of Movies</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Movie Name</th>
					<th>Actor</th>
					<th>Rating</th>
					<th>Tickets Available</th>
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
			<td><%=i%></td>
			<td><%=movie.getName() %></td>
			<td><%=movie.getActor() %></td>
			<td><%=movie.getRating() %></td>
			<td><%=movie.getTickets() %></td>
			</tr>
		<%} %>
			</tbody>
		</table>

	</main>
</body>
</html>
