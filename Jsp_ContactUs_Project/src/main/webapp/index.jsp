<html>
<head>
<style>
.navbar {
             background-color: #333;
             overflow: hidden;
             position: fixed; /* Stick to the top */
             top: 0;
             width: 100%;
             padding: 0 20px;
             box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
             z-index: 1000; /* Ensure it stays on top of other content */
         }

         .navbar ul {
             list-style-type: none;
             margin: 0;
             padding: 0;
             display: flex;
             justify-content: center;
         }
         .navbar ul li {
             margin: 0;
         }
         .navbar ul li a {
             display: block;
             color: white;
             text-align: center;
             padding: 14px 20px;
             text-decoration: none;
             font-size: 16px;
             font-weight: bold;
             transition: background-color 0.3s ease;
         }

         .navbar ul li a:hover {
             background-color: #575757;
         }
</style>
</head>
<body>
 <h2>Welcome!</h2>
<nav class="navbar">
        <ul>
            <li><a href="contactUs.jsp">Contact Us</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="logout">Logout</a></li>
            <li><a href="request">Requests</a></li>
        </ul>
    </nav>
    <h2>Welcome!</h2>

</body>
</html>
