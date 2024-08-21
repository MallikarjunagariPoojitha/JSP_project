package ContactDao;

import java.sql.*;

public class ActiveToArchiveDao {
    private String url = "jdbc:postgresql://localhost:5432/jsp_contact";
    private String username = "postgres";
    private String password = "8520";

    private static final String query = "UPDATE contact_requests SET status = 'archive' WHERE id=?";

    public void updateStatus(int id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,id);
            st.executeUpdate();
            st.close(); // Close the statement
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
