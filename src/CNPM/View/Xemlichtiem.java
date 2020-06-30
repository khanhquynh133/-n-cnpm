package CNPM.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;
import CNPM.Model.Xemlichtiemmodel;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Xemlichtiem extends JFrame {
	private JTable table;
	String userName;
	static Hodan user;
	Connection conn = null;
	private JTextField txtten;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*Xemlichtiem frame = new Xemlichtiem(user);
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Xemlichtiem(Hodan u) {
		this.user = u;
		setBounds(100, 100, 814, 546);
		getContentPane().setLayout(null);
		/*dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String d1  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			}
		});*/

		/*if((Date) dateChooser.getDate() != null) {
			Date date = (Date) dateChooser.getDate();
			txtdate.setText(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate()));
		}*/
		
		

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(215, 230, 245));
		panel_2.setBounds(0, 0, 806, 517);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ ngày ");
		lblNewLabel.setForeground(new Color(92, 118, 169));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(140, 161, 99, 31);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đến ngày ");
		lblNewLabel_1.setForeground(new Color(92, 118, 169));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(396, 161, 110, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setText("Tài khoản");
		lblNewLabel_3.setForeground(new Color(92, 118, 169));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(140, 109, 99, 31);
		panel_2.add(lblNewLabel_3);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBounds(0, 0, 1, 1);
		panel_2.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(29, 258, 742, 237);
		panel_2.add(scrollPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(249, 161, 131, 31);
		panel_2.add(dateChooser);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(516, 161, 131, 31);
		panel_2.add(dateChooser_1);
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		
		JButton btchitiet = new JButton("CHI TIẾT");
		
		btchitiet.setForeground(Color.WHITE);
		btchitiet.setBackground(new Color(92, 118, 169));
		btchitiet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btchitiet.setBounds(273, 216, 131, 31);
		btchitiet.setBorder(null);

		txtten = new JTextField();
		txtten.setBackground(Color.WHITE);
		txtten.setBounds(249, 109, 398, 37);
		panel_2.add(txtten);
		txtten.setColumns(10);
		txtten.setText(u.getFullname());
		txtten.setEditable(false);
		
		btchitiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (user.getRole().compareTo("Hộ dân")==0)
				{

					if (dateChooser_1.getDate()!=null && dateChooser.getDate()!=null)
					{
						try 
						{
							model.setRowCount(0);
							int idHD = user.getIdHodan();
							conn = Connect_DB.getSQLServer();
							Statement stmt = conn.createStatement();
							String dayfrom=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
							String dayto=((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText();
							String query = "select idHoDan,idVatNuoi,Number,Date_register from DangkiTiem where Date_register>='"+dayfrom+"' and Date_register<='"+dayto+"' and idHoDan = "+idHD;
							ResultSet rs = stmt.executeQuery(query);
							ResultSetMetaData rsmd=rs.getMetaData();
							
							//((PreparedStatement) rs).setInt(1, idHD);
							while (rs.next()) 
							{
								String idvn=rs.getString("idVatNuoi");
								int solg=rs.getInt("Number");
								Date ngay=rs.getDate("Date_register") ;
								model.addRow(new Object[] {idHD,idvn,solg,ngay});
							}
							rs.close();
							stmt.close();
						} 
						catch(Exception ee)
						{
						    JOptionPane.showMessageDialog(null,"Error in connect");
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Bạn chưa chọn ngày!!");
				}
				else
				{
					if (dateChooser_1.getDate()!=null && dateChooser.getDate()!=null)
					{
						try 
						{
							model.setRowCount(0);
							//int idHD = user.getIdHodan();
							conn = Connect_DB.getSQLServer();
							Statement stmt = conn.createStatement();
							String dayfrom=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
							String dayto=((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText();
							String query = "select idHoDan,idVatNuoi,Number,Date_register from DangkiTiem where Date_register>='"+dayfrom+"' and Date_register<='"+dayto+"'";
							ResultSet rs = stmt.executeQuery(query);
							ResultSetMetaData rsmd=rs.getMetaData();
							while (rs.next()) 
							{
								int id=rs.getInt("idHoDan");
								String idvn=rs.getString("idVatNuoi");
								int solg=rs.getInt("Number");
								Date ngay=rs.getDate("Date_register") ;
								model.addRow(new Object[] {id,idvn,solg,ngay});
							}
							rs.close();
							stmt.close();
						} 
						catch(Exception ee)
						{
						    JOptionPane.showMessageDialog(null,"Error in connect");
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Bạn chưa chọn ngày!!");
				
				}
			}
		});
		model.addColumn("ID Hộ dân");
		model.addColumn("ID Vật nuôi");
		model.addColumn("Số lượng");
		model.addColumn("Thời gian đăng kí");
		panel_2.add(btchitiet);
		
		JButton btclear = new JButton("CLEAR");
		
		btclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser.setCalendar(null);
				dateChooser_1.setCalendar(null);
				model.setRowCount(0);
			}
		});
	
		btclear.setForeground(Color.WHITE);
		btclear.setBackground(new Color(92, 118, 169));
		btclear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btclear.setBounds(432, 216, 100, 31);
		btclear.setBorder(null);
		panel_2.add(btclear);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(92, 118, 169));
		panel.setBounds(0, 0, 806, 85);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("HỆ THỐNG QUẢN LÍ TIÊM CHỦNG GIA SÚC GIA CẦM");
		lblNewLabel_1_1.setBounds(142, 11, 575, 27);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("CHI TI\u1EBET L\u1ECACH \u0110\u0102NG K\u00CD");
		lblNewLabel_2.setBounds(300, 49, 242, 25);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Xemlichtiem.class.getResource("/gambar/logobty.png")));
		lblNewLabel_2_1.setBounds(10, 0, 88, 83);
		panel.add(lblNewLabel_2_1);
	}
}
