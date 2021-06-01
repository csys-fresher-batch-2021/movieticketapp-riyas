<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="in.riyasahamed.model.Seat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Booking</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	Integer movieId = Integer.parseInt(request.getParameter("movieId"));
	String name = request.getParameter("name");
	Integer tickets = Integer.parseInt(request.getParameter("tickets"));
	 String showDate =request.getParameter("showDate"); 
	 String showTime = request.getParameter("time");
	 String seatType = request.getParameter("seat");
	%>
	<main class="container-fluid">
		
		<div class="text-center">
		<br><h3>Booking</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form action=BookMovieServlet?movieId= <%=movieId%>>
			<input type="hidden" name="movieId" value="<%=movieId%>" required readonly/>
			<br> <label for="name">Movie Name: </label> <input type="text"
				name="name" id="name" value="<%=name%>" readonly><br />
			<br> <label for="actor">Actor Name: </label> <input type="text"
				name="actor" id="actor" value="<%=request.getParameter("actor")%>" readonly><br />
			<br> <label for="date"> Date: </label> <input type="date"
				id="date" name="date"  value=<%=showDate%> required readonly><br/>
				<br><label for="time"> Show Time: </label> <input type="time"
				id="time" name="time"  value=<%=showTime%> required readonly><br/>
				<br><label for="seat"> Seat Type: </label> <input type="text"
				id="seat" name="seat"  value=<%=seatType%> required readonly><br/>
			 <br /> <br> <label for="tickets">Number of Tickets : </label>
			<input type="number" name="tickets" id="tickets" min=1 max=<%=tickets%> value=1 required> (Available Tickets = <%=tickets%>)<br />
			<br>
			<button onclick="getPrice()" class="btn btn-secondary">Get Price</button><br>
			<br><div id="price"></div><br/>
			<br><button class="btn btn-primary" type="submit">Book</button>
			<a class="btn btn-danger"  href="index.jsp "type="reset">Cancel</a>
			<br />
		</form>
		</div>
		<script>
		
		function getPrice(){
			
			event.preventDefault();			
			let seatType = document.querySelector("#seat").value;
			let tickets = document.querySelector("#tickets").value;
			const queryParams = "?seatType=" + seatType + "&tickets=" + tickets;
			let url = "GetPriceServlet" + queryParams ;				
			let price;
			fetch(url).then(res=> res.json()).then(res=>{				
				let result=res;								
				if(result!= 0){
					price = "<h6>Total Price is : Rs.  " + result + "</h6>";
				}else{
					price = result.errorMessage;
				}
			document.querySelector("#price").innerHTML=price;
			
		});
		}
 		
		</script>


	</main>
</body>
</html>
