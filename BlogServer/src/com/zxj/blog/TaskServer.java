package com.zxj.blog;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.datapool.Task;
import com.zxj.datapool.User;

/**
 * Servlet implementation class TaskServer
 */
@WebServlet("/TaskServer")
public class TaskServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");  
        if(!task.isEmpty()){  
        	Task t = new Task();
        	try {
				response.getWriter().print(t.getTask(task));
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	//request.setAttribute("dsd","fcxdcxcv");
        	//RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/logSuccess.jsp");
        	//dispatcher .forward(request, response);
        	//response.sendRedirect("jsp/logSuccess.jsp");  
        }else{  
        	response.sendRedirect("jsp/logSuccess.jsp"); 
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
