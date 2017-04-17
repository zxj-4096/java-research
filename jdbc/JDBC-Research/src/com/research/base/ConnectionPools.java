package com.research.base;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionPools {
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
}
