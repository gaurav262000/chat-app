package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** ruk ja 2 min
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	 HttpSession session=request.getSession();  
	            session.invalidate();
	        //    System.out.println("Successfully logout");
	            
	            response.sendRedirect("index.jsp");
	    }

	  

}
