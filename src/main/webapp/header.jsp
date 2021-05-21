<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");
%>
<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">Movie App</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
      <% if (loggedInUsername != null){ %>
        <a class="nav-link" href="MovieDetailsServlet">Movies</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="SeatDeatails.jsp">Seat Types</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#">Action 1</a>
          <a class="dropdown-item" href="#">Action 2</a>
        </div>
      </li>
    </ul>
    <%} %>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <% if (loggedInUsername == null){ %>
      <li class="nav-item active">
        <a class="nav-link" href="AdminLogin.jsp">Admin Login</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="UserLogin.jsp">User Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="RegisterUser.jsp">Register</a>
      </li>
       <%}  else {%>
        <li class="nav-item">
        <a class="nav-link" href="#">Welcome <%=loggedInUsername %></a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Logout</a>
      </li>
      <%} %>
      
      <% if (loggedInUsername != null && loggedInUsername.equalsIgnoreCase("ADMIN")){ %>
      <li class="nav-item">
        <a class="nav-link" href="addMovie.jsp">Add Movie</a>
      </li>
      </ul>
    <%} %>
  </div>
</nav>
</header>