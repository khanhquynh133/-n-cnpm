package CNPM.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hodan {
	
	private List<Hodan> hodan = new ArrayList<Hodan>();
	private int idHodan;
	private String idVatnuoi;
	private String Username;
	private String Password;
	private String Fullname;
	private String Dob;
	private String Gender;
	private String Phonenumber;
	private String Address;
	private String iRole;
	
	public List<Hodan>  gethodan(){
		return this.hodan;
	}
	public int getIdHodan() {
		return idHodan;
	}
	
	public Hodan(int idHodan,String username, String password, String fullname, String dob,
			String gender, String phonenumber, String address, String role) {
		super();
		this.idHodan = idHodan;
		Username = username;
		Password = password;
		Fullname = fullname;
		Dob = dob;
		Gender = gender;
		Phonenumber = phonenumber;
		Address = address;
		iRole = role;
		
	}
	
	public void setIdHodan(int idHodan) {
		this.idHodan = idHodan;
	}


	public String getIdVatnuoi() {
		return idVatnuoi;
	}


	public void setIdVatnuoi(String idVatnuoi) {
		this.idVatnuoi = idVatnuoi;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getFullname() {
		return Fullname;
	}


	public void setFullname(String fullname) {
		Fullname = fullname;
	}


	public String getDob() {
		return Dob;
	}


	public void setDob(String dob) {
		Dob = dob;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getPhonenumber() {
		return Phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public Hodan(String username, String password, String fullname, String dob,
			String gender, String phonenumber, String address) {
		super();
		this.idVatnuoi = idVatnuoi;
		Username = username;
		Password = password;
		Fullname = fullname;
		Dob = dob;
		Gender = gender;
		Phonenumber = phonenumber;
		Address = address;
		
	}
	public Hodan(int idHodan, String username, String password, String fullname, String gender,
			String phonenumber, String address, String dob) {
		super();
		this.idHodan = idHodan;
		Username = username;
		Password = password;
		Fullname = fullname;
		Dob = dob;
		Gender = gender;
		Phonenumber = phonenumber;
		Address = address;
		
	}
	public Hodan( String username, String password, String fullname, String gender,
			String phonenumber, String address, String dob, String irole) {
		super();
		Username = username;
		Password = password;
		Fullname = fullname;
		Dob = dob;
		Gender = gender;
		Phonenumber = phonenumber;
		Address = address;
		
	}
	
	public void Add() {
		
	}
	@Override
	public String toString() {
	 return String.format("Hodan[idHodan = %s, idVatnuoi = %s, username = %s, password = %s, fullname = %s, dob = %s, "
	 		+ "gender = %s,  phonenumber = %s, address = %s]", 
	 		idHodan, idVatnuoi	, Username, Password, Fullname, Dob, Gender, Phonenumber);
}
	Connection conn = null;
	public Hodan(String u, String p) {
		Username = u;
		Password =p;
	}
	
	public String getRole() {
		String role ="";
		try {
			conn = Connect_DB.getSQLServer();
			String query = " select irole from Person where Username = '" + Username + "'";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				role = rs.getString("irole");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return role;
	}
	
	public String getFullName() {
		String fname ="";
		try {
			conn = Connect_DB.getSQLServer();
			String query = "select Fullname from dbo.Person where Username='" + Username + "'";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				fname = rs.getString("Fullname");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return fname;
	}
	public static Hodan getHDByID(int id,Connection conn) throws SQLException {
		String query = "select * from dbo.Person where idUser=" + id;
		Statement st = conn.createStatement();
		ResultSet rs= st.executeQuery(query);
		while (rs.next()) {
			int idUser = rs.getInt("idUser");
			String Username = rs.getString("Username");
			String iPassword = rs.getString("iPassword");
			String Fullname = rs.getString("Fullname");
			String Gender = rs.getString("Gender");
			String PhoneNumber = rs.getString("PhoneNumber");
			String iAddress = rs.getString("iAddress");
			String date =  rs.getString("Dob");
			String irole = rs.getString("irole");
			Hodan user = new Hodan(idUser,Username,iPassword,Fullname,date,Gender,PhoneNumber,iAddress,irole);
			return user;
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// đồ họa máy tính
//vẽ hình ngay giữa cửa sổ
/*CREATE TABLE "dbo"."HoDan" (
		"idHoDan" INT NOT NULL,
		"idVatNuoi" INT,
		"username" null,
		"password" null,
		"hoten" null,
		"tuoi" INT,
		"gioitinh" null,
		"sodienthoai" null,
		"diachi" null,
		"sogiayphep" INT,*/