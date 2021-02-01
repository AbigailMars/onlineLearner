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
		String sql = "select t1.anummer,t1.aid,t1.name,t2.abgabetext,t2.note from (select t1.anummer,t1.name,t2.aid from dbp056.aufgabe t1 "
				+ "Left Join (select * from dbp056.einreichen where bnummer =1) as t2 on t1.anummer = t2.anummer where t1.kid = ?) as t1 Left Join "
				+ "(select t1.aid,t1.abgabetext,t2.note from dbp056.abgabe t1 Left Join(select aid,avg(note) "
				+ "as note from dbp056.bewerten group by aid )as t2 on t1.aid = t2.aid) as t2 on t1.aid = t2.aid order by t1.anummer";
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
           
            if(clob == null) {
            	aufgabe.setAbgabetext("keine Abgabe");
            	aufgabe.setNote("Noch keine Bewerbung");
              }else {
            //transfer clob to string         
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

