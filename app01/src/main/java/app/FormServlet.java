package app;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String[] nReplace = { "NAME", "ADDRESS", "COUNTRY", "DELMETHOD", "CATALOG",
			"INSTRUCTIONS", "PARAMETERNAMES" };
	private static final String[] names = { "name", "address", "country", "delivery", "catalog", "instruction",
			"parameternames" };
	private static final String[] nValue = new String[7];
	//当html页面的标签<form method ="get" >是get方法时会调用此方法
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String path = this.getServletContext().getRealPath("/WEB-INF/form.html");
		String s = null;
		s = read(path);
		writer.print(s);

	}

	//当html页面的标签<form method ="post" >是post方法时会调用此方法
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		StringBuilder INSTRUCTIONS = new StringBuilder();
		StringBuilder PARAMETERNAMES = new StringBuilder();
		for (int i = 0; i < 4; i++)
			nValue[i] = request.getParameter(names[i]); // 得到元素的值

		String[] instructions = request.getParameterValues("instruction");
		if (instructions != null) {
			for (String instruction : instructions)
				INSTRUCTIONS.append(instruction + "<br>");
			nValue[5] = INSTRUCTIONS.toString();
		}
		if (request.getParameter("catalog") == null)
			nValue[4] = "No";
		else
			nValue[4] = "Yes";
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			PARAMETERNAMES.append(parameterName + "<br />");
			nValue[6] = PARAMETERNAMES.toString();
		}

		String path = this.getServletContext().getRealPath("/WEB-INF/order_form.html");
		
		String s = null;
		s = read(path);
		for (int i = 0; i < nReplace.length; i++)
			s = replace(s, nReplace[i],nValue[i]);
		writer.print(s);
	}

	public static String replace(String html, String nReplace, String nameValue) {
		String str = html;
		Pattern pattern = Pattern.compile(">" + nReplace);
		Matcher matcher = pattern.matcher(html);
		if(nameValue !=null )
			str = matcher.replaceAll(">" +nameValue);
		else
			str = matcher.replaceAll(">");

		return str;
	}

	public static String read(String path) throws IOException {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader in = new BufferedReader(new FileReader(new File(path).getAbsoluteFile()))) {
			try {
				String s = null;
				while ((s = in.readLine()) != null) {
					sb.append(s + "\n");
				}
			} finally {
				if (in != null)
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return sb.toString();
	}
}
