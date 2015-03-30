package cn.st.web.base.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.st.web.base.dao.UserDao;

/***
 * webӦ��������Ϣ
 * ����2��3������
 * 3���Ի�ȡ�ļ�������
 * @author coolearth
 *
 */
public class ServletDemo2 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test3();
	}
	
	private void test3() throws IOException {
		ServletContext sc=this.getServletContext();
		String path=sc.getRealPath("/WEB-INF/classes/jdbc.properties");
		FileInputStream is=new FileInputStream(path);
		
		Properties properties=new Properties();
		properties.load(is);
		
		System.out.println(properties.get("url"));
		System.out.println(properties.get("username"));
		System.out.println(properties.get("password"));
	}
	
	//��ȡ��Դ�ļ�jdbc.properties��Ϣ
	private void test2() throws IOException {
		ServletContext sc=this.getServletContext();
		InputStream is=sc.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
		
		Properties properties=new Properties();
		properties.load(is);
		
		System.out.println(properties.get("url"));
		System.out.println(properties.get("username"));
		System.out.println(properties.get("password"));
	}

	//��ȡwebӦ����web.xml��context-param
	private void test1(HttpServletResponse response) throws IOException {
		 ServletContext sc=this.getServletConfig().getServletContext();
		 String data=sc.getInitParameter("data");
		 response.getOutputStream().write(data.getBytes());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
