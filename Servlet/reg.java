package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataAccess;
import model.regUser;


@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String Name=request.getParameter("Name");
	       String password=request.getParameter("password");
	       String Email=request.getParameter("Email");
	       int DOBDay=Integer.parseInt(request.getParameter("DOBDay"));
	       String DOBMonth=request.getParameter("DOBMonth");
	       int DOBYear=Integer.parseInt(request.getParameter("DOBYear"));
	       String Gender=request.getParameter("Gender");
	       String state=request.getParameter("state");
	       String contact=request.getParameter("contact");
	       
	       System.out.println(Name + "I Am In Servlet");
	       
	       regUser r=new regUser(0, Name, password, Email, DOBDay, DOBMonth, DOBYear, Gender, state, contact);
	       
	       DataAccess da=new DataAccess();
	       da.RegUser(r);
	       
	       System.out.println(r+"TEST2");
	       response.sendRedirect("login.jsp");
	}

}
