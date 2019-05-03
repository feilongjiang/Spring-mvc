package filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "LoggingFilter", urlPatterns = { "/ *" }, initParams = {
		@WebInitParam(name = "logFileName", value = "log.txt"), @WebInitParam(name = "prefix", value = "URI: ") })
public class LoggingFilter implements Filter {
	private PrintWriter logger;
	private String prefix;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		prefix = filterConfig.getInitParameter("prefix"); //得到URI
		String logFileName = filterConfig.getInitParameter("logFileName");
		String appPath = filterConfig.getServletContext().getRealPath("/"); //得到项目路径
// without path info in logFileName, the log file will be
// created in $TOMCAT_HOME/bin
		System.out.println("logFileName:" + logFileName);
		try {
			logger = new PrintWriter(new File(appPath, logFileName)); //打开文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	@Override
	public void destroy() {
		System.out.println("destroying filter");
		if (logger != null) {
			logger.close();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("LoggingFilter.doFilter");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		logger.println(new Date() + " " + prefix + httpServletRequest.getRequestURI()); //写入数据
		logger.flush(); //刷新缓冲
		filterChain.doFilter(request, response); //如果没有doFilter方法,后面发Filter处理就会中断
	}
	
}
