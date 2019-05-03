package listener;

import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;

import model.Product;

@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener ,HttpSessionAttributeListener,
				ServletRequestAttributeListener{
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("I was called............");
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object value = event.getValue();
	//	System.out.println("name = " + name + ", value is " + value + "I am from HttpSessionBindingEvent");	
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("userCounter", new AtomicInteger());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int userCount = userCounter.incrementAndGet();
		System.out.println("userCount incremented to :" + userCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int userCount = userCounter.decrementAndGet();
		System.out.println("---------- userCount decremented to:" + userCount);
	}
}
