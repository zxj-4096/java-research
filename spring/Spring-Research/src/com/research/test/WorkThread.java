package com.research.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class WorkThread extends Thread{
	private boolean status;
	private Map<String, String> taskmap;
	private Iterator<String> it;
	public WorkThread(){
		status = true;
		taskmap = new HashMap<String, String>();
	}
	public void run(){
		while(status) {   
			String s = HttpRequest.sendGet("http://localhost:8090/BlogServer/TaskServer", "task=k");
			JSONObject jsonObj;
			try {
				jsonObj = new JSONObject(s);
				jsonObj = jsonObj.getJSONObject("tasks");
				it = jsonObj.keys();  
	            while (it.hasNext()) {  
	                String key = (String) it.next();  
	                String value = jsonObj.getString(key);
	                if(!taskmap.containsKey(key)){
	                	taskmap.put(key, value);
	                }
	            }
	            //1.分配任务 创建子线程
	            
	            //2.修改任务状态
	            
	            for(String str:taskmap.keySet()){
	            	int i = Integer.valueOf(taskmap.get(str));
	            	taskmap.put(str, ""+(i+1));
	            	System.out.println("k:"+str+"v:"+taskmap.get(str));
	            	
	            }
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}    
    }    
    public void cancel() {    
    	status = false;
    }   

}
