<%@page import="in.riyasahamed.service.MovieService"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Movie</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String movie=request.getParameter("movie");
		String actor=request.getParameter("actor");
		Float rating=Float.parseFloat(request.getParameter("rating"));
		try{
		MovieService.addMovieDetails(movie,actor, rating);
		String infoMessage="Successfully added movie";
		response.sendRedirect("addMovie.jsp?infoMessage=" + infoMessage);
		}
		catch(Exception e){
			String errorMessage=e.getMessage();
			response.sendRedirect("addMovie.jsp?errorMessage=" + errorMessage);
		}
		
		%>
		
	</main>
</body>
</html>
