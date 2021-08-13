package Servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccess;


@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		//session.setAttribute("Id", request.getParameter("Email"));
		  
	      DataAccess da=new DataAccess();
	      
	    //  da.LoginUser(request.getParameter("Email"),request.getParameter("password"));
	    
			
		da.AdminUser(request.getParameter("Email"),request.getParameter("password"));
				   
				 session.setAttribute("Id",da.getAdminId(request.getParameter("Email")));
		    	 response.sendRedirect("dashboard.jsp");
		    	 System.out.println("you are login successfully admin");
		     
			
			 		 
	
		     
		      
		      
		
	//      response.sendRedirect("dashboard.jsp");
		  
	     
	      //session create krna h 
	     
	      
	      
	}
	}


