package ContactDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactUsDao {

    private String url = "jdbc:postgresql://localhost:5432/jsp_contact";
    private String username = "postgres";
    private String password = "8520";

    private static final String query = "INSERT INTO contact_requests (full_name, email, message) VALUES (?, ?, ?)";

    public void insertContactData(String fullname, String email, String message) {
        try {
            Class.forName("org.postgresql.Driver");


            try (Connection con = DriverManager.getConnection(url,username , password);
                 PreparedStatement st = con.prepareStatement(query)) {

                st.setString(1, fullname);
                st.setString(2, email);
                st.setString(3, message);

                st.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
