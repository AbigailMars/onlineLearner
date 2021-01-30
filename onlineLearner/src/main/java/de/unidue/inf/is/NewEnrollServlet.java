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


public final class newEnrollServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int kid = Integer.parseInt(request.getParameter("kid"));
    	String name = request.getParameter("name");
    	Boolean enrolled  = false;
    	Boolean plaetze = false;
    	String einschreibeschluessel = null;
    	Kurs kurs = new Kurs();
   	    try {
		    enrolled  = EinschreibenDao.checkEnroll(kid);
		    plaetze = EinschreibenDao.checkPlaetze(kid);
		    einschreibeschluessel = EinschreibenDao.getSchluessel(kid);
		    kurs.setName(name);
		    kurs.setKid(kid);
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
   	  
   	    if(enrolled == false && plaetze == true && einschreibeschluessel != null) {
   	    	request.setAttribute("kurs", kurs);
   	    	request.getRequestDispatcher("/new_enroll.ftl").forward(request, response);
   	    } else if (enrolled == false && plaetze == true && einschreibeschluessel == null) {
   	    	Kurs kurs1 = null;
   	    	List<ViewCourse> aufgabeList = null;
   	    	try {
			    kurs1 = KursDao.getKursById(kid);
			    aufgabeList = ViewCourseDao.findAufgabe(kid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   	    	request.setAttribute("kurs", kurs1);
   	    	request.setAttribute("aufgabeList", aufgabeList);
   	    	request.getRequestDispatcher("/insert_enroll.ftl").forward(request, response);
   	    }
 }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost( request,response );
    	    }

}