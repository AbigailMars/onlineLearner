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
    Connection connection = null;
    PreparedStatement ps = null;
    String schluessel = null;
    ResultSet rs = null;
	try {
		connection = DBUtil.getExternalConnection();
		String sql = "select einschreibeschluessel from dbp057.kurs where kid = ?";
	    ps = connection.prepareStatement(sql);
	    ps.setInt(1, kid);
	    rs = ps.executeQuery();
	    while (rs.next()){
		schluessel = rs.getString(1);
	     }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sql2 = null;
	PreparedStatement ps2 = null;
		if(einschreibeschluessel.equals(schluessel)  ){
			sql2 = "insert into dbp057.einschreiben(bnummer,kid) values (1,?)";
			Kurs kurs = new Kurs();
			List<ViewCourse> aufgabeList = null;
			try {
				ps2 = connection.prepareStatement(sql2);
				ps2.setInt(1, kid);
				ps2.executeUpdate();
			    kurs = KursDao.getKursById(kid);
			    aufgabeList = ViewCourseDao.findAufgabe(kid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.setAttribute("aufgabeList", aufgabeList);
	    request.setAttribute("kurs", kurs);
		request.getRequestDispatcher("/insert_enroll.ftl").forward(request, response);
	}else {
		request.getRequestDispatcher("/view_main.ftl").forward(request, response);
	}
}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost( request,response );
    	    }

}
    
    