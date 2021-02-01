package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.utils.DBUtil;


public final class InsertKursServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
 
 try {
    try {
    String name = request.getParameter("name");
    String enschreibeschluessel = request.getParameter("einschreibeschluessel");
    Integer plaeze = Integer.parseInt(request.getParameter("plaeze"));
    String beschreibungstext = request.getParameter("beschreibungstext");
    Connection connection = null;
	connection = DBUtil.getExternalConnection();
	PreparedStatement ps = null;
    String sql = "insert into dbp056.kurs (name, beschreibungstext, einschreibeschluessel, freiePlaetze, ersteller) values(?,?,?,?,1)";
	  ps = connection.prepareStatement(sql);
	  ps.setString(1, name);
	  ps.setString(2, beschreibungstext);
	  ps.setString(3, enschreibeschluessel);
	  ps.setInt(4, plaeze);
	  int row =ps.executeUpdate();
	  if(row >0) {		 
			 response.sendRedirect("onlineLearner");
	  } 
     }catch (IOException e) {
    	 request.setAttribute("message", "Oooooooooops......error .... ");
    	 request.getRequestDispatcher("/error.ftl").forward(request, response);
	  }
      }catch(SQLException e) {
    	  request.setAttribute("message", "Oooooooooops.....check input");
    	  request.getRequestDispatcher("/error.ftl").forward(request, response);
      }
}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost( request,response );
    	    }

}
    