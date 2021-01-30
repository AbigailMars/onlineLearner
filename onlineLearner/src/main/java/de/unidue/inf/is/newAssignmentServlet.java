package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.AufgabeDao;
import de.unidue.inf.is.Dao.EinreichenDao;
import de.unidue.inf.is.Dao.KursDao;
import de.unidue.inf.is.domain.Aufgabe;
import de.unidue.inf.is.domain.Kurs;

public final class  newAssignmentServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 	  
	    String strAnummer =  request.getParameter("anummer");
	    Integer anummer = 0;
	    if(strAnummer != null) {
		anummer = Integer.parseInt(request.getParameter("anummer"));
		}
	    Boolean submitted = true;
		try {
			submitted = EinreichenDao.submitted(anummer);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Kurs kurs = new Kurs();
	    Aufgabe aufgabe = new Aufgabe();
	    Integer kid = 0;
	    if(submitted == false) {
	    	try {				
	    		aufgabe = AufgabeDao.getAufgabeByid(anummer);
				kid = aufgabe.getKid();
				kurs = KursDao.getKursById(kid);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    request.setAttribute("kurs", kurs);
	    request.setAttribute("aufgabe", aufgabe);
		request.getRequestDispatcher("/new_assignment.ftl").forward(request, response);
	    }else {
	    request.getRequestDispatcher("/view_course2.ftl").forward(request, response);	
	    }
	 }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doPost( request,response );
	    	    }
}
