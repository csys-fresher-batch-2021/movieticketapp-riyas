<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Admin Login</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form action="AdminLoginServlet" method="post">
				<br> <label for="userName">User Name :</label> 
				<input type="text" name="userName" id="userName" autocomplete="off" required placeholder="Enter User Name" autofocus><br /> <br> 
				<label for="password">Password : </label> 
				<input type="password" name="password" id="password" autocomplete="off" required placeholder="Enter Password"><br/><br>
				<button class="btn btn-secondary" type="submit">Submit</button>
				<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>
	</main>
</body>
</html>
