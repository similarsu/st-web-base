package cn.st.web.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ҳ �����鼮�б�������¼�б�
 */
public class CookieDemo2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write("����վ������ͼ�飬����鿴����<br/>");
		DB db=new DB();
		for(Map.Entry<String,Book> entry:db.getAll().entrySet()){
			pw.write("<a target='_blank' href='/webbase/CookieDemo3?id="+entry.getKey()+"'>"+entry.getValue().getName()+"</a><br/>");
		}
		
		pw.write("<hr/>");
		pw.write("������������鼮<br/>");
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("book")){
				String[] ids=cookies[i].getValue().split("\\,");
				for(String id:ids){
					Book book=db.getAll().get(id);
					pw.write(book.getName()+"<br/>");
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
//���ݼ��� �� map �ȽϺ� ����Ҫ����� ���� LinkedHashMap
class DB{
	private LinkedHashMap<String,Book> map=new LinkedHashMap<String, Book>();
	{
		map.put("1", new Book("1","j2seʵս","�ٶ�1","˫���ķ���ط���"));
		map.put("2", new Book("2","j2eeʵս","�ٶ�2","�����ڻ���"));
		map.put("3", new Book("3","j2meʵս","�ٶ�3","we����Ƿ����"));
		map.put("4", new Book("4","androidʵս","�ٶ�4","˵����i�Ҽһ���"));
		map.put("5", new Book("5","springʵս","�ٶ�5","���ƽϾ���"));
	}
	
	public LinkedHashMap<String,Book> getAll(){
		return map;
	}
}

class Book{
	private String id;
	private String name;
	private String author;
	private String description;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String id, String name, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
