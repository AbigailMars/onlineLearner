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
		ResultSet rs = st.executeQuery("select t1.name,t2.name,t1.freiePlaetze,t1.kid from dbp056.kurs t1,dbp056.benutzer t2 where kid in  (select kid from dbp056.einschreiben where bnummer = 1) and t1.ersteller = t2.bnummer");
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
		ResultSet rs = st.executeQuery("select t1.name,t2.name,t1.freiePlaetze,t1.kid from dbp056.kurs t1,dbp056.benutzer t2 where kid not in  (select kid from dbp056.einschreiben where bnummer = 1) and t1.ersteller = t2.bnummer and t1.freiePlaetze >0");
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
		PreparedStatement st = connection.prepareStatement("select t1.name,t2.name,t1.beschreibungstext,t1.freieplaetze from dbp056.kurs t1,dbp056.benutzer t2 where kid = ? and t1.ersteller = t2.bnummer");
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
	
	public static int add(String name, String beschreibungstext, String enschreibeschluessel, int plaeze) throws SQLException,IOException{
		  Connection connection = null;
		  connection = DBUtil.getExternalConnection();
		  PreparedStatement ps = null;
	      String sql = "insert into dbp056.kurs (name, beschreibungstext, einschreibeschluessel, freiePlaetze, ersteller) values(?,?,?,?,1)";
		  ps = connection.prepareStatement(sql);
		  ps.setString(1, name);
		  ps.setString(2, beschreibungstext);
		  ps.setString(3, enschreibeschluessel);
		  ps.setInt(4, plaeze);
		  int row =ps.executeUpdate();
		  return row;			    
	}
	
	public static int deleteKursbyID(int kid) throws SQLException {
		 Connection connection = null;
		 connection = DBUtil.getExternalConnection();
		 //check if kid's ersteller is this user 1
		 PreparedStatement ps = null;
	     String sql = "select ersteller from dbp056.kurs where kid = ?";
		 ps = connection.prepareStatement(sql);
		 ps.setInt(1, kid);
		 ResultSet rs = ps.executeQuery();
		 int ersteller = 0;
		 while(rs.next()) {
			 ersteller = rs.getInt(1);
		 }
		 if(ersteller == 1) {	 
	     //delete from abgabe
		 PreparedStatement ps3 = null;
	     String sql3 = "delete from dbp056.abgabe where aid in (select aid from dbp056.einreichen where kid = ?)";
		 ps3 = connection.prepareStatement(sql3);
		 ps3.setInt(1, kid);
	     ps3.executeUpdate();
	     //delete from bewerten
		 PreparedStatement ps4 = null;
	     String sql4 = "delete from dbp056.bewerten where aid in (select aid from dbp056.einreichen where kid = ?)";
		 ps4 = connection.prepareStatement(sql4);
		 ps4.setInt(1, kid);
	     ps4.executeUpdate();
	     //delete from einreichen
		 PreparedStatement ps5 = null;
	     String sql5 = "delete from dbp056.einreichen where kid = ?";
		 ps5 = connection.prepareStatement(sql5);
		 ps5.setInt(1, kid);
	     ps5.executeUpdate();
	     //delete from aufgabe 
		 PreparedStatement ps2 = null;
	     String sql2 = "delete from dbp056.aufgabe where kid = ?";
		 ps2 = connection.prepareStatement(sql2);
		 ps2.setInt(1, kid);
	     ps2.executeUpdate();
	     //delete from einschreiben
		 PreparedStatement ps1 = null;
	     String sql1 = "delete from dbp056.einschreiben where kid = ?";
		 ps1 = connection.prepareStatement(sql1);
		 ps1.setInt(1, kid);
	     ps1.executeUpdate();
		 //delete from kurs
		 PreparedStatement ps6= null;
	     String sql6 = "delete from dbp056.kurs where kid = ?";
		 ps6 = connection.prepareStatement(sql6);
		 ps6.setInt(1, kid);
	     int i = ps6.executeUpdate();
	     return i;
		 }else {
			 return 0;
		 }		
	}
	
	public static void Update(int kid) throws SQLException {
		  Connection connection = null;
		  connection = DBUtil.getExternalConnection();
		  PreparedStatement ps = null;
	      String sql = "update dbp056.kurs set freiePlaetze=freiePlaetze-1 where kid = ?";
		  ps = connection.prepareStatement(sql);
		  ps.setInt(1, kid);		
		  ps.executeUpdate();
	}
	
}
