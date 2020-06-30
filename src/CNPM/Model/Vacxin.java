package CNPM.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Vacxin {
	private String idVaccine;
	private String tenvaccine;
	private int soluong;
	private String idVatNuoi;
	private static List<Vacxin> vaccines = new ArrayList<Vacxin>();
	
	public Vacxin(){

	}
	
	public static List<Vacxin> getVacxins() throws SQLException {
		Connection conn = null;
		String url = "select * from dbo.Vaccine_r";
		Statement st = conn.createStatement();
		ResultSet rs= st.executeQuery(url);
		while(rs.next()) {
			Vacxin item = new Vacxin(rs.getString("idVaccine"),rs.getString("Vaccine_name"),rs.getInt("Number"),rs.getString("idVatNuoi"));
			vaccines.add(item);
		}
		return vaccines;
	}
	
	public Vacxin(String idVaccine, String tenvaccine, int soluong, String idVatnuoi) {
		super();
		this.idVaccine = idVaccine;
		this.tenvaccine = tenvaccine;
		this.soluong = soluong;
		this.idVatNuoi = idVatnuoi;
	}


	public String getIdVaccine() {
		return idVaccine;
	}


	public void setIdVaccine(String idVaccine) {
		this.idVaccine = idVaccine;
	}
	
	public String getIdVatnuoi() {
		return idVaccine;
	}


	public void setIdVatnuoi(String idVatnuoi) {
		this.idVatNuoi = idVatnuoi;
	}
	public String getTenvaccine() {
		return tenvaccine;
	}


	public void setTenvaccine(String tenvaccine) {
		this.tenvaccine = tenvaccine;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return  String.format("Vacxin[idVaccine = %s,  tenvaccine= %s,  soluong= %d ]", idVaccine, tenvaccine, soluong);
	}

	Connection conn = null;

	
	public static String getIDVaccine(String idVatNuoi) {
		Connection conn;
		String id =null;
		try {
			conn = Connect_DB.getSQLServer();
			String url = "select idVaccine from dbo.Vaccine_r where idVatNuoi='"  + idVatNuoi + "'";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(url);
			while(rs.next()) {
				id = rs.getString("idVaccine");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
