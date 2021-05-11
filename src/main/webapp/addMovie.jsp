<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<html>
<head>
<title>Add Movie</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Movie</h3>
		<form action="movieValidator.jsp">

				<br> <label for="name">Movie Name :</label> 
				<input type="text" name="movie" id="name" autocomplete="on" required placeholder="Enter Movie Name" autofocus><br /> <br> 
				<label for="name">Actor:</label> 
				<input type="text" name="actor" id="actor" autocomplete="on" required placeholder="Enter Actor Name"><br />
				<br><label for="name">Rating:</label> 
				<input type="number" name="rating" id="rating" autocomplete="on" required placeholder="Enter Rating"><br /> <br>
			<button class="btn btn-secondary" type="submit">Add Movie</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
	</main>
</body>
</html>
