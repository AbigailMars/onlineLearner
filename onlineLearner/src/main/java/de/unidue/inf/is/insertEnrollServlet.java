package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.EinschreibenDao;
import de.unidue.inf.is.Dao.KursDao;
import de.unidue.inf.is.Dao.ViewCourseDao;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.ViewCourse;
import de.unidue.inf.is.utils.DBUtil;


public final class insertEnrollServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    String einschreibeschluessel = request.getParameter("einschreibeschluessel");
    int kid = Integer.parseInt(request.getParameter("kid"));
    //get the right schluesel by method call
    String schluessel = null;
	try {
		schluessel = EinschreibenDao.getSchluessel(kid);
	} catch (ServletException e1) {
		request.setAttribute("message", "Oooooooooops......error ....");
        request.getRequestDispatcher("/error.ftl").forward(request, response);
	} catch (IOException e1) {
		request.setAttribute("message", "Oooooooooops......error ....");
        request.getRequestDispatcher("/error.ftl").forward(request, response);
	} catch (SQLException e1) {
		request.setAttribute("message", "Oooooooooops......error ....");
        request.getRequestDispatcher("/error.ftl").forward(request, response);
	}
	int ifInserted = 0;	
	if(einschreibeschluessel.equals(schluessel)  ){
	   try {
		  //enroll the user to this course
		 ifInserted = EinschreibenDao.add(kid);
		 //update the place
		 KursDao.Update(kid);
	         } catch (SQLException e) {
	             request.setAttribute("message", "Oooooooooops......error ....");
	             request.getRequestDispatcher("/error.ftl").forward(request, response);
	        }
	   
	     if(ifInserted > 0) {
	    	 response.sendRedirect("viewCourse?kid="+kid+"&flag="+2);
	     }else {
	    	 request.setAttribute("message", "Oooooooooops......error ....");
             request.getRequestDispatcher("/error.ftl").forward(request, response); 
	     }
	     
	}else {
		request.setAttribute("message", "Einschreibeschluessel ist falsh");
		request.getRequestDispatcher("/error.ftl").forward(request, response);
	}
}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost( request,response );
    	    }

}
    
    