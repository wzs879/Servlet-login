package com.xxx.servlet_02;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * *
 * 
 * 1.������̬web��Ŀ
 * 2.��ָ�����£�com.xxx.������������ͨJava��
 * 3.ʵ��servlet��׼���̳�HttpServlet��
 * 4.��дservice����
 * 5.����web.xml
 * 6.������Ŀ
 * 7.������Ŀ
 */
public class servlet_02 extends HttpServlet {
	  private static Connection conn;
	  private static Statement stmt;
	  private static final String driver = "com.mysql.jdbc.Driver";
	  private static final String url = "jdbc:mysql://127.0.0.1:3306/studentsdb";
	  private static final String user = "root";// Mysql�û���
	  private static final String mysqlpassword = "wzs879198";// Mysql����
	  ResultSet rs;

	public boolean connect() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(driver);
				conn= DriverManager.getConnection(url,user,mysqlpassword);
			}
			if(!conn.isClosed()) {
				return true;
			}
		}catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	} 
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("������servlet02");
		//resp.getWriter().write("HelloServlet!");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
		conn  = DriverManager.getConnection(url,user,mysqlpassword);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//TODO ���conn==null ����ֱ�Ӳ������ε�return  ���������������ݿ�
		if(conn==null)
		{
			System.out.println("conn ΪNULL");
			connect();
			if(!connect())
			return;
		}	
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		String uname = req.getParameter("uname");
		String upwd= req.getParameter("upwd");
		String sql ="select password from user_3 where username ='"+uname+"'";
		String password=null;
		try {	
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		PrintWriter writer=resp.getWriter();
		try {
			if(rs.next()){
				password=rs.getString("password");
			}
			else {
				writer.write("<h1>�û��������벻��ȷ!<h1>");
				return;
			}
		} catch (SQLException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
		}
			if(uname==null ||"".equals(uname))
			{
				writer.write("<h1>�˺Ų���Ϊ��!<h1>");
				return;
			}
			if(uname==null ||"".equals(upwd))
			{
				writer.write("<h1>���벻��Ϊ��!<h1>");
				return;
			}
				if(password.equals(upwd))
				{
					writer.write("<h1>��ϲ"+uname+"��¼�ɹ�!<h1>");
					return;
				}
		
			writer.write("<h1>�û��������벻��ȷ!<h1>");
			writer.close(); 		
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("uname")+"\n");
				System.out.print(rs.getString("upwd")+"\n");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}	
	}
}
