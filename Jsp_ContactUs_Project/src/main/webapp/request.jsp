<%@ page import="java.util.List" %>
<%@ page import="model.ContactRequestData" %>
<html>
<head>
<style>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
  }
  h2 {
    color: #333;
    text-align: center;
    margin-bottom: 20px;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
  }
  th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  th {
   background-color:  #b7e1da;
    color: black;
  }
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  tr:hover {
    background-color: #ddd;
  }
  form {
    display: inline;
  }
  button {
    background-color: #b7e1da;
    color: black;
    border: none;
    padding: 10px 15px;
    font-size: 16px;
    border-radius: 4px;
    cursor: pointer;
  }

  button:hover {
    background-color: #45a049;
  }
  input[type="submit"] {
      background-color: #b7e1da;
      color: black;
      border: none;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      border-radius: 4px;
      cursor: pointer;
      margin-right: 10px;
    }
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
<% if(session.getAttribute("name")==null){
     out.println("Please login to continue");
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
<h2>Active Requests</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<ContactRequestData> requests = (List<ContactRequestData>) request.getAttribute("requests");
                if (requests != null) {
                    for (ContactRequestData req : requests) {
                       if(req.getStatus().equals("active")){
            %>
                    <tr>
                        <td><%= req.getId() %></td>
                        <td><%= req.getFullName() %></td>
                        <td><%= req.getEmail() %></td>
                        <td><%= req.getMessage() %></td>
                        <td><%= req.getStatus() %></td>
                        <td>
                            <form action="archive" method="post">
                                <input type="hidden" name="id" value="<%= req.getId() %>">
                                <button type="submit">Archive</button>
                            </form>
                        </td>
                    </tr>
            <%
                    }
                    }
                } else {
            %>
                <tr>
                    <td colspan="6">No contact requests found.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
   <h2>Archive Requests</h2>
     <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Message</th>
                    <th>Status</th>

                </tr>
            </thead>
            <tbody>
                <%

                    if (requests != null) {
                        for (ContactRequestData req : requests) {
                          if(req.getStatus().equals("archive")){

                %>
                        <tr>
                            <td><%= req.getId() %></td>
                            <td><%= req.getFullName() %></td>
                            <td><%= req.getEmail() %></td>
                            <td><%= req.getMessage() %></td>
                            <td><%= req.getStatus() %></td>
                        </tr>
                <%
                        }
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="6">No contact requests found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
</body>
</html>
