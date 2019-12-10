import java.sql.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=bookstore";
        String sql = "select id,name from category ";
        Connection conn = DriverManager.getConnection(url,"sa","sherlock1999");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while(rs.next()){
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
        }
    }
}
