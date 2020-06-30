package CNPM.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import CNPM.Model.Animal;
import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;
import CNPM.Model.Vacxin;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLiHoDan extends JFrame {

	private JPanel contentPane;
	
	Hodan user;
	//static Hodan t = new Hodan(6,"30thangs9","Trangmoon309","Huá»³nh Nguyá»…n PhÆ°Æ¡ng Trang","2000-09-30","Ná»¯","0338698918","Duy XuyÃªn, Quáº£ng Nam","Admin");

	Connection connect = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//QuanLiHoDan frame = new QuanLiHoDan(t);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	private JTextField tbUsername;
	private JTextField tbFullname;
	private JTextField tbPhone;
	private JTextField tbDOB;
	private JTextField tbAddress;
	private JTextField tbType;
	private JTextField tbPassword;
	
	public QuanLiHoDan(Hodan u) {
		this.user = u;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 230, 245));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(92, 118, 169));
		panel.setBounds(0, 0, 993, 102);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("HỆ THỐNG QUẢN LÍ TIÊM CHỦNG GIA SÚC GIA CẦM");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(188, 0, 715, 55);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CHỈNH SỬA THÔNG TIN ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(406, 42, 295, 55);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(QuanLiHoDan.class.getResource("/gambar/logobty.png")));
		lblNewLabel_2_1.setBounds(35, 8, 100, 89);
		panel.add(lblNewLabel_2_1);
		
		tbUsername = new JTextField();
		tbUsername.setForeground(Color.BLACK);
		tbUsername.setBounds(205, 164, 255, 32);
		contentPane.add(tbUsername);
		tbUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbUsername.setColumns(10);
		tbUsername.setBackground(new Color(222, 233, 245));
		tbUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbUsername.setText(user.getUsername());
		
		JLabel lbSL1_1 = new JLabel("Password");
		lbSL1_1.setForeground(new Color(92, 118, 169));
		lbSL1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lbSL1_1.setBounds(560, 164, 96, 34);
		contentPane.add(lbSL1_1);
		
		JLabel lbSL1_2 = new JLabel("Username");
		lbSL1_2.setForeground(new Color(92, 118, 169));
		lbSL1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lbSL1_2.setBounds(72, 164, 133, 34);
		contentPane.add(lbSL1_2);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setForeground(new Color(92, 118, 169));
		lblHVTn.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHVTn.setBounds(72, 230, 133, 34);
		contentPane.add(lblHVTn);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setForeground(new Color(92, 118, 169));
		lblGiiTnh.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGiiTnh.setBounds(560, 230, 96, 34);
		contentPane.add(lblGiiTnh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setForeground(new Color(92, 118, 169));
		lblSinThoi.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSinThoi.setBounds(72, 298, 133, 34);
		contentPane.add(lblSinThoi);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setForeground(new Color(92, 118, 169));
		lblaCh.setFont(new Font("Arial", Font.PLAIN, 20));
		lblaCh.setBounds(560, 298, 133, 34);
		contentPane.add(lblaCh);
		
		JLabel lblNgySinh = new JLabel("Password");
		lblNgySinh.setForeground(new Color(92, 118, 169));
		lblNgySinh.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgySinh.setBounds(72, 364, 133, 34);
		contentPane.add(lblNgySinh);
		
		JLabel lblChcV = new JLabel("Tài khoản");
		lblChcV.setForeground(new Color(92, 118, 169));
		lblChcV.setFont(new Font("Arial", Font.PLAIN, 20));
		lblChcV.setBounds(560, 364, 133, 34);
		contentPane.add(lblChcV);
		
		tbFullname = new JTextField();
		tbFullname.setForeground(Color.BLACK);
		tbFullname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbFullname.setColumns(10);
		tbFullname.setBackground(new Color(224, 233, 245));
		tbFullname.setBounds(205, 230, 255, 32);
		contentPane.add(tbFullname);
		tbFullname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbFullname.setText(user.getFullname());

		
		tbPhone = new JTextField();
		tbPhone.setForeground(Color.BLACK);
		tbPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbPhone.setColumns(10);
		tbPhone.setBackground(new Color(224, 233, 245));
		tbPhone.setBounds(205, 298, 255, 32);
		contentPane.add(tbPhone);
		tbPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbPhone.setText(user.getPhonenumber());
		
		tbDOB = new JTextField();
		tbDOB.setForeground(Color.BLACK);
		tbDOB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbDOB.setColumns(10);
		tbDOB.setBackground(new Color(224, 233, 245));
		tbDOB.setBounds(205, 364, 255, 32);
		contentPane.add(tbDOB);
		tbDOB.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbDOB.setText(user.getDob());
		
		
		ButtonGroup G = new ButtonGroup();
				
		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setForeground(new Color(92, 118, 169));
		rdNam.setBackground(new Color(215, 230, 245));
		rdNam.setFont(new Font("Arial", Font.ITALIC, 18));
		rdNam.setBounds(668, 234, 89, 25);
		contentPane.add(rdNam);
		
		
		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setForeground(new Color(92, 118, 169));
		rdNu.setFont(new Font("Arial", Font.ITALIC, 18));
		rdNu.setBackground(new Color(215, 230, 245));
		rdNu.setBounds(780, 234, 79, 25);
		contentPane.add(rdNu);
		
		G.add(rdNam);
		G.add(rdNu);
		
		String gender = user.getGender();

		if(gender.equals("Nam")) rdNam.setSelected(true);
		else rdNu.setSelected(true);

		
		tbAddress = new JTextField();
		tbAddress.setForeground(Color.BLACK);
		tbAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbAddress.setColumns(10);
		tbAddress.setBackground(new Color(224, 233, 245));
		tbAddress.setBounds(668, 298, 255, 32);
		contentPane.add(tbAddress);
		tbAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbAddress.setText(user.getAddress());

		
		tbType = new JTextField();
		tbType.setForeground(Color.BLACK);
		tbType.setFont(new Font("Tahoma", Font.BOLD, 19));
		tbType.setColumns(10);
		tbType.setBackground(new Color(224, 233, 245));
		tbType.setBounds(668, 364, 255, 32);
		contentPane.add(tbType);
		tbType.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbType.setText(user.getRole());
		tbType.setEditable(false);
		tbType.setEnabled(false);
		
		
		//Click capnhat
		JButton btnCpNht = new JButton("CẬP NHẬT");
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String gender = "";
				if(rdNam.isSelected() == true) gender = "Nam";
				else gender = "Nu";
				Hodan hd = new Hodan(user.getIdHodan(),tbUsername.getText(),tbPassword.getText(),tbFullname.getText(),tbDOB.getText(),gender,tbPhone.getText(),tbAddress.getText(),tbType.getText());
				java.sql.Date sqlDate = java.sql.Date.valueOf(hd.getDob());
				
				try {
					conn = Connect_DB.getSQLServer();
					String query = "update dbo.Person set Username = ?, iPassword = ?, Fullname = ?, Gender = ?, PhoneNumber = ?, iAddress = ?, Dob = ? where idUser = ?";
					PreparedStatement pre = conn.prepareStatement(query);
					int idHD = user.getIdHodan();
					pre.setString(1, hd.getUsername());
					pre.setString(2, hd.getPassword());
					pre.setString(3, hd.getFullname());
					pre.setString(4, hd.getGender());
					pre.setString(5, hd.getPhonenumber());
					pre.setString(6, hd.getAddress());
					pre.setDate(7, sqlDate);
					pre.setInt(8, hd.getIdHodan());
					int row= pre.executeUpdate();
					if(row != 0) JOptionPane.showMessageDialog(null,"Thanh cong!");

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCpNht.setForeground(Color.WHITE);
		btnCpNht.setFont(new Font("Arial", Font.BOLD, 18));
		btnCpNht.setBackground(new Color(92, 118, 169));
		btnCpNht.setBounds(419, 457, 158, 42);
		btnCpNht.setBorder(null);

		contentPane.add(btnCpNht);
		
		tbPassword = new JTextField();
		tbPassword.setForeground(Color.BLACK);
		tbPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbPassword.setColumns(10);
		tbPassword.setBackground(new Color(222, 233, 245));
		tbPassword.setBounds(668, 164, 255, 32);
		contentPane.add(tbPassword);
		tbPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tbPassword.setText(user.getPassword());

	}
	
	void LoadData(JTable table) {
		try {
			conn = Connect_DB.getSQLServer();
			String query = "select * from Person";
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID Há»™ dÃ¢n");
			model.addColumn("UserName");
			model.addColumn("Há»� vÃ  tÃªn");
			model.addColumn("Giá»›i tÃ­nh");
			model.addColumn("Sá»‘ Ä‘iá»‡n thoáº¡i");
			model.addColumn("Ä�á»‹a chá»‰");
			model.addColumn("NgÃ y/thÃ¡ng/nÄƒm sinh");
			
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				int ID = rs.getInt("idUser");
				String username = rs.getString("Username");
				String name = rs.getString("Fullname");
				String total = rs.getString("Gender");
				String phonenum = rs.getString("PhoneNumber");
				String add = rs.getString("iAddress");
				String dob = rs.getString("Dob");
				model.addRow(new Object[] {
						ID,
						username,
						name,
						total,
						phonenum,
						add,
						dob
				});
			}
			conn.close();
			
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
