package customtag;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyFirstTag implements SimpleTag{
	JspContext jspContext;
	
	public void doTag() throws IOException, JspException{//输出
		System.out.println("dotag");
		jspContext.getOut().print("This is my first tag.");
	}
	public void setParent(JspTag jspTag) {//只有标签被嵌套才会调用
		System.out.println("setParent");
	}
	public JspTag getParent() { 
		System.out.println("getparent");
		return null;
	}
	public void setJspContext(JspContext jspContext) { //jsp容器 首先会调用setJSpContext方法
		System.out.println("setJspcontext");
		this.jspContext = jspContext;
	}
	public void setJspBody(JspFragment body) {//如果标签里面有内容则会调用setJspBody方法,否则不会调用
		System.out.println("setJspBody");
	}
}









