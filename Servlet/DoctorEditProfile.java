package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataAccess;
import db.DBUtils;

/**
 * Servlet implementation class DoctorEditProfile
 */
@WebServlet("/DoctorEditProfile")
public class DoctorEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession();
		int Uid=Integer.parseInt(session.getAttribute("Id").toString());
		
		String Name=request.getParameter("Name");
	    String password=request.getParameter("password");
	     String Email=request.getParameter("Email");
	     int DOBDay=Integer.parseInt(request.getParameter("DOBDay"));
	     String DOBMonth=request.getParameter("DOBMonth");
	     int DOBYear=Integer.parseInt(request.getParameter("DOBYear"));
	     String Gender=request.getParameter("Gender");
	     String state=request.getParameter("state");
	     String contact=request.getParameter("contact");
	     String bio=request.getParameter("bio");
	     System.out.println("UPDATES SUCCESSFULLY"+ session.getAttribute("Id"));
	       
	       System.out.println(Name + "I Am In PatientEditProfile Servlet");
	     
	       try {
	    	   int result=0;
			PreparedStatement ps=DBUtils.getPreparedStatement("Update docUsers set Name='"+Name+"',password='"+password+"', Email='"+Email+"', DOBDay='"+DOBDay+"', DOBMonth='"+DOBMonth+"', DOBYear='"+DOBYear+"', Gender='"+Gender+"', address='"+state+"', contact='"+contact+"' where Id='"+Uid+"'");
			result=ps.executeUpdate();
			if(result>0) {
				response.sendRedirect("DocEditProfile.jsp");
			}
			else {
				response.sendRedirect("DocEditProfile.jsp?error=Try Again!!Not Updated");
			}
	       } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       System.out.println("UPDATES SUCCESSFULLY");

	}

}
