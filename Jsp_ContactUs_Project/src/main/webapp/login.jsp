<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/login_style.css">
</head>
<body>
    <nav class="navbar">
        <ul>
            <li><a href="contactUs.jsp">Contact Us</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="logout">Logout</a></li>
            <li><a href="request">Requests</a></li>
        </ul>
    </nav>

    <form action="login">
        <h2>Login</h2>
        Enter Your name: <input type="text" name="name" required/><br>
        Enter password: <input type="password" name="password" required/><br>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
