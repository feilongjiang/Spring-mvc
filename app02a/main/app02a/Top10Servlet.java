package app02a;
/*
 * 显示最受旅客青睐的10个伦敦和巴黎的景点
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name ="Top10Servlet", urlPatterns= {"/top10","/top"})
public class Top10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String> londonAttractions;
	private List<String> parisAttractions;
	
	@Override
	public void init() throws ServletException{
		londonAttractions = new ArrayList<String>(10);
		londonAttractions.add("Buckingham Palace");
		londonAttractions.add("london Eye");
		londonAttractions.add("British Museum");
		londonAttractions.add("National Gallery");
		londonAttractions.add("big ben");
		londonAttractions.add("Tower of london");
		londonAttractions.add("Canary Wharf");
		londonAttractions.add("2012 Olympic Park");
		londonAttractions.add("St Paul's CathedRal");
		londonAttractions.add("newyork");
		
		parisAttractions = new ArrayList<String>(10);
		for(int i = 0; i < 10; i++)
			parisAttractions.add("parisAttractions" + (i+1));
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		String city = request.getParameter("city");
		if(city != null && (city.equals("london") || city.equals("paris"))) {
			// show attractions
			showAttractions(request,response,city);
		}else {
			//show main page
			showMainPage(request,response);
		}
	}
	
	private void showMainPage(HttpServletRequest requset,HttpServletResponse response) 
				throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<!DOCTYPE html>"
				+ "<html><head><meta language='en' enconding='utf-8'><title>Top 10 attractions</title></head>"
				+ "<body>Please select a city: <br />"
				// 此处为相对url,  borwer 会在当前url后面加上href的内容 http://localhost:8080/app02a/top10?city=london
				+ "<a href='?city=london'>London</a> <br />" 
				+ "<a href='?city=paris'>Paris</a></body></html>");
	}
	private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city) 
				throws ServletException, IOException {
		int page = 1;
		// 得到page的值
		String pageParameter = request.getParameter("page");
		if(pageParameter != null) {
			try {
				page = Integer.parseInt(pageParameter);
			}catch(NumberFormatException e) {
				//do nothing and retain default value for page
			}
			if(page > 2) {
				page = 1;
			}
		}
			List<String> attractions = null;
			if(city.equals("london"))
				attractions = londonAttractions;
			else if(city.equals("paris"))
				attractions = parisAttractions;
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<html><head>"
					+ "<title> Top 10 Attractions </title>"  
					+ "</head><body>");
			writer.print("<a href='top10'>Seletct City</a>");
			writer.print("<hr/>page " + page + "<hr />");
			int start = page*5-5;
			for( int i = start; i < start + 5; i++) {
				writer.print(attractions.get(i) + "<br />");
			}
			writer.print("<hr style='color:blue;' />"
					+ "<a href='?city="+ city
					+ "&page=1'>page 1</a>");
			writer.print("&nbsp; <a href='?city=" + city +
					"&page=2'>page 2</a>");
		}
	}
	


