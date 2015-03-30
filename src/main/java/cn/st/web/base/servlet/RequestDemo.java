package cn.st.web.base.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo
 */
public class RequestDemo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test3(request);
	}

	private void test1(HttpServletRequest request) {
		String id=request.getParameter("id");
		System.out.println(id);
		String name=request.getParameter("name");
		System.out.println(name);
		String password=request.getParameter("password");
		System.out.println(password);
		String city=request.getParameter("city");
		System.out.println(city);
		String gender=request.getParameter("gender");
		System.out.println(gender);
		String[] aihao=request.getParameterValues("aihao");
		for(int i=0;aihao!=null&&i<aihao.length;i++){
			System.out.println(aihao[i]);
		}
		String description=request.getParameter("description");
		System.out.println(description);
	}
	
	//���post��������
	private void test2(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		System.out.println(name);
	}
	//�ֶ�get��������
	private void test3(HttpServletRequest request) throws UnsupportedEncodingException{
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"GBK");
		System.out.println(name);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
