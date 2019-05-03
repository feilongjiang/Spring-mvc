package model;

import java.sql.*;
import java.util.*;
import util.DBConnection;
public class BooksList {
	private Connection conn = null;
	public List<Book> getBooksList(){
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		try {
			conn = DBConnection.getConn();
			String sql = "SELECT * FROM books";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); 
			while(rs.next())
			{
				book = new Book(rs.getInt("isbn"),rs.getString("title"),rs.getFloat("price"));
				books.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
