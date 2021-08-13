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

import db.DBUtils;
import model.EmailUtility;
import model.forgetpassword;

/**
 * Servlet implementation class emergency_email
 */
@WebServlet("/emergency_email")
public class emergency_email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String recipient=request.getParameter("Email");
		String Name=request.getParameter("name");
		String email="";
		String subject = "ForgetPassword";
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

//create StringBuffer size of AlphaNumericString
StringBuilder sb = new StringBuilder(10);
		 try {
			PreparedStatement ps=DBUtils.getPreparedStatement("select * from regUsers where Email='"+recipient+"'");
			ResultSet rs=ps.executeQuery();
			
		while(rs.next()) {
			
			email=rs.getString(4);
		}
		 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
		if(!email.equals(recipient)) {
		 

for (int i = 0; i < 10; i++) {

// generate a random number between
// 0 to AlphaNumericString variable length
int index= (int)(AlphaNumericString.length()
     * Math.random());

// add Character one by one in end of sb
sb.append(AlphaNumericString
       .charAt(index));

		
}   
int rs=0;

try {
	
	PreparedStatement ps1=DBUtils.getPreparedStatement("insert into regUsers(Name,Email,password) values('"+Name+"','"+recipient+"','"+sb.toString()+"')");
	rs=ps1.executeUpdate();
	if(rs>0) {
		System.out.println("We add new member");// iski gati thi waah phele to ayi ni error ye abhi bhi ha fir same glti bracket ki ko nhi mundotiagaurav37@gmail.com isko login kr q program me  
	}
	else {
		System.out.println("We not added new member");
	}
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

String content = "your new password is : "+sb.toString()+" "+" and your email is :"+recipient  ;	
String datacontent=sb.toString();
System.out.println(sb.toString()+"hellooooo");

String resultMessage = "";

try {
	EmailUtility eu=new EmailUtility();
	forgetpassword fp=new forgetpassword(recipient,subject,content);
			eu.sendEmail(fp);
			
    resultMessage = "The e-mail was sent successfully";
} catch (Exception ex) {
    ex.printStackTrace();
    resultMessage = "There were an error: " + ex.getMessage();
} finally {
    request.setAttribute("Message", resultMessage);
    getServletContext().getRequestDispatcher("/login.jsp").forward(
            request, response);
}




		}
		
		else {
			response.sendRedirect("login.jsp");
			}
		
		
	
	}
}