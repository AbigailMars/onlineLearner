package de.unidue.inf.is.Dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;

public class UserDao {

	public static List<User> getAllUser() throws SQLException,IOException{
	/*	List<User> userList = new ArrayList<>();
		
		//get the connection
		Connection connection = DBUtil.getExternalConnection();
		
		//create statement
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from benutzer");
		
		// User(Integer nummer,String email, String name)
		while(rs.next()){
			Integer nummer=rs.getInt(1);
			String email=rs.getString(2);
			String name =rs.getString(3);
			
			User user = new User(nummer,email,name);
			userList.add(user);
		}
		
		return userList;
		*/
		
		//get the connection
		Connection connection = DBUtil.getExternalConnection();
		
		//create statement
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from dbp057.BENUTZER");
		List<User> userList = new ArrayList<>();
		while(rs.next()) {
			User user = new User();
			user.setNummer(rs.getInt(1));
			user.setEmail(rs.getString(2));
			user.setName(rs.getString(3));
			userList.add(user);			
		}
		return userList;
	}
	
	
}

