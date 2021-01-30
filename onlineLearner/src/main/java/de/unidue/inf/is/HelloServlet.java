package de.unidue.inf.is;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.Dao.UserDao;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;


public  class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   List<User> userList = null;
	
			try {
				userList = UserDao.getAllUser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    		//transfer userlist to index page 
			request.setAttribute("userList", userList);
			
//switch to index page
        request.getRequestDispatcher("/view_user.ftl").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    
    }
}
