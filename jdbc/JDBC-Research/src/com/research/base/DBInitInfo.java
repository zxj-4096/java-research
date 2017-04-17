package com.research.base;

import java.util.ArrayList;
import java.util.List;

public class DBInitInfo {
	public static List<DBbean> beans = null;
	static {
		beans = new ArrayList<DBbean>();
		// �������� ���Դ�xml �������ļ����л�ȡ
		// Ϊ�˲��ԣ�������ֱ��д��
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
