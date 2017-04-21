package com.zxj.blog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.datapool.User;


/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");  
        String pwd = request.getParameter("password");  

        if(!username.isEmpty()){  
        	User u = new User();
        	try {
				response.getWriter().print(u.getUser(username));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//response.sendRedirect("jsp/logSuccess.jsp");  
        	//response.getRequestDispatcher("jsp/logSuccess.jsp").forward(request, resp); 
        }else{  
        	//response.sendRedirect(""); 
        }
        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");  
        String pwd = request.getParameter("password");  

        if(!username.isEmpty()){  
        	User u = new User();
        	try {
				response.getWriter().print(u.getUser(username));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	request.setAttribute("dsd","fcxdcxcv");
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/logSuccess.jsp");

        	dispatcher .forward(request, response);
        	
        	//response.sendRedirect("jsp/logSuccess.jsp");  
        }else{  
        	//response.sendRedirect(""); 
        }
	}

}
