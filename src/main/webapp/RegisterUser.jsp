<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register User</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>User Registration</h3>
		<jsp:include page="Message.jsp"></jsp:include>
		<form action="RegisterUserServlet" method="post">

				<br> <label for="name">Name :</label> 
				<input type="text" name="name" id="name" autocomplete="off" required placeholder="Enter Your Name" autofocus><br /> <br> 
				<label for="name">Email:</label> 
				<input type="email" name="email" id="email" autocomplete="off" required placeholder="Enter Your Email"><br />
				<br><label for="name">Mobile Number:</label> 
				<input type="number" name="mobileNumber" id="mobileNumber" autocomplete="off" required placeholder="Enter Your Mobile Number"><br /> <br>
				<br> <label for="name">User Name :</label> 
				<input type="text" name="userName" id="userName" autocomplete="off" required placeholder="Set Your User Name" autofocus><br /> <br> 
				<br> <label for="name">Password:</label> 
				<input type="password" name="password" id="password" autocomplete="off" required placeholder="Set Your Password" autofocus><br /> <br> 
			<button class="btn btn-primary" type="submit">Register</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>
		
		
	
	</main>
</body>
</html>
