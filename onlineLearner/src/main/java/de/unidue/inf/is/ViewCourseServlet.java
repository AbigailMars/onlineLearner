package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.KursDao;
import de.unidue.inf.is.Dao.ViewCourseDao;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.ViewCourse;

public final class ViewCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	  String strKid = request.getParameter("kid");
 	  String strFlag = request.getParameter("flag");
 	  int kid = 0 ;
 	  int flag = 0;
 	  if(strKid != null) {
 		  kid = Integer.parseInt(strKid);
 		  flag = Integer.parseInt(strFlag);
 	  }
 	  Kurs kurs = null;
      try {
		kurs = KursDao.getKursById(kid);
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  request.setAttribute("kurs", kurs);
 	  
 	  if(flag == 1) {
 	  request.getRequestDispatcher("/view_course.ftl").forward(request, response);
 	  }else if(flag == 2) {
 		  List<ViewCourse> aufgabeList = null;
 		
			try {
				aufgabeList = ViewCourseDao.findAufgabe(kid);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
 		 request.setAttribute("aufgabeList", aufgabeList);
 		 request.getRequestDispatcher("/view_course2.ftl").forward(request, response);
 	  }
 }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet( request,response );
    	    }

}