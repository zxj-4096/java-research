package com.zxj.datapool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private DBInit init;

	public DBConnection() throws SQLException, ClassNotFoundException {
		init = new DBInit();
		Class.forName(init.getDriver());

	}

	public Connection getDbconn() throws SQLException, ClassNotFoundException {
		return DriverManager.getConnection(init.getUrl(), init.getUser(),
				init.getPassword());
	}
}
