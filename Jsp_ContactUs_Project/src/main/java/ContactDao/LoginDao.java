package ContactDao;

import java.sql.*;

public class LoginDao {
    private String url = "jdbc:postgresql://localhost:5432/my_pgdb";
    private String username = "postgres";
    private String pass = "8520";

    private static final String query = "SELECT * FROM login WHERE username=? and password=?";

    public boolean getData(String name, String password){

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,username,pass);
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,name);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }
}
