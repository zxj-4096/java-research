JDBC学习目录

包含
1.基本的连接技术及针对缺点的改进连接方式
/////
使用jdbc开发时有以下缺点

1，数据库连接，使用时就创建，不使用就释放，对数据库进行频繁连接开关和关闭，造成数据库资源浪费，影响数据库的性能 
解决：使用数据库连接池管理数据库的连接 
2，sql语句使用硬编码在java程序中，修改sql语句，就需要重新编译java代码，不利于系统维护 
解决：把sql语句放在xml配置文件中，修改sql语句也不需要重新编译java代码 

3，向预编译语句PreparedStatement中设置参数，对占位符位置和设置参数值，硬编码，修改sql语句也不需要重新编译java代码 

解决：把sql语句和占位符设置参数值放在xml配置文件中 

4，从result中遍历结果集数据时，存在硬编码，将获取表的字段进行硬编码 
解决：将查询的结果集，自动映射成 java对象
//////
2.框架
3.连接源码

C3P0是一个开放源代码的JDBC连接池，它在lib目录中与Hibernate一起发布,包括了实现jdbc3和jdbc2扩展规范说明的Connection 和Statement 池的DataSources 对象。


　　BoneCP 是一个开源的快速的 JDBC 连接池。BoneCP很小，只有四十几K(运行时需要log4j和Google Collections的支持，这二者加起来就不小了)，而相比之下 C3P0 要六百多K。另外个人觉得 BoneCP 有个缺点是，JDBC驱动的加载是在连接池之外的，这样在一些应用服务器的配置上就不够灵活。当然，体积小并不是 BoneCP 优秀的原因，BoneCP 到底有什么突出的地方呢，请看看性能测试报告。


　　DBCP (Database Connection Pool)是一个依赖Jakarta commons-pool对象池机制的数据库连接池，Tomcat的数据源使用的就是DBCP。目前 DBCP 有两个版本分别是 1.3 和 1.4。1.3 版本对应的是 JDK 1.4-1.5 和 JDBC 3，而1.4 版本对应 JDK 1.6 和 JDBC 4。因此在选择版本的时候要看看你用的是什么 JDK 版本了，功能上倒是没有什么区别。


　　Proxool是一个Java SQL Driver驱动程序，提供了对你选择的其它类型的驱动程序的连接池封装。可以非常简单的移植到现存的代码中。完全可配置。快速，成熟，健壮。可以透明地为你现存的JDBC驱动程序增加连接池功能。