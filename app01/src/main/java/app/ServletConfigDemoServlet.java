package app;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletConfigDemoServlet",
		urlPatterns =  {"/servletConfigDemo"},
		initParams = { 		//给Servlet 传入两个参数(admin和email)
				@WebInitParam(name="admin", value="Harry Taciak"), 
				@WebInitParam(name="email", value = "admin@example.com")
})
public class ServletConfigDemoServlet  implements Servlet{
		private transient ServletConfig servletConfig;
		
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ServletConfig getServletConfig() {
			return servletConfig;
		}

		@Override
		public String getServletInfo() {
			return "ServletConfig Demo1";
		}

		@Override
		public void init(ServletConfig servletConfig) throws ServletException {
			this.servletConfig = servletConfig;  //接受servletConfig
		}

		@Override
		public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			ServletConfig servletConfig = getServletConfig();// 
			String admin = servletConfig.getInitParameter("admin"); //得到admin的value
			String email = servletConfig.getInitParameter("email"); //的到Email的value
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<html><head></head><body>" +
					"Admin: " + admin + "<br /> Eamil: " + email +
					"</body></html>");
		}
		
}
