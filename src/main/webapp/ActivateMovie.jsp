<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.dao.SeatDAO"%>
<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Activate Movie</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
			String movie = request.getParameter("name");
			String actor = request.getParameter("actor");		
		%>
		<h3>Activate Movie</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form action="ActivateMovieServlet">

				<br> <label for="name">Movie Name :</label> 
				<input type="text" name="movie" id="name" value="<%=movie%>" required readonly><br /> <br> 
				<label for="name">Actor:</label> 
				<input type="text" name="actor" id="actor"  value="<%=actor%>" required readonly><br/>
				<br><label for="screen">Select Screen</label>
				<select name="screen" id="screen" required>
				<option disabled>Select Screen</option>		
				<%
					SeatDAO dao = new SeatDAO();
					Map<String , String> screens = dao.getAllScreens();
					Set<String> screennames = screens.keySet(); 
					for (String screen : screennames) {	
						if(screens.get(screen).equalsIgnoreCase("INACTIVE")){
							
					%>
					
					<option value="<%=screen%>"><%=screen%></option>
					<%
					}}
					%>
			</select><br>
			<br><button class="btn btn-primary" type="submit">Activate Movie</button>
			<a href="index.jsp" class="btn btn-secondary">Cancel</a>
			<br />
		</form>
		
		
	
	</main>
</body>
</html>
