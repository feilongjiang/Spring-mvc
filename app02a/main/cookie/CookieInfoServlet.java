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

@WebServlet(name = "CookieInfoServlet", urlPatterns = { "/cookieinfo" })
public class CookieInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 3829L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 得到cookies的数组
		Cookie[] cookies = request.getCookies();
		StringBuilder styles = new StringBuilder();
		if( cookies != null) {
			for(Cookie cookie : cookies)
			{
				String name = cookie.getName();
				String value =cookie.getValue();
				if ( name.equals("titleFontSize"))
					styles.append("font-size: " + value + ":");
				else if ( name.equals("titleFontWeight"))
					styles.append("titleFontWeight: " + value + ":");
				else if ( name.equals("font-weight"))
					styles.append("font-weight: " + value + ":");
			}
		}
		styles.append("}");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"	<meta charset=\"UTF-8\">\r\n" + 
				"	<title>Styles.toString()</title>\r\n" + 
				"</head>\r\n" + 
				"<body>" + PreferenceServlet.MENU +
				"<div class=\"title\">Session management with cookies:\r\n" + 
				"	</div>");
		
		//cookies will be null if there's no cookie
		if ( cookies ==null) {
			writer.print("NO cookie in this http response"  );
		}
		else {
			writer.println("<br/> Cookies in this http response: ");
			for(Cookie cookie : cookies) {
				writer.println("<br /> " + cookie.getName() + ": "
						+ cookie.getValue());
			}
		}
		writer.println("</body>\r\n" + 
				"</html>");
	}

}
