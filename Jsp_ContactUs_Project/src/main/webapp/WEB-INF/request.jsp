<%@ page import="java.util.List" %>
<%@ page import="model.ContactRequestData" %>
<%@ page import="model.ArchiveRequestData" %>
<html>
<body>
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
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<ArchiveRequestData> archiveRequests = (List<ArchiveRequestData>) request.getAttribute("archiveRequests");
                    if (requests != null) {
                        for (ArchiveRequestData req : archiveRequests) {
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
