package app02a.hiddenfields;

import java.sql.*;
import com.mysql.cj.jdbc.*;
import java.util.List;

public class Mysql_JDBC {
	private static final String URL = "jdbc:mysql://192.168.1.104:3306/mysql_test";
	private static final String USER = "root";
	private static final String PASSWD = "1";

	public Mysql_JDBC() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Connection connection = null;
	}

	public Statement getStatement() {
		Statement stmt = null;
		try  {
			Connection conn = DriverManager.getConnection(URL,USER,PASSWD);
		     stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
}
