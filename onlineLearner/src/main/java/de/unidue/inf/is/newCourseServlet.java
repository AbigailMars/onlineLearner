package de.unidue.inf.is;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.NewCourseDao;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/new_course")
public class newCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/new_course.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

		    String name = request.getParameter("name");
		    String enschreibeschluessel = request.getParameter("einschreibeschluessel");
		    Integer plaeze = Integer.parseInt(request.getParameter("plaeze"));
		    String beschreibungstext = request.getParameter("beschreibungstext");
		    
		    NewCourseDao.insertCourse(name,enschreibeschluessel,plaeze,beschreibungstext);
		    
			request.getRequestDispatcher("view_course.ftl").forward(request, response);
	    }catch (Exception e) {
	    	request.setAttribute("message", "Database error: please contact the administator");
			request.getRequestDispatcher("message.ftl").forward(request, response);
	    }
	}

}
