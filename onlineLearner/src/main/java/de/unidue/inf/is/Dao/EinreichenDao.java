package de.unidue.inf.is.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import de.unidue.inf.is.utils.DBUtil;

public class EinreichenDao {
  public static Boolean submitted(int anummer) throws ServletException, IOException, SQLException  {
	  Connection connection = DBUtil.getExternalConnection();
	  String sql = "select aid from dbp057.einreichen where anummer =? and bnummer =1";
	  PreparedStatement ps = connection.prepareStatement(sql);
	  ps.setInt(1, anummer);
	  ResultSet rs = ps.executeQuery();
	  Integer aid = null;
	  while(rs.next()) {
		  aid = rs.getInt(1);
	  }
	  
	  if(aid != null) {
		  return true;
	  }else {
		  return false;
	  }	  
  }
  
  //public static void add(int anummer,int aid,int kid) {
	
//	return null;
	  
 // }
}
