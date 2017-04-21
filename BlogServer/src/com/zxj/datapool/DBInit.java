package com.zxj.datapool;

public class DBInit {
	private String driver = "";
	private String url = "";
	private String user = "";
	private String password = "";
	public DBInit(){
		setDriver("com.mysql.jdbc.Driver");
		setUrl("jdbc:mysql://127.0.0.1:3306/myblog");
		setUser("root");
		setPassword("bl7325817");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
}
