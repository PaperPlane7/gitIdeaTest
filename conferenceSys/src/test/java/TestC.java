import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestC {
    public static void main(String[] args) {
        String drivername = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/conference_system";
        String username = "root";
        String password = "123";

        Connection conn = null;
        String sql = "select * from user";
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        int result = 0;
        try {
            Class.forName(drivername);
            conn = (Connection) DriverManager.getConnection(url,username,password);
            pstmt= (PreparedStatement) conn.prepareStatement(sql);
            rSet = pstmt.executeQuery();

            while (rSet.next()){
                System.out.println(rSet.getInt("userId"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
