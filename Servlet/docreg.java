package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import model.DoctorMember;
import model.regUser;

/**
 * Servlet implementation class docreg
 */
@WebServlet("/docreg")
public class docreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Name=request.getParameter("Name");
	       String password=request.getParameter("password");
	       String Email=request.getParameter("Email");
	       int DOBDay=Integer.parseInt(request.getParameter("DOBDay"));
	       String DOBMonth=request.getParameter("DOBMonth");
	       int DOBYear=Integer.parseInt(request.getParameter("DOBYear"));
	       String Gender=request.getParameter("Gender");
	       String state=request.getParameter("state");
	       String specialist=request.getParameter("specialist");
	       String contact=request.getParameter("contact");
	       
	       System.out.println(Name + "I Am In Servlet");
	       
	       DoctorMember r=new DoctorMember(0, Name, password, Email, DOBDay, DOBMonth, DOBYear, Gender, state, contact, specialist);	       
	       DataAccess da=new DataAccess();
	       da.DocReg(r);
	       
	       System.out.println(r+"TEST2");
	       response.sendRedirect("dashboard.jsp");
		
	}

}
