package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.cj.jdbc.*;

public class Url1 {
    public static final String URL = "jdbc:mysql://192.168.1.104:3306/gc";
    public static final String USER = "root";
    public static final String PASSWORD = "1";

    public static void main(String[] args) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("register success");
            } catch (ClassNotFoundException e1) {
                System.out.println("register fail");
                e1.printStackTrace();
            }//注册驱动
            
            try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){//连接
            Statement stmt = conn.createStatement();  //执行者
            ResultSet rs = stmt.executeQuery("SELECT * FROM books"); //结果集, 
                                         //
                while (rs.next()) {
                    System.out.println(rs.getString("author") + " "+rs.getString(2));
                }
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    }
}