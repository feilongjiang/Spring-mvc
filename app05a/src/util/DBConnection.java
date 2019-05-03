package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.cj.jdbc.*;

public class DBConnection {
	public static final String URL = "jdbc:mysql://192.168.1.104:3306/feilong";
	public static final String USER = "root";
	public static final String PASSWORD = "1";
	private static Connection conn = null;
	public static Connection getConn() {
		  try {
              Class.forName("com.mysql.jdbc.Driver");
              System.out.println("register success");
          } catch (ClassNotFoundException e1) {
              System.out.println("register fail");
              e1.printStackTrace();
          }//注册驱动
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
