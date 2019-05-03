package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.Servlet;
import javax.servlet.annotation.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.*;

import bean.Employee;
import bean.Product;
@WebServlet(name="test" ,urlPatterns= {"/test"})
public class Test extends HttpServlet{
	ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "springmvc-servlet.xml"});
	Product str1= new Product();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html charset='utf-8' ");
		PrintWriter writer = response.getWriter();
		Product featured =  (Product) context.getBean("featuredProduct",Product.class);
		Employee employee1 = context.getBean("employee1",Employee.class);
		writer.println( employee1.getLastName());
		
	}
}
