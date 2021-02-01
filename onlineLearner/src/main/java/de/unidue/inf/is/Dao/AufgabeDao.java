package de.unidue.inf.is.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.unidue.inf.is.domain.Aufgabe;
import de.unidue.inf.is.utils.DBUtil;

public class AufgabeDao {
    public static Aufgabe getAufgabeByid(int anummer) throws SQLException, IOException {
    	Connection connection = DBUtil.getExternalConnection();
    	String sql = "select name,beschreibung,kid from dbp056.aufgabe where anummer = ?";
    	PreparedStatement ps = connection.prepareStatement(sql);
    	ps.setInt(1,anummer);
    	ResultSet rs = ps.executeQuery();
    	Aufgabe aufgabe = new Aufgabe();
    	while(rs.next()) {
    		aufgabe.setName(rs.getString(1));
    		//transfer clob to string
    		Clob clob = rs.getClob(2);
    		String beschreibung = "";
            Reader is = clob.getCharacterStream();
            BufferedReader br = new BufferedReader(is);
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();
            while(s!=null) {
            	sb.append(s);
            	s= br.readLine();
            }
            beschreibung = sb.toString();
    		aufgabe.setBeschreibung(beschreibung);
    		
    		aufgabe.setAnummer(anummer);
    		aufgabe.setKid(rs.getInt(3));
    	}
		return aufgabe;    	
    }
}
