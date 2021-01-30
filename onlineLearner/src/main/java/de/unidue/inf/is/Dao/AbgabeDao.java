package de.unidue.inf.is.Dao;

import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import de.unidue.inf.is.utils.DBUtil;

public class AbgabeDao {
	
    public static int add(String abgabetext) throws ServletException, IOException, SQLException{
    	Connection connection = DBUtil.getExternalConnection();
    	String sql = "insert into dbp057.abgabe(abgabetext) values(?)";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	Clob clob = new javax.sql.rowset.serial.SerialClob(abgabetext.toCharArray());
    	ps.setClob(1, clob);
        ps.executeUpdate();  
    	ResultSet rs = ps.getGeneratedKeys();
    	int id = 0;
    	while(rs.next()) {
    	  id = rs.getInt(1);
    	}
    	return id;
    }
    
}
