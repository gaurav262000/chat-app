package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccess;

/**
 * Servlet implementation class doc
 */
@WebServlet("/doc")
public class doc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("i am in DocServlet");
		HttpSession session= request.getSession();
		//session.setAttribute("Id", request.getParameter("Email"));
		  
	      DataAccess da=new DataAccess();
	      
	    // session.setAttribute("Id",da.getuserid(request.getParameter("Email")));  da.LoginUser(request.getParameter("Email"),request.getParameter("password"));
	    
			
		da.DocUser(request.getParameter("Email"),request.getParameter("password"));
				   
				 session.setAttribute("Id",da.getdocId(request.getParameter("Email")));
		    	 response.sendRedirect("DocDashboard.jsp");
		    	 System.out.println("you are login successfully Doctor");
		     
	
		    	 
	}
	
}
