package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class EmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 10L;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Address address  = new Address();
		address.setStreetName("Rue ");
		address.setStreetNumber("509ab");
		address.setCity("Brossard");
		address.setState("Quebec");
		address.setZipCode("A1A B2b");
		address.setCountry("canada");
		Employee employee = new Employee();
		employee.setId(1099);
		employee.setName("charles");
		employee.setAddress(address);
		
		request.setAttribute("employee",employee);
		
					Map<String, String> capitals = new HashMap<String,String>();
					capitals.put("China" ,"Beijing");
					capitals.put("Austria","Vienna");
					capitals.put("Australia","Canberra");
					capitals.put("Canada","Ottua");
		
		request.setAttribute("capitals", capitals);
		/*定义一个对象，该对象接收来自客户端的请求，并将它们发送到服务器上的任何资源（例如servlet，HTML文件或JSP文件）。servlet容器创建RequestDispatcher对象，该对象用作位于特定路径或由特定名称给定的服务器资源的包装器。
		此接口旨在包装servlet，但servlet容器可以创建RequestDispatcher 对象以包装任何类型的资源。*/
		RequestDispatcher rd = request.getRequestDispatcher("/employee.jsp"); 
		/* 将来自servlet的请求转发到服务器上的另一个资源（servlet，JSP文件或HTML文件）。*/
		rd.forward(request,response);		
	}

}
