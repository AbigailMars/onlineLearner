package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.AbgabeDao;
import de.unidue.inf.is.Dao.EinreichenDao;

public class insertAssignmentServlet extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 	  
	    Integer anummer = Integer.parseInt(request.getParameter("anummer"));
	    Integer kid = Integer.parseInt(request.getParameter("kid"));
	    String abgabetext = request.getParameter("abgabetext");
	    
	    //get aid from AbgabeDao.add(abgabetext)
	    int aid = 0;
	    int row = 0;
	    try {
	    	//insert to abgabe table
			aid = AbgabeDao.add(abgabetext);
			//insert to einreichen table
			row = EinreichenDao.einreichen(anummer, kid, aid);
			if(row > 0) {
				response.sendRedirect("viewCourse?kid="+kid+"&flag="+2);
			}else {
				request.setAttribute("message", "Oooooooooops......error ....");
	            request.getRequestDispatcher("/error.ftl").forward(request, response);
			}
		} catch (ServletException e) {
	    	 request.setAttribute("message", "Oooooooooops......error1 ....");
             request.getRequestDispatcher("/error.ftl").forward(request, response); 
		} catch (IOException e) {
	    	 request.setAttribute("message", "Oooooooooops......error2 ....");
             request.getRequestDispatcher("/error.ftl").forward(request, response); 
		} catch (SQLException e) {
	    	 request.setAttribute("message", "Oooooooooops......error3 ....");
             request.getRequestDispatcher("/error.ftl").forward(request, response); 
		}
	    
	       
	 }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doPost( request,response );
	 }
}
