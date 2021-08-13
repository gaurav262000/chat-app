package Servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBUtils;

/**
 * Servlet implementation class desc
 */
@WebServlet("/desc")
public class desc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result=0;
		String Patient_name=request.getParameter("Patient_name");
		String Patient_email=request.getParameter("Patient_email");
		String doctor_name=request.getParameter("doctor_name");
		String doctor_email=request.getParameter("doctor_email");
		String description=request.getParameter("d_desc");
		Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			
		 try {
			 PreparedStatement ps=DBUtils.getPreparedStatement("insert into Patient_Description(Patient_email,Patient_name,doctor_email,Doctor_name, Description,Desc_date) values('"+Patient_email+"','"+Patient_name+"','"+doctor_email+"','"+doctor_name+"','"+description+"','"+sdf.format(date)+"')");
			System.out.println(Patient_email+Patient_name+doctor_email+doctor_name+description+sdf.format(date));
			ps.executeUpdate();
			response.sendRedirect("DocDashboard.jsp");
			//if(result>0) {
				
			//}
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
