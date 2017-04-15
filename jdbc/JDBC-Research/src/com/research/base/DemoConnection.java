package com.research.base;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DemoConnection {
	private String driver;
	private String url;
	private String user;
	private String pass;
	Connection conn;
	Statement stmt;
	private PreparedStatement pstmt;
	public void initParam(String paramFile)throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public void createTable(String sql)throws Exception{
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet rs = stmt.executeQuery(sql);

			 while(rs.next()) {   
			       System.out.println(rs.getInt("ID")+","+rs.getString("NAME"));
			      }
		}finally{
			if(stmt !=null){
				stmt.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	}

	public static void main(String[] args) throws Exception{
		DemoConnection dc = new DemoConnection();
		dc.initParam("h2.ini");
		dc.createTable("select * from test");
	}
	  /*
	public static void main(String[] args) throws Exception{
		Class.forName("org.h2.Driver");
		   Connection conn = DriverManager.
		       getConnection("jdbc:h2:D:/F/htmlprj/srchub/java/jdbc/JDBC-Research/H2db/test","sa", "sa");
		   // add application code here
		   Statement stmt = conn.createStatement();
		   ResultSet rs = stmt.executeQuery("SELECT * FROM TEST ");   
		      while(rs.next()) {   
		       System.out.println(rs.getInt("ID")+","+rs.getString("NAME"));
		      }
		   conn.close();
		 
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/javadbtest";
		String user = "root";
		String password = "bl7325817";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			String sql = "select * from user";
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println(" 学号" + "\t" + " 姓名");
			System.out.println("-----------------");

			String name = null;
			while (rs.next()) {
				name = rs.getString("name");
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				System.out.println(rs.getString("password") + "\t" + name);
			}

			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
