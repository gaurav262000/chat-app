package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.DataAccess;
import db.DBUtils;
import model.DoctorMember;

/**
 * Servlet implementation class update_schedule
 */
@WebServlet("/update_schedule")
public class update_schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAccess da=new DataAccess();
		//System.out.println(session.getAttribute("Id").toString()+" demo");
		HttpSession session=request.getSession();
		DoctorMember doc=da.getDocDetails(session.getAttribute("Id").toString());
		 String sch_date=request.getParameter("sch_date");
	 	   String start_hrs=request.getParameter("start_hrs");	
	 	   String start_min=request.getParameter("start_min");	
	 	   String end_hrs=request.getParameter("end_hrs");	
	 	   String end_min=request.getParameter("end_min");
		 try {
			PreparedStatement ps=DBUtils.getPreparedStatement("insert into update_schedule(doc_name,doc_id,sch_date,start_hrs,start_min,end_hrs,end_min) values('"+doc.getName()+"','"+doc.getId()+"','"+sch_date+"','"+start_hrs+"','"+start_min+"','"+end_hrs+"','"+end_min+"')");
			int rs=ps.executeUpdate();
			
			if(rs > 0){
 		    	response.sendRedirect("Doc_Add_Schedule.jsp");
 		    }
 			else{
 				response.sendRedirect("result.jsp?message=Some+Error+Occurred");
 			System.out.println("2nd test");
 	                }
			
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
