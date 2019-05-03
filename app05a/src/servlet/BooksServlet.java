package servlet;

import model.*;
import util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;	
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet(name="BooksServlet", urlPatterns= {"/books"})
public class BooksServlet extends HttpServlet{
	private static final int serialVersionUID = -234237;
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = new BooksList().getBooksList();
		request.setAttribute("books",books);
		RequestDispatcher rd = request.getRequestDispatcher("/Books.jsp");
		rd.forward(request, response);
	}
}
