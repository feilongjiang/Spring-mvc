package cookie;
/*
 * 
 */
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

@WebServlet(name = "CookieClassServlet", urlPatterns = { "/cookieClass" })
public class CookieClassServlet extends HttpServlet{
	private static final long serialVersionUID = 837369L;
	
	private String[] methods = {
			"cone1","cone2","cone3","cone4","cone5","cone6","cone7","cone8","cone9",
			"cone10","cone11","cone12","cone13","cone14","cone15","cone16","cone17","cone18",
	};
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Cookie[] cookies = request.getCookies();
		Cookie maxRecordsCookie = null;
		if(cookies != null)
		{
			for(Cookie cookie: cookies)
			{
				if(cookie.getName().contentEquals("maxRecords")) {
					maxRecordsCookie = cookie;
					break;
				}
			}
		}
		
		int maxRecords = 5;
		if (maxRecordsCookie !=null)
		{
			try {
				// 得到cookie的值
				maxRecords = Integer.parseInt(maxRecordsCookie.getValue());
			}catch(NumberFormatException e) {
				
			}
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"	<meta charset=\"UTF-8\">\r\n" + 
				"	<title>Cookie class</title>\r\n" + 
				"</head>\r\n" + 
				"<body>"
				+ PreferenceServlet.MENU +
				"<div>Here are some of the methods in javax.servlet.http.Cookie\r\n" + 
				"	<ul>");
		for( int i =0; i<maxRecords; i++) 
			writer.print("<li>" + methods[i] + "</li>");
			
			writer.print("</ul>\r\n" + 
					"	</div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
		
	}
	
}




















