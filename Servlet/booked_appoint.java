package Servlet;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBUtils;

@WebServlet("/booked_appoint")
public class booked_appoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Apdate = request.getParameter("Apdate");
		String Aptime = request.getParameter("Aptime");
		String weekday=request.getParameter("weekday");
		String doc_name2=request.getParameter("doc_name2");
		String doc_email2=request.getParameter("doc_email2");
		String patient_name=request.getParameter("patient_name");
		String patient_email=request.getParameter("patient_email");
		String dsc_appointment=request.getParameter("dsc_appointment");
		String booking_date=request.getParameter("booking_date");
		String totalcharges=request.getParameter("totalcharges");
		String status="notDone";
		try {
			int rs=0;
			System.out.print("appoint details out");
			PreparedStatement ps=DBUtils.getPreparedStatement("insert into booked_appointment(appoint_date,appoint_time,weekday_name,doc_name,doc_email,patient_name,patient_email,appoint_desc,booking_date,total_charge,status) values('"+Apdate+"','"+Aptime+"','"+weekday+"','"+doc_name2+"','"+doc_email2+"','"+patient_name+"','"+patient_email+"','"+dsc_appointment+"','"+booking_date+"','"+totalcharges+"','"+status+"')");
			rs= ps.executeUpdate(); 
			 System.out.print("appoint details in");
			if(rs>0) {
				response.sendRedirect("PatientProfile.jsp");
			}
			else {
				response.sendRedirect("frontAppointment.jsp");
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
