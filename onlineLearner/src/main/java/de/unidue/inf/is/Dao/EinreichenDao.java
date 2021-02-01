package de.unidue.inf.is.Dao;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import de.unidue.inf.is.utils.DBUtil;

public class EinreichenDao {
  public static Boolean submitted(int kid,int anummer) throws ServletException, IOException, SQLException  {
	  Connection connection = DBUtil.getExternalConnection();
	  String sql = "select aid from dbp056.einreichen where kid =? and anummer =? and bnummer =1";
	  PreparedStatement ps = connection.prepareStatement(sql);
	  ps.setInt(1, kid);
	  ps.setInt(2, anummer);
	  ResultSet rs = ps.executeQuery();
	  Integer aid = null;
	  while(rs.next()) {
		  aid = rs.getInt(1);//if submitted,aid is not null
	  }
	  
	  if(aid != null) {
		  return true;    // submitted
	  }else {
		  return false;   // no submit 
	  }	  
  }
  
  public static int einreichen(int anummer,int kid,int aid) throws SQLException {
	  Connection connection = DBUtil.getExternalConnection();
  	  String sql = "insert into dbp056.einreichen(bnummer,kid,anummer,aid) values(1,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(sql);
  	  ps.setInt(1,kid);
  	  ps.setInt(2, anummer);
	  ps.setInt(3, aid);
      int row = ps.executeUpdate();  
      return row;
  }
   
}
