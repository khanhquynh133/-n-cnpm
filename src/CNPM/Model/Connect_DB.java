package CNPM.Model;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	public class Connect_DB {
		
		public static Connection getSQLServer() throws SQLException, ClassNotFoundException{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String url = "jdbc:jtds:sqlserver://localhost:1433/QuanLyTiemChung2;instace= SQLEXPRESS";
			Connection conn = DriverManager.getConnection(url, "sa", "kq");
			return conn;}
		
		/*public Statement ExecutePreStatement(Connection conn,String query, Object[] paras) {
			try {
					String url = query;
					PreparedStatement pre = conn.prepareStatement(url);
					
				}
			catch (Exception e) {};
		} */
		public static void main(String args[]) throws SQLException, ClassNotFoundException{
			//System.out.println("Connect to QuanLyTiemChung2");
			//Connection conn = Connect_DB.getSQLServer("localhost", "SQLEXPRESS", "QuanLiTiemChung2", "sa", "kq");
			//System.out.println(conn);
}
	}
