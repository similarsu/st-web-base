package cn.st.web.base.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/***
 * ��ͨjavaͨ��classlaoder��ȡ��Դ�ļ�
 * ����1��2������
 * 2�޸�jdbc.properties��������Ͽ���Ч����
 * ����2���Ի�ȡ�ļ�������
 * @author coolearth
 *
 */
public class UserDao {
	public void add(){
		test2();
		
	}
	
	private void test2() throws ExceptionInInitializerError {
		String path=this.getClass().getClassLoader().getResource("jdbc.properties").getPath();
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
		System.out.println(properties.get("url"));
		System.out.println(properties.get("username"));
		System.out.println(properties.get("password"));
	}

	private void test() throws ExceptionInInitializerError {
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties properties=new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
		System.out.println(properties.get("url"));
		System.out.println(properties.get("username"));
		System.out.println(properties.get("password"));
	}
}
