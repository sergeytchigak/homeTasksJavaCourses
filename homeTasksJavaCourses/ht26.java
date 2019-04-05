package hjk.JKK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/test_utomation?useSSL=false";
        String user = "root";
        String password = "St51113991";

         String query = "SELECT * FROM test_utomation.users;";
        //Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query))
        {
            if(rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
            rs.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();

        }
    }

}
