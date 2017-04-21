package com.zxj.datapool;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;


/**
 * CREATE TABLE task (
 task_id mediumint(5) primary key NOT NULL AUTO_INCREMENT,
 task_title varchar(128) NOT NULL,
 task_content text NOT NULL,
 task_result text NOT NULL,
 task_status varchar(128) NOT NULL,
 task_user varchar(128) NOT NULL
); 
 * */
public class Task {
	public String addTask(String args) throws InterruptedException {
		return args;
	}

	public String getTask(String args) throws InterruptedException,
			ClassNotFoundException, SQLException, Exception {
		JSONObject jsonObj = new JSONObject();
		DBConnection co = new DBConnection();
		Connection conn = co.getDbconn();
		Statement statement = conn.createStatement();
		String sql = "select * from task";// where user_id = "+args;
		ResultSet rs = statement.executeQuery(sql);

		String name = null;
		Map<String, String> ingredients = new HashMap<String, String>();
		while (rs.next()) {
			name = rs.getString("task_id");
			name = new String(name.getBytes("ISO-8859-1"), "GB2312");
			ingredients.put(name, rs.getString("task_content"));
		}
		jsonObj.put("tasks", ingredients);
		rs.close();
		conn.close();
		return jsonObj.toString();
	}
}
