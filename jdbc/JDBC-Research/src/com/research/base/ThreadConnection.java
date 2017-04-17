package com.research.base;

import java.sql.Connection;

public class ThreadConnection implements Runnable{  
    private IConnectionPool pool;  
    @Override  
    public void run() {  
        pool = ConnectionPoolManager.getInstance().getPool("testPool");  
    }  
      
    public Connection getConnection(){  
        Connection conn = null;  
        if(pool != null && pool.isActive()){  
            conn = pool.getConnection();  
        }  
        return conn;  
    }  
      
    public Connection getCurrentConnection(){  
        Connection conn = null;  
        if(pool != null && pool.isActive()){  
            conn = pool.getCurrentConnecton();  
        }  
        return conn;  
    }  
}  