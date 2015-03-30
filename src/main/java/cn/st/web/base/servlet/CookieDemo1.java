package cn.st.web.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�ϴη���ʱ��
public class CookieDemo1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write("���ϴη���ʱ�䣺<br/>");
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("lastAccessDate")){
				String cookieValue=cookies[i].getValue();
				pw.write(new Date(Long.parseLong(cookieValue)).toLocaleString()+"");
			}
		}
		Cookie cookie=new Cookie("lastAccessDate",System.currentTimeMillis()+"");
		cookie.setMaxAge(30*1*24*60*60);
		//��������� / ������վ
		cookie.setPath("/webbase");
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
