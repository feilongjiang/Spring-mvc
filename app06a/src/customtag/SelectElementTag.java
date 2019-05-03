package customtag;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectElementTag extends SimpleTagSupport {
private String[] countries = {"Australia", "Brazil", "China" };

	public void doTag() throws IOException, JspException {
		JspContext jspContext = getJspContext();
		JspWriter out = jspContext.getOut();
		out.print("<select>\n");
		for (int i = 0; i < 3; i++) {
			// 每次循环设置一次Attribute 然后利用invoke输出
			getJspContext().setAttribute("value", countries[i]);
			getJspContext().setAttribute("text", countries[i]);
			getJspBody().invoke(null); //getJSpBody得到的是标签中间的内容,在这里是 <option value="${value}">${text}</option>
			
		}
		out.print("</select>\n");
	}
}
