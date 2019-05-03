package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

@WebServlet(name = "GenricServletDemoServlet",
		urlPatterns = { "/generic" },
		initParams =  {
				@WebInitParam(name="admin", value="jiangfeilong"),
				@WebInitParam(name="email", value="admin@example.com")
		}
		)
public class GenericServletDemoServlet  extends GenericServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 62500890L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		String admin = servletConfig.getInitParameter("admin");
		String email = servletConfig.getInitParameter("email");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>" +
					"Admin: " + admin + "<br /> Eamil: " + email +
					"</body></html>");
		
	}

}
