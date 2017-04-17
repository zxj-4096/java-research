package com.research.base;

import java.util.ArrayList;
import java.util.List;

public class DBInitInfo {
	public static List<DBbean> beans = null;
	static {
		beans = new ArrayList<DBbean>();
		// 这里数据 可以从xml 等配置文件进行获取
		// 为了测试，这里我直接写死
		DBbean beanOracle = new DBbean();
		beanOracle.setDriverName("org.h2.Driver");
		beanOracle.setUrl("jdbc:h2:D:/F/htmlprj/srchub/java/jdbc/JDBC-Research/H2db/test");
		beanOracle.setUserName("sa");
		beanOracle.setPassword("sa");

		beanOracle.setMinConnections(5);
		beanOracle.setMaxConnections(100);

		beanOracle.setPoolName("testPool");
		beans.add(beanOracle);
	}
}
