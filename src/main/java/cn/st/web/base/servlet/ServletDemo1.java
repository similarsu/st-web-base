package cn.st.web.base.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet������Ϣ
 */
public class ServletDemo1 extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test2(response);
	}
	
	private void test2(HttpServletResponse response) throws IOException {
		 ServletConfig sc=this.getServletConfig();
		 Enumeration em=sc.getInitParameterNames();
		 while(em.hasMoreElements()){
			 String name=(String) em.nextElement();
			 System.out.println(name+"="+sc.getInitParameter(name));
		 }
	}

	private void test1(HttpServletResponse response) throws IOException {
		String data=this.getServletConfig().getInitParameter("data");
		response.getOutputStream().write(data.getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
