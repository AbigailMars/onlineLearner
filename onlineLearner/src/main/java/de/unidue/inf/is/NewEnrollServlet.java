package de.unidue.inf.is;

import java.io.IOException;
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


public final class NewEnrollServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int kid = Integer.parseInt(request.getParameter("kid"));
    	Boolean enrolled  = false;
    	Boolean plaetze = false;
    	Boolean einschreibeschluessel = false;
    	Kurs kurs = new Kurs();
   	    try {
   	    	//check whether it was enrolled : no -> false ; yes -> true
		    enrolled  = EinschreibenDao.checkEnroll(kid);
		    //check whether there is enough place : no -> false ; yes->true
		    plaetze = EinschreibenDao.checkPlaetze(kid);
		    //get schluessel by method call
		    einschreibeschluessel = EinschreibenDao.checkSchluessel(kid);
		    //get course name by method call
		    kurs = KursDao.getKursById(kid);
		} catch (ServletException e) {
			request.setAttribute("message", "Oooooooooops......error ....");
            request.getRequestDispatcher("/error.ftl").forward(request, response); 
		} catch (IOException e) {
			request.setAttribute("message", "Oooooooooops......error ....");
            request.getRequestDispatcher("/error.ftl").forward(request, response); 
		} catch (SQLException e) {
			request.setAttribute("message", "Oooooooooops......error ....");
            request.getRequestDispatcher("/error.ftl").forward(request, response); 
		}
   	  
   	    if(enrolled == false && plaetze == true && einschreibeschluessel == true) {
   	    	request.setAttribute("kurs", kurs);
   	    	request.getRequestDispatcher("/new_enroll.ftl").forward(request, response);
   	    } else if (enrolled == false && plaetze == true && einschreibeschluessel == false) {
   	    	int ifInserted = 0;
   	    	try {
   	    		ifInserted = EinschreibenDao.add(kid);
			} catch (SQLException e) {
				request.setAttribute("message", "Oooooooooops......error ....");
	            request.getRequestDispatcher("/error.ftl").forward(request, response);
			}
   	        response.sendRedirect("viewCourse?kid="+kid+"&flag="+2);
   	    }else if(enrolled == true){
   	    	request.setAttribute("message", "Mehrfache Einschreibungen eines Kurses sind nicht möglich");
   	    	request.getRequestDispatcher("/error.ftl").forward(request, response);
   	    }else if(plaetze == false) {
   	    	request.setAttribute("message", "Voll registriert");
   	    	request.getRequestDispatcher("/error.ftl").forward(request, response);
   	    }
 }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost( request,response );
    	    }
}