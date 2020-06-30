package CNPM.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Animal {
	private String idVatnuoi;
	private String tenVatnuoi;
	
	private static List<Animal> anis = new ArrayList<Animal>();
	
	public static List<Animal> getAnimals() throws SQLException{
		Connection conn = null;
		String url = "select * from dbo.Animal";
		Statement st = conn.createStatement();
		ResultSet rs= st.executeQuery(url);
		while(rs.next()) {
			Animal item = new Animal(rs.getString("idVatNuoi"),rs.getString("Vatnuoi_name"));
			anis.add(item);
		}
		return anis;
	}
	
	public String getIdVatnuoi() {
		return idVatnuoi;
	}


	public void setIdVatnuoi(String idVatnuoi) {
		this.idVatnuoi = idVatnuoi;
	}

	public String getTenVatnuoi() {
		return tenVatnuoi;
	}


	public void setTenVatnuoi(String tenVatnuoi) {
		this.tenVatnuoi = tenVatnuoi;
	}


	public Animal(String idVatnuoi, String tenVatnuoi) {
		super();
		this.idVatnuoi = idVatnuoi;
		this.tenVatnuoi = tenVatnuoi;
	}
	@Override
	public String toString() {
	 return String.format("Animal[idVatnuoi = %s, tenVatnuoi = %s]", idVatnuoi, tenVatnuoi);
}
	static Connection conn = null;
	//Edit By Trang
		public Animal() {
			
		}
		public static String getIDByAnimalName(String animalName) {
			String id = "";
			try {
				conn = Connect_DB.getSQLServer();
				String query = " select idVatNuoi from dbo.Animal where Vatnuoi_name='" + animalName + "'";
				Statement st = conn.createStatement();
				ResultSet rs= st.executeQuery(query);
				while(rs.next()) {
					id = rs.getString("idVatNuoi");
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return id;
		}
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
