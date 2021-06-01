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
		<br><h3>Available Movies</h3>
		<jsp:include page="Message.jsp"></jsp:include><br/>
		<table class="table table-bordered">
			<caption>This Table is for Showing Movie Details</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="movieName">Movie Name</th>
					<th id="actorName">Actor</th>
					<th id="movieRating">Rating</th>
					<th id ="screen">Screen</th>
					
						<%
						if (loggedInUsername != null && role.equalsIgnoreCase("ADMIN")) {
						%><th id="action">Remove</th>
						<%
					}
					%>
					
				</tr>
			</thead>
			<tbody>
				<%				
				List<MovieDTO> movies = MovieService.getAllMovies();
				if(movies!=null){
				int i = 0;
				for (MovieDTO movie : movies) {
					if(movie.getStatus().equalsIgnoreCase("ACTIVE")){
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=movie.getName()%></td>
					<td><%=movie.getActor()%></td>
					<td><%=movie.getRating()%></td>
					<td><%=movie.getScreen()%></td>					
						<%
						if (loggedInUsername != null && role.equalsIgnoreCase("ADMIN")) {
						%><td> <a
						href="UpdateMovieStatusServlet?name=<%=movie.getName()%>&actor=<%=movie.getActor()%>
						&screen=<%=movie.getScreen()%>"	class=" btn btn-danger">Remove</a> </td><%
					}
					%> 

					
				</tr>
				<%
				} }}
				%>

			</tbody>
		</table>

	</main>
</body>
</html>
