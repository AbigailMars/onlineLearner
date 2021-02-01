package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.KursDao;

public class DeleteCourseServlet extends HttpServlet{
	   private static final long serialVersionUID = 1L;
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 	  
	     doPost( request,response ); 
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int kid = Integer.parseInt(request.getParameter("kid"));
	        int result= 0;
	        try {
				result = KursDao.deleteKursbyID(kid);
			} catch (SQLException e) {
				request.setAttribute("message", "Oooooooooops......error ....");
		        request.getRequestDispatcher("/error.ftl").forward(request, response);
			}
	        if(result > 0) {
			  response.sendRedirect("onlineLearner");		
	        }else if (result == 0){
	          request.setAttribute("message", "Sie sind nicht der Ersteller");
	          request.getRequestDispatcher("/error.ftl").forward(request, response);
	        }
	    }

}
