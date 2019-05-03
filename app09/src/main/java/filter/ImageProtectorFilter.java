package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


//过滤所有以.png , .jpg  .gif 为后缀的访问
@WebFilter(filterName = "ImageProtetorFilter", urlPatterns = { "*.png", "*.jpg", "*.gif" })
public class ImageProtectorFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//直接输入图片地址访问http://localhost:8080/app09/图片.jpg会被拦截
		System.out.println("ImageProtectorFilter");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String referrer = httpServletRequest.getHeader("referer");
		System.out.println("referrer:" + referrer);
		if (referrer != null) {
			filterChain.doFilter(request, response);
		} else {
			throw new ServletException("Image not available");
		}
	}
}
