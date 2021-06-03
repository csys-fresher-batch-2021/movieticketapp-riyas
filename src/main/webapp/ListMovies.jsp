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
				</tr>
			</thead>
			<tbody>
				<%				
				List<MovieDTO> movies = MovieService.getAllMovies();
				if(movies!=null){
				int i = 0;
				for (MovieDTO movie : movies) {
					if (!role.equalsIgnoreCase("ADMIN")) {
					if(movie.getStatus().equalsIgnoreCase("ACTIVE")){
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><a href="MovieActionServlet?id=<%=movie.getMovieId()%>"><%=movie.getName()%></a></td>
					<td><%=movie.getActor()%></td>
					<td><%=movie.getRating()%></td>
					<td><%=movie.getScreen()%></td></tr>			
						<%
					}} else{
						i++;
					%> 
					<tr>
					<td><%=i%></td>
					<td><a href="MovieActionServlet?id=<%=movie.getMovieId()%>"><%=movie.getName()%></a></td>
					<td><%=movie.getActor()%></td>
					<td><%=movie.getRating()%></td>
					<%if(movie.getStatus().equalsIgnoreCase("ACTIVE")){ %>
					<td><%=movie.getScreen()%></td>			
					<%} else{ %>
					<td>Movie Inactive</td>		
					<%} %>
					</tr>
				
				<% }} }
				%>

			</tbody>
		</table>

	</main>
</body>
</html>
