package app02a.hiddenfields;
import  org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
public class Mysql_JDBC_Test{
	@Test
	public void mysql_test() throws ClassNotFoundException {
		Statement stmt = null;
		//assertEquals(stmt!=null,new Mysql_JDBC().getStatement());
		assert(new Mysql_JDBC().getStatement()!= null);
	}
}
