package servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="J_security_check", urlPatterns= {"/login"})
public class J_security_check extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException{
		
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String j_username = request.getParameter("j_username");
		String j_password = request.getParameter("j_password");
		RequestDispatcher index	 = request.getRequestDispatcher("/index.jsp");
		RequestDispatcher error = request.getRequestDispatcher("/error.html");
		if((j_username.equals("tom"))&& (j_password.equals("1"))){
			index.forward(request, response);
		}
		else
			error.forward(request, response);
		
	}
}
