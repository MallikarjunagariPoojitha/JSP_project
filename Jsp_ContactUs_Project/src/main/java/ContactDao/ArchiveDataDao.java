package ContactDao;

import model.ArchiveRequestData;
import model.ContactRequestData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArchiveDataDao {
    private String url = "jdbc:postgresql://localhost:5432/my_pgdb";
    private String username = "postgres";
    private String password = "8520";

    private static final String query = "SELECT * FROM contact_requests WHERE status='archive'";

    public List<ArchiveRequestData> getArchiveData(){
        List<ArchiveRequestData> requests = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String message = rs.getString("message");
                String status = rs.getString("status");

                ArchiveRequestData req = new ArchiveRequestData(id,fullName,email,message,status);
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
