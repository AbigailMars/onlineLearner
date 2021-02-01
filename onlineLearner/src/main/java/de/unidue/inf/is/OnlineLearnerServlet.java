package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.KursDao;
import de.unidue.inf.is.domain.Kurs;

public final class OnlineLearnerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   List<Kurs> kursList = null;
    	   List<Kurs> vkursList = null;
    	   			try {
    	   //find course that has registered
				kursList = KursDao.findKurs();
		   //find course that has not registered	
				vkursList = KursDao.findVerfuegbareKurs();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		//stores attributes in this request
			request.setAttribute("kursList", kursList);
			request.setAttribute("vkursList", vkursList);
            request.getRequestDispatcher("/view_main.ftl").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);    
    }

}