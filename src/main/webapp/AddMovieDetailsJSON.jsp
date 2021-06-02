<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="in.riyasahamed.dao.SeatDAO"%>
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
		<h3>Add Movie</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form onSubmit="addMovie()">
			<p id="message"></p>
			<br> <label for="name">Movie Name :</label> 
				<input type="text" name="movie" id="name" autocomplete="off" required placeholder="Enter Movie Name" autofocus><br /> <br> 
				<label for="name">Actor:</label> 
				<input type="text" name="actor" id="actor" autocomplete="off" required placeholder="Enter Actor Name"><br />
				<br><label for="name">Rating:</label> 
				<input type="number" name="rating" id="rating" autocomplete="off" required placeholder="Enter Rating" step="0.01"><br /> <br>
				<label for="screen">Select Screen</label>
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
			<button class="btn btn-secondary" type="submit">Add Movie</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
			
		</form>

		<script>
			
		function addMovie() {
			
				event.preventDefault();
				let movieName = document.querySelector("#name").value;
				let actorName = document.querySelector("#actor").value;
				let rating = document.querySelector("#rating").value;
				let screen = document.querySelector("#screen").value;
				const queryParams = "?movieName=" + movieName + "&actorName=" + actorName + "&rating="+ rating + "&screen=" + screen;
				let url = "AddMovieServletJSON" + queryParams ;				
				fetch(url).then(res=> res.json()).then(res=>{
				console.log(res);				
				let result=res;								
				console.log(result);				
				if(result.infoMessage != null){
					message=result.infoMessage;
				}
				else{
					message=result.errorMessage;
				}
				document.querySelector("#message").innerHTML=message;
				}
				);			
		}
		</script>

	</main>
</body>
</html>
