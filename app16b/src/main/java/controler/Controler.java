package controler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controler {
	String handleRequest(HttpServletRequest request,HttpServletResponse response) throws IOException ;

}
