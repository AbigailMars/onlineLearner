package de.unidue.inf.is.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import de.unidue.inf.is.utils.DBUtil;

public class EinschreibenDao {
	
   public static Boolean checkEnroll(int kid) throws ServletException, IOException, SQLException {
	Connection connection = DBUtil.getExternalConnection();
	String sql = "select kid from dbp056.einschreiben where bnummer = 1 and kid = ?";
	PreparedStatement ps = connection.prepareStatement(sql);
	ps.setInt(1, kid);
	ResultSet rs = ps.executeQuery();
	int id = 0;
	while(rs.next()) {
		id = rs.getInt(1);
	}
	if(id == 0) {
		return false;
	}else {
		return true;
	}	   
   }
   
   public static Boolean checkPlaetze(int kid) throws ServletException, IOException, SQLException{
	    Connection connection = DBUtil.getExternalConnection();
		String sql = "select freieplaetze from dbp056.kurs where kid = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, kid);
		ResultSet rs = ps.executeQuery();
		int plaetze = 0;
	    while(rs.next()) {
	    	plaetze = rs.getInt(1);
	    }
	    if(plaetze <= 0) {
	    	return false;
	    }else {
	    	return true;
	    }	   
   }
   
   public static Boolean checkSchluessel(int kid) throws SQLException {
	    Connection connection = DBUtil.getExternalConnection();
		String sql = "select einschreibeschluessel from dbp056.kurs where kid = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, kid);
		ResultSet rs = ps.executeQuery();
		String einschreibeschluessel = null;
	    while(rs.next()) {
	    	einschreibeschluessel = rs.getString(1);
	    }
	    if (einschreibeschluessel == null) {
	    	return false;
	    }else {
		return true;
		}
   }
   
   public static String getSchluessel(int kid) throws ServletException, IOException, SQLException{
	    Connection connection = DBUtil.getExternalConnection();
		String sql = "select einschreibeschluessel from dbp056.kurs where kid = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, kid);
		ResultSet rs = ps.executeQuery();
		String einschreibeschluessel = null;
	    while(rs.next()) {
	    	einschreibeschluessel = rs.getString(1);
	    }
	    return einschreibeschluessel;
   }
   
   public static int add(int kid) throws SQLException {
	   Connection connection = DBUtil.getExternalConnection();
	   String sql = "insert into dbp056.einschreiben(bnummer,kid) values (1,?)";
	   PreparedStatement ps = connection.prepareStatement(sql);
	   ps.setInt(1, kid);
	   int i = ps.executeUpdate();
	   return i;
   }

}

