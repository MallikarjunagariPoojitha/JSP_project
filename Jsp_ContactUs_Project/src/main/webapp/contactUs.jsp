<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/contact_us_style.css">
</head>
<body>
<% if(session.getAttribute("name")==null){
   	  response.sendRedirect("login.jsp");
     }
%>
<nav class="navbar">
        <ul>
            <li><a href="contactUs.jsp">Contact Us</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="logout">Logout</a></li>
            <li><a href="request">Requests</a></li>
        </ul>
    </nav>
<form action="insertData" method="post">
<h2>Contact Us</h2>
Full name: <input type="text" name="fullName" required/><br>
E-mail: <input type="email" name="email" required/><br>
Message: <textarea name="message" rows="10" cols="15" required>Message</textarea><br>
<input type="submit"/>
</form>
<form action="logout">
<input type="submit" value="LOGOUT">
</form>
</body>
</html>