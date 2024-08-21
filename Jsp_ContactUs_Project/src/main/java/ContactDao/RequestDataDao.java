package ContactDao;

import jakarta.servlet.annotation.WebServlet;
import model.ContactRequestData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDataDao {
    private final String url = "jdbc:postgresql://localhost:5432/jsp_contact";
    private final String username = "postgres";
    private final String password = "8520";
    private static final String query = "SELECT * FROM contact_requests";

    public List<ContactRequestData> getRequestData() {
        List<ContactRequestData> requests = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String message = rs.getString("message");
                String status = rs.getString("status");

                ContactRequestData req = new ContactRequestData(id, fullName, email, message, status);
                requests.add(req);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requests;

    }

}
