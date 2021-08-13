package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Adminimg
 */
@WebServlet("/Adminimg")
@MultipartConfig(maxFileSize = 16177215)
public class Adminimg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
        String connectionURL = "jdbc:mysql://localhost:3306/userdb";
		String user = "root";
		String pass = "root";
 
		int result = 0;
		Connection con = null;
		Part part =request.getPart("image");
		HttpSession session=request.getSession();
		String Id=session.getAttribute("Id").toString();
		if(part != null){
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection(connectionURL, user, pass);
			    
			    PreparedStatement ps = con.prepareStatement("Update AdminUser set image=? where Id='"+Id+"'");
			   
			    InputStream is = part.getInputStream();
			    ps.setBlob(1, is);
                            System.out.println("1st test");
			    result = ps.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			finally{
				if(con != null){
					try{
						con.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		
		if(result > 0){
	    	response.sendRedirect("AdminEditProfile.jsp");
	    }
		else{
			response.sendRedirect("result.jsp?message=Some+Error+Occurred");
		System.out.println("2nd test");
                }
	}

}
