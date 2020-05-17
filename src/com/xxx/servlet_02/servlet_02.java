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
 * 1.创建动态web项目
 * 2.在指定包下（com.xxx.包名）创建普通Java类
 * 3.实现servlet标准，继承HttpServlet类
 * 4.重写service反复
 * 5.配置web.xml
 * 6.发布项目
 * 7.访问项目
 */
public class servlet_02 extends HttpServlet {
	  private static Connection conn;
	  private static Statement stmt;
	  private static final String driver = "com.mysql.jdbc.Driver";
	  private static final String url = "jdbc:mysql://127.0.0.1:3306/studentsdb";
	  private static final String user = "root";// Mysql用户名
	  private static final String mysqlpassword = "wzs879198";// Mysql密码
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
		System.out.println("请求到了servlet02");
		//resp.getWriter().write("HelloServlet!");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
		conn  = DriverManager.getConnection(url,user,mysqlpassword);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//TODO 如果conn==null 不能直接不负责任的return  而是重新连接数据库
		if(conn==null)
		{
			System.out.println("conn 为NULL");
			connect();
			if(!connect())
			return;
		}	
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String uname = req.getParameter("uname");
		String upwd= req.getParameter("upwd");
		String sql ="select password from user_3 where username ='"+uname+"'";
		String password=null;
		try {	
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		PrintWriter writer=resp.getWriter();
		try {
			if(rs.next()){
				password=rs.getString("password");
			}
			else {
				writer.write("<h1>用户名或密码不正确!<h1>");
				return;
			}
		} catch (SQLException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}
			if(uname==null ||"".equals(uname))
			{
				writer.write("<h1>账号不能为空!<h1>");
				return;
			}
			if(uname==null ||"".equals(upwd))
			{
				writer.write("<h1>密码不能为空!<h1>");
				return;
			}
				if(password.equals(upwd))
				{
					writer.write("<h1>恭喜"+uname+"登录成功!<h1>");
					return;
				}
		
			writer.write("<h1>用户名或密码不正确!<h1>");
			writer.close(); 		
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("uname")+"\n");
				System.out.print(rs.getString("upwd")+"\n");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}	
	}
}
