<!DOCTYPE html>
<%@page import="in.riyasahamed.dto.SeatDTO"%>
<%@page import="in.riyasahamed.model.Seat"%>
<%@page import="java.util.List"%>
<%@page import="in.riyasahamed.service.SeatService"%>
<html lang="en">
<head>
<title>Seat Types</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Seat Types</h3>
		<table class="table table-bordered">
		<caption>This Table is for Showing Different Seat Types</caption>
			<thead>
				<tr>
					<th id="S.no">S.No</th>
					<th id="seatType">Seat Type</th>
					<th id="price">Price Per Ticket</th>
				</tr>
			</thead>
			<tbody>
				<%
			List<SeatDTO> seats = SeatService.getSeatTypes();
		int i =0;
		for(SeatDTO seat: seats){
		i++;				
			%>
			<tr>
			<td ><%=i%></td>
			<td ><%=seat.getSeatType()%></td>
			<td >Rs. <%=seat.getPrice()%></td>
			</tr>
		<%} %>
			</tbody>
		</table>

	</main>
</body>
</html>
