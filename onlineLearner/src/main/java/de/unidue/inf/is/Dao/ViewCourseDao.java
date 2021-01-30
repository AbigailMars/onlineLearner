package de.unidue.inf.is.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.domain.ViewCourse;
import de.unidue.inf.is.utils.DBUtil;

public class ViewCourseDao {
	public static List<ViewCourse> findAufgabe(int kid) throws SQLException,IOException {
		Connection connection = DBUtil.getExternalConnection();
		String sql = "select t1.anummer,t1.aid,t2.name,t3.abgabetext,t4.note from dbp057.einreichen t1,dbp057.aufgabe t2,dbp057.abgabe t3,(select aid,avg(note) as note from dbp057.bewerten group by aid ) as t4 where t1.kid = ? and t1.bnummer = 1 and t1.anummer = t2.anummer and t1.aid = t3.aid and t1.aid = t4.aid\n" + 
				"";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, kid); 
		ResultSet rs = st.executeQuery();
		List<ViewCourse> aufgabeList = new ArrayList<>();
		
		while(rs.next()){
			ViewCourse aufgabe = new ViewCourse();
			aufgabe.setKid(kid);
            aufgabe.setAnummer(rs.getInt(1));
            aufgabe.setAid(rs.getInt(2));
            aufgabe.setName(rs.getString(3));
            
            Clob clob = rs.getClob(4);
            int note = rs.getInt(5);
            String abgabetext = "";
            Reader is = clob.getCharacterStream();
            BufferedReader br = new BufferedReader(is);
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();
            while(s!=null) {
            	sb.append(s);
            	s= br.readLine();
            }
            abgabetext = sb.toString();
             if(abgabetext == null) {
            	aufgabe.setAbgabetext("keine Abgabe");
            	aufgabe.setNote(null);
              }else {
            aufgabe.setAbgabetext(abgabetext);
            
            String strnote = String.valueOf(note);
              if(strnote == null) {
            	aufgabe.setNote("Noch keine Bewerbung");
               }else {
               aufgabe.setNote(strnote);
               }
              }
            aufgabeList.add(aufgabe);
            }
			return aufgabeList;	
		}
			
	}

