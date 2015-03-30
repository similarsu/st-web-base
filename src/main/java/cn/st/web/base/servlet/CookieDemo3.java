package cn.st.web.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �鼮��ϸҳ�棺 չ���鼮��Ϣ�ͻ�д�����¼cookie
 */
public class CookieDemo3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("id");
		DB db=new DB();
		Book book=db.getAll().get(id);
		pw.write(book.getId()+"<br/>");
		pw.write(book.getName()+"<br/>");
		pw.write(book.getAuthor()+"<br/>");
		pw.write(book.getDescription()+"<br/>");
		//cookie
		String cookieValue=buildCookie(id,request);
		Cookie cookie=new Cookie("book",cookieValue);
		cookie.setPath("/webbase");
		cookie.setMaxAge(30*1*24*60*60);
		response.addCookie(cookie);
	}
	
	/**
	 * ����cookie ��໺�� 3��
	 * @param id
	 * @param request
	 * @return
	 */
	private String buildCookie(String id, HttpServletRequest request) {
		//����������洢cookie����������
		//���  ��1,2,3 ��ʽ �洢
		String cookieValue=null;
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("book")){
				cookieValue=cookies[i].getValue();
			}
		}
		//�����������
		//a.cookie û������
		if(cookieValue==null){
			return id;
		}
		LinkedList<String> list=new LinkedList<String>(Arrays.asList(cookieValue.split("\\,")));
		
		if(list.size()==3){
			//b.cookie 2��1��3     1 ====�� 1��2��3    
			if(list.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}
			//c.cookie 2��1��3     4 ====��4��2��1
			else{
				list.removeLast();
				list.addFirst(id);
			}
		}else{
			//d.cookie 3,2       1 ====> 1,3,2
			list.remove(id);
			list.addFirst(id);
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;list!=null&&i<list.size();i++){
			sb.append(list.get(i)+",");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
