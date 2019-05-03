package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name ="PreferenceServlet", urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet{
	private static final long serialVersionUID = 888L;
	public static final String MENU = 
			"<div style = 'background:#e8e8e8;"
			+ "padding:15px'>"
			+ "<a href='cookieClass'>Cookie class </a>&nbsp;&nbsp;"
			+ "<a href='cookieinfo'>Cookie info </a>&nbsp;&nbsp;"
			+ "<a href='preference'>preference</a>" + "</div>";
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html lang='en'>\r\n" + 
				"<head>\r\n" + 
				"<meta charset='UTF-8' />\r\n" + 
				"<title>Preference</title>\r\n" + 
				"<style>\r\n" + 
				"table{\r\n" + 
				"font-size:samll;\r\n" + 
				"background:WHILE;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head><body>"
				+ MENU
				+ "Please select the value below:\r\n" + 
				"<form method='post' action=\"\">\r\n" + 
				"	<table>\r\n" + 
				"		<tr>\r\n" + 
				"		<td>Title Font Size:</td>\r\n" + 
				"		<td><select name='titleFontSize' >\r\n" + 
				"		<option >large</option>\r\n" + 
				"		<option >x-large</option>\r\n" + 
				"		<option >xx-large</option>\r\n" + 
				"		</select>\r\n" + 
				"		</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td>Title Style %26 Weight: </td>\r\n" + 
				"			<td><select name='titleStyleAndWeight' multiple=\"multiple\" size='2'>\r\n" + 
				"			<option >italic</option>\r\n" + 
				"			<option >bold</option>\r\n" + 
				"			<option >3 </option>" +
				"			</select>\r\n" + 
				"			</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td>Max, Records in Table: </td>\r\n" + 
				"			<td><select name='maxRecords'>\r\n" + 
				"			<option >5</option>\r\n" + 
				"			<option >10</option>\r\n" + 
				"			</select></td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td rowspan=\"2\">\r\n" + 
				"			<input type=\"submit\" value=\"set\" />\r\n" + 
				"			</td>\r\n" + 
				"		</tr>\r\n" + 
				"	</table>\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		// 得到浏览器发送的值
		String maxRecords = request.getParameter("maxRecords");
		String[] titleStyleAndWeight = request.getParameterValues("titleStyleAndWeight");
	
		String titleFontSize =
				request.getParameter("titleFontSize");
		// 创建Cookie 并发送
		response.addCookie(new Cookie("maxRecords",maxRecords));
		response.addCookie(new Cookie("titleFontSize",titleFontSize));
		//delete titleFontWeight and titleFontStyle cookies first
		// delete cookie by adding a cookie with the maxAage = 0;
		Cookie cookie =  new Cookie("titleFontWeight","");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		cookie = new Cookie("titleFontStyle","");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		if(titleStyleAndWeight != null) {
			for( String style : titleStyleAndWeight) 
			{
				if(style.contentEquals("bold"))
				response.addCookie(new Cookie("TitleFontWeight","bold"));
				else if (style.contentEquals("italic")) 
				{
				response.addCookie(new Cookie("titleFontStyle","italic"));	
				}
			} 
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html lang='en'>\r\n" + 
				"<head>\r\n" + 
				"<meta charset='UTF-8' />\r\n" + 
				"<title>Preference</title>\r\n" + 
				"</head><body>"
				+ MENU
				+ "Please select the value below:\r\n" +
				"<br/><br/> Max. Records in Table: " + maxRecords
				+ "<br/>Title Font Size: " + titleFontSize
				+ "<br/>TitleFOnt Style & Weight: "
				);
		//titleStyleAnd Weight will be null if none of the options
		//was selected 
		if(titleStyleAndWeight != null) {
			writer.println("<ul>");
			for (String style : titleStyleAndWeight)
				writer.print("<li>" + style + "</li>");
			writer.println("</ul>");
		}
		writer.println("</body></html>");
	}
			
}





















