package CNPM.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sourceforge.jtds.jdbc.DateTime;

public class Xemlichtiemmodel {
	int idHodan;
	String idVatNuoi;
	int Number;
	DateTime Date_register;
	
	Connection conn = null;
	
	public Xemlichtiemmodel() {
		
	}
	//Ho dan
	public int getIDfromUserName(String userName) {
		int id = 0;
		try {
			conn = Connect_DB.getSQLServer();
			String query = " select idUser from dbo.Person where Username='" + userName + "'";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				id = rs.getInt("idUser");
			}
			conn.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return id;
	}


	
}

