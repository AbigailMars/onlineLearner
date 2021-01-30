package de.unidue.inf.is.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.utils.DBUtil;

public class KursDao {
	
	public static List<Kurs> findKurs() throws SQLException,IOException {
		Connection connection = DBUtil.getExternalConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select t1.name,t2.name,t1.freiePlaetze,t1.kid from dbp057.kurs t1,dbp057.benutzer t2 where kid in  (select kid from dbp057.einschreiben where bnummer = 1) and t1.ersteller = t2.bnummer");
		List<Kurs> kursList = new ArrayList<>();
		while(rs.next()){
			Kurs kurs = new Kurs();
			kurs.setName(rs.getString(1));
			kurs.setErsteller(rs.getString(2));
			kurs.setFreieplaetze(rs.getInt(3));
			kurs.setKid(rs.getInt(4));
			kursList.add(kurs);
		}
		return kursList;		
	}
	
	public static List<Kurs> findVerfuegbareKurs() throws SQLException,IOException {
		Connection connection = DBUtil.getExternalConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select t1.name,t2.name,t1.freiePlaetze,t1.kid from dbp057.kurs t1,dbp057.benutzer t2 where kid not in  (select kid from dbp057.einschreiben where bnummer = 1) and t1.ersteller = t2.bnummer and t1.freiePlaetze >0");
		List<Kurs> kursList = new ArrayList<>();
		while(rs.next()){
			Kurs kurs = new Kurs();
			kurs.setName(rs.getString(1));
			kurs.setErsteller(rs.getString(2));
			kurs.setFreieplaetze(rs.getInt(3));
			kurs.setKid(rs.getInt(4));
			kursList.add(kurs);
		}
		return kursList;		
	}
	
	public static Kurs getKursById(int kid) throws SQLException,IOException {
		Connection connection = DBUtil.getExternalConnection();
		PreparedStatement st = connection.prepareStatement("select t1.name,t2.name,t1.beschreibungstext,t1.freieplaetze from dbp057.kurs t1,dbp057.benutzer t2 where kid = ? and t1.ersteller = t2.bnummer");
		st.setInt(1, kid);
		ResultSet rs = st.executeQuery();
		Kurs kurs = new Kurs();
		while(rs.next()){
			kurs.setKid(kid);
			kurs.setName(rs.getString(1));
			kurs.setErsteller(rs.getString(2));
			kurs.setBeschreibungstext(rs.getString(3));
			kurs.setFreieplaetze(rs.getInt(4));
		}
		return kurs;
		
	}
	
}
