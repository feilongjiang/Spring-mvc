package app02a.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
//URL分别映射三个URL 前两个会调用doGet,  而 update会调用dopost方法
@WebServlet(name = "CustomerServlet", urlPatterns= {
		"/customer", "/editCustomer", "/updateCustomer"
})
public class CustomerServlet extends HttpServlet{
	private static final long serialVersionUID = -20L;
	//存储customers 数据
	private Vector<Customer> customers = new Vector<Customer>();
	@Override
	public void init() throws ServletException{
		Customer customer1 = new Customer();
		ResultSet rs = null;
		// 读取数据库的customer数据
		try (Statement stmt = new Mysql_JDBC().getStatement()){
			 rs = stmt.executeQuery("SELECT cust_id,cust_name,cust_city FROM mysql_test.customer where cust_id <100 ");
			 while(rs.next())
			 {
				 Customer cust = new Customer();
				 cust.setId(rs.getInt("cust_id"));
				 cust.setName(rs.getString("cust_name"));
				 cust.setCity(rs.getString("cust_city"));
				 customers.add(cust);
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
		}
	}
	
	private void sendCusomer(HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8' ><title>Customers</title></head>"
				+ "<body><h2>Customerss </h2>");
		for(Customer customer : customers) {
			writer.println("<li>" + customer.getName() +
					"(" + customer.getCity() + ") (" +
					"<a href='editCustomer?id="+ customer.getId() //当用户点击<a>标签 URL 会调用doGet()
					+ " '>edit )</a> </li>");
		}
		
		writer.println("<ul>");
		writer.println("</body></html>");
	}
	
	 private Customer getCustomer(int cust_id) {
		    for (Customer cust : customers) {
		    	if (cust.getId() == cust_id)
		    		return cust;
		    }
		    return null;
		}
		
	private void sendEditCustomerForm(HttpServletRequest request,HttpServletResponse response)
					throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		int cust_id = 0;
		try {
			cust_id = Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e) {
			
		}
		Customer customer = getCustomer(cust_id);
		if ( customer != null) {
			writer.println("<!DOCTYPE html> <html lang='en' ><head>"
					+ "<meta  charset='UTF-8' >"
					+ "<title>Edit Customer</title></head>"
					+ "<body><h2>Edit Customer</h2>"
					+ "<form method = 'post' "
					+ "action = 'updateCustomer'>");
			/* hidden 定义隐藏字段 */
			writer.println("<input type='hidden' name='id' value='"
					+ cust_id + "' />" );
			writer.println("<table>");
			writer.println("<tr><td>name: </td><td>"
					+ "<input name='name' value= '"
					+ customer.getName()
					+ "'</td></tr>");
			writer.println("<tr><td>city: </td><td>"
					+ "<input name='city' value= '"
					+ customer.getCity()
					+ "'/></td></tr>");
			writer.println("<tr>"
					+ "<td colspan='2	' style='text-algin:right'>"
					// 当点击提交submit  会将隐藏(hddien) 的键对值发送给doPost
					+ "<input type='submit' value='Update' /></td>"
					+ "</tr>");
			
			writer.println("<tr>"
					+ "<td colspan='2	'>"
					+ "<a href='customer'>Customer List</a></td>"
					+ "</tr>");
			writer.println("</table></form></body></html>");
		}else
			writer.println("No customer found");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("/customer")) {
			sendCusomer(response);
		}else if (uri.endsWith("/editCustomer"))
			sendEditCustomerForm(request,response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//update customer
		request.setCharacterEncoding("UTF-8");
		int cust_id = 0;
		try {
			cust_id=Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e) {
			
		}
		Customer cust = getCustomer(cust_id);
		if (cust != null) {
			cust.setName( request.getParameter("name"));
			cust.setCity(request.getParameter("city"));
		}
		sendCusomer(response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
