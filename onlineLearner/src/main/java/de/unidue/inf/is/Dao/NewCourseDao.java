package de.unidue.inf.is.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import de.unidue.inf.is.utils.DBUtil;

public class NewCourseDao {

	public static boolean insertCourse(String name, String enschreibeschluessel, Integer plaeze,
			String beschreibungstext) throws Exception  {
		Connection connection = DBUtil.getExternalConnection();
	    
	    
			String sql = "insert into dbp057.kurs (name, beschreibungstext, einschreibeschluessel, freiePlaetze, ersteller) values(?,?,?,?,1)";
			try(PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setString(2, beschreibungstext);
			ps.setString(3, enschreibeschluessel);
			ps.setInt(4, plaeze);
		    ps.executeUpdate();
		    connection.commit();
			return true;
			}catch (SQLException e) {
		          
		           try{
		           	connection.rollback();
		           }catch(SQLException e2){
		           	System.out.println("ErRoR");
		           	return false;
		           } throw new Exception(e);
		       }
			
		
	}



}
