package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccess;

/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String Email=request.getParameter("Email");  
		//String password=request.getParameter("password");
		
		HttpSession session= request.getSession();
		//session.setAttribute("Id", request.getParameter("Email"));
		  try {
	      DataAccess da=new DataAccess();
	      
	    //  da.LoginUser(request.getParameter("Email"),request.getParameter("password"));
	    
			
			 if(da.LoginUser(request.getParameter("Email"),request.getParameter("password"))) {
				   
				 session.setAttribute("Id",da.getuserid(request.getParameter("Email")));
		    	 response.sendRedirect("PatientProfile.jsp");
		    	 System.out.println("you are login successfully");
		     }
				 
	
		     else {
		    	 response.sendRedirect("login.jsp");
		    	 System.out.println("not valid");
		     } 
		      
		      
		
	//      response.sendRedirect("dashboard.jsp");
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
	      //session create krna h 
	     
	      
	      
	}

}
