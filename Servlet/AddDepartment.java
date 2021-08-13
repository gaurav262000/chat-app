package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddDepartment
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		   String connectionURL = "jdbc:mysql://localhost:3306/userdb";
			String user = "root";
			String pass = "root";
	 
			int result = 0;
			Connection con = null;
			Part part =request.getPart("image");
			HttpSession session=request.getSession();
			//String doc_name=session.getAttribute("Name").toString();
			String doc_name="dd";
			String add_department_name=request.getParameter("add_department_name");
			String department_work=request.getParameter("department_work");
			String charges=request.getParameter("fees");
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String add_date=sdf.format(date);
 			if(part != null){
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
				    con = DriverManager.getConnection(connectionURL, user, pass);
				    
				    PreparedStatement ps = con.prepareStatement("insert into Department_Types(img,add_department_name,department_work,add_date,charges) values(?,'"+add_department_name+"','"+department_work+"','"+add_date+"','"+charges+"')");
				   
				    InputStream is = part.getInputStream();
				    
				    
				    ps.setBlob(1, is);
			
                   System.out.println(add_department_name +add_date +department_work+is);
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
		    	response.sendRedirect("Department.jsp");
		    }
			else{
				response.sendRedirect("result.jsp?message=Some+Error+Occurred");
			System.out.println("2nd test");
	                }

	}

}
