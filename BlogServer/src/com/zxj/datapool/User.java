package com.zxj.datapool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class User {
	public static void main(String[] args) throws InterruptedException{
		String myString = null;
			JSONObject jsonObj = new JSONObject();
		try {
			myString = new JSONStringer().object()     
					.key("name")    
					.value("小猪")     
					.endObject()    
					.toString();
			Map <String, String> ingredients = new HashMap <String, String>();
			ingredients.put("apples", "3kg");
			ingredients.put("sugar", "1kg");
			ingredients.put("pastry", "2.4kg");
			ingredients.put("bestEaten", "outdoors");
			jsonObj.put("ingredients", ingredients);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User u = new User();
		System.out.println(u.getUser(""));
		
	}
	public String getUser(String args) throws InterruptedException {
		
		String str = null;
			JSONObject jsonObj = new JSONObject();
		try {
			DBConnection co = new DBConnection();
			Connection conn = co.getDbconn();//DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			String sql = "select * from user";//where user_id = "+args;
			ResultSet rs = statement.executeQuery(sql);

			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println(" 学号" + "\t" + " 姓名");
			System.out.println("-----------------");

			String name = null;
			Map <String, String> ingredients = new HashMap <String, String>();
			while (rs.next()) {
				name = rs.getString("user_name");
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				str = rs.getString("user_pwd") + "\t" + name;
				ingredients.put(name,rs.getString("user_pwd") );
			}
			jsonObj.put("user",ingredients);

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
		return jsonObj.toString();
	}
}
