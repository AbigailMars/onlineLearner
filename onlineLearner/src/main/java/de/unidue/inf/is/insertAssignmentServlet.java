package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.AbgabeDao;

public class insertAssignmentServlet extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 	  
	    Integer anummer = Integer.parseInt(request.getParameter("anummer"));
	    String abgabetext = request.getParameter("abgabetext");
	    int aid = 0;
	    try {
			aid = AbgabeDao.add(abgabetext);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    request.getRequestDispatcher("/view_course2.ftl").forward(request, response);
	 }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doPost( request,response );
	 }
}
