package controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController  implements Controler{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		return "WEB-INF/jsp/ProductForm.jsp";
	}

}
