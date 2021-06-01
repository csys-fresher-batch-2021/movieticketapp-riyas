<%@page import="in.riyasahamed.service.SeatService"%>
<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="java.time.LocalTime"%>
<%@page import="in.riyasahamed.dto.TicketDTO"%>
<%@page import="java.util.Map"%>
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
<title>Book Movie</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<jsp:include page="Message.jsp"></jsp:include>
		<div class="text-center">
			<h4>Select Date and Show Time</h4>
			<form action=MovieDetailsServlet>
				<br> <label for="showDate">Enter Show Date :</label> <input
					type="date" placeholder="ShowDate" id="showDate" name="showDate"
					required onchange="getShowTimes()"><br />
				<%
					List<SeatDTO> seats = SeatService.getSeatTypes();
			%>
				<br> <label for=" seat"> Seat Type: </label>
				<%
				for (SeatDTO seat : seats) {					
				%>
				<input type="radio" name="seat" id="seat"
					value="<%=seat.getSeatType()%>" required><%=seat.getSeatType()%>
				<%
				}
				%><br>
				<div id="showTime"></div>
				<br>
				<button type="submit" class="btn btn-primary">Search</button>
				<br/>

			</form>
		</div>
		<br>
	</main>

	<script>
			let date = new Date();
			date.setDate(date.getDate());
			let today = date.toJSON().substring(0, 10);
			document.querySelector("#showDate").setAttribute("min", today);

			let endDate = new Date();
			endDate.setDate(endDate.getDate() + 10);
			let maxDate = endDate.toJSON().substring(0, 10);
			document.querySelector("#showDate").setAttribute("max", maxDate);
			
			function getShowTimes(){
				
				
				let date1 = document.querySelector("#showDate").value;
				console.log(date1);
				document.querySelector("#showDate").setAttribute("value", date1);
				console.log(typeof date1);
				let url = "ShowTimesServlet";
				fetch(url).then(res=> res.json()).then(res=>{
				let showTimes=res;
				let content="Enter Show Time :" +"  ";	
				for(let time of showTimes){
					let showHour = parseInt(time.split(":")[0]);
					let date = new Date();
					let hour = date.getHours();
					let today = date.toJSON().substring(0, 10);
					console.log(hour);	
					console.log(date);
					if(today == date1){
					if(showHour > hour){

						content+=
				    	 "<input type=\"radio\" name=\"showTime\" id=\"showTime\""+
						"value =\""+time+"\" required >" + showHour + ":00 " ;
				    	console.log(time);
					} }else{
						content+=
					    	"<input type=\"radio\" name=\"showTime\" id=\"showTime\""+
							"value =\""+time+"\" required >" + showHour + ":00 " ;
					}
				}
				document.querySelector("#showTime").innerHTML= content;
				});
			}
		</script>

</body>
</html>
