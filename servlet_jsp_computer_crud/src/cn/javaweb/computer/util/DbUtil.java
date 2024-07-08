package cn.javaweb.computer.util;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DbUtil {
    public static Connection getCon() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/computer";
        String username = "root";
        String password = "123456";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    /*
    关闭连接
     */
   public static void closeCon(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
