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
	    int anummer =  Integer.parseInt(request.getParameter("anummer"));
	    int kid = Integer.parseInt(request.getParameter("kid"));
	    
	    //check if the task was submitted before
	    Boolean submitted = true;
		try {
			submitted = EinreichenDao.submitted(kid,anummer);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    Kurs kurs = new Kurs();
	    Aufgabe aufgabe = new Aufgabe();
	    if(submitted == false) {			
	    		try {
	    			// get aufgabe info
					aufgabe = AufgabeDao.getAufgabeByid(anummer);
					//get kurs info
					kurs = KursDao.getKursById(kid);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}							
	    request.setAttribute("kurs", kurs);
	    request.setAttribute("aufgabe", aufgabe);
		request.getRequestDispatcher("/new_assignment.ftl").forward(request, response);
		
	    }else {
	    	//if it was submitted before, go to error page
	    	request.setAttribute("message", "Mehrfache Abgaben eines Benutzers für eine Kurs-Aufgabe sind nicht möglich.");
   	    	request.getRequestDispatcher("/error.ftl").forward(request, response);
	    }
	 }
	    
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost( request,response );
	  }
	 
}
