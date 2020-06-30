package CNPM.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import CNPM.Model.Animal;
import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;
import CNPM.Model.RegisterTiemModel;
import CNPM.Model.Vacxin;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class RegisterTiem extends JFrame {

	private JPanel contentPane;
	private JTextField tbSL1;
	private JTextField tbSL2;
	private JTextField tbSL3;
	int flagChooseDate = 0;

	Hodan user;
	Connection conn = null;
	int slVatNuoi =1;
	String mydate;
	//static Hodan t = new Hodan(6,"30thangs9","Trangmoon309","Huỳnh Nguyễn Phương Trang","2000-09-30","Nữ","0338698918","Duy Xuyên, Quảng Nam","Admin");
	private JButton btnDangKy;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//RegisterTiem frame = new RegisterTiem(t);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegisterTiem(Hodan u) {
		setBackground(Color.LIGHT_GRAY);
		this.user = u;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 228, 242));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(92, 118, 169));
		panel.setBounds(0, 0, 1052, 102);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("HỆ THỐNG QUẢN LÝ TIÊM CHỦNG THÀNH PHỐ ĐÀ NẴNG");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(216, 1, 715, 55);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ĐĂNG KÝ LỊCH TIÊM");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(441, 44, 232, 55);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegisterTiem.class.getResource("/gambar/logobty.png")));
		lblNewLabel_2.setBounds(57, 8, 100, 89);
		panel.add(lblNewLabel_2);
		
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(5, 5, 1047, 685);
				panel_1.setBackground(new Color(215, 228, 242));
				contentPane.add(panel_1);
				
				JLabel lbHoten = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
				lbHoten.setBounds(55, 135, 89, 34);
				lbHoten.setForeground(Color.BLACK);
				lbHoten.setFont(new Font("Arial", Font.PLAIN, 19));
				
				JLabel lbSoLuongVN = new JLabel("S\u1ED1 lo\u1EA1i v\u1EADt nu\u00F4i");
				lbSoLuongVN.setBounds(55, 247, 133, 34);
				lbSoLuongVN.setForeground(Color.BLACK);
				lbSoLuongVN.setFont(new Font("Arial", Font.PLAIN, 19));
				
				JLabel lbVN1 = new JLabel("V\u1EADt nu\u00F4i 1");
				lbVN1.setBounds(55, 296, 133, 34);
				lbVN1.setForeground(Color.BLACK);
				lbVN1.setFont(new Font("Arial", Font.PLAIN, 19));
				
				JLabel lbSL1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
				lbSL1.setBounds(55, 340, 133, 34);
				lbSL1.setForeground(Color.BLACK);
				lbSL1.setFont(new Font("Arial", Font.PLAIN, 19));
				
				JLabel lbVN2 = new JLabel("V\u1EADt nu\u00F4i 2");
				lbVN2.setBounds(55, 386, 133, 34);
				lbVN2.setForeground(Color.BLACK);
				lbVN2.setFont(new Font("Arial", Font.PLAIN, 19));
				lbVN2.setVisible(false);
				
				JLabel lbSL2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
				lbSL2.setBounds(55, 430, 133, 34);
				lbSL2.setForeground(Color.BLACK);
				lbSL2.setFont(new Font("Arial", Font.PLAIN, 19));
				lbSL2.setVisible(false);
				
				JLabel lbVN3 = new JLabel("V\u1EADt nu\u00F4i 3");
				lbVN3.setBounds(55, 476, 133, 34);
				lbVN3.setForeground(Color.BLACK);
				lbVN3.setFont(new Font("Arial", Font.PLAIN, 19));
				lbVN3.setVisible(false);
				
				JLabel lbSL3 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
				lbSL3.setBounds(55, 522, 133, 34);
				lbSL3.setForeground(Color.BLACK);
				lbSL3.setFont(new Font("Arial", Font.PLAIN, 19));
				lbSL3.setVisible(false);
				
				JComboBox cbVN1 = new JComboBox();
				cbVN1.setBounds(211, 298, 117, 29);
				cbVN1.setBackground(new Color(215, 228, 242));
				cbVN1.setModel(new DefaultComboBoxModel(new String[] {"", "Ngan", "G\u00E0", "B\u00F2", "Tr\u00E2u", "D\u00EA", "Heo"}));
				cbVN1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				
				JComboBox cbVN2 = new JComboBox();
				cbVN2.setBounds(212, 388, 117, 29);
				cbVN2.setModel(new DefaultComboBoxModel(new String[] {"", "Ngan", "G\u00E0", "B\u00F2", "Tr\u00E2u", "D\u00EA", "Heo"}));
				cbVN2.setFont(new Font("Tahoma", Font.PLAIN, 17));
				cbVN2.setBackground(new Color(215, 228, 242));
				cbVN2.setVisible(false);
				
				JComboBox cbVN3 = new JComboBox();
				cbVN3.setBounds(213, 478, 117, 29);
				cbVN3.setModel(new DefaultComboBoxModel(new String[] {"", "Ngan", "G\u00E0", "B\u00F2", "Tr\u00E2u", "D\u00EA", "Heo"}));
				cbVN3.setFont(new Font("Tahoma", Font.PLAIN, 17));
				cbVN3.setBackground(new Color(215, 228, 242));
				cbVN3.setVisible(false);
				
				tbSL1 = new JTextField();
				tbSL1.setBounds(212, 342, 116, 29);
				tbSL1.setBackground(new Color(215, 228, 242));
				tbSL1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				tbSL1.setColumns(10);
				tbSL1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

				
				tbSL2 = new JTextField();
				tbSL2.setBounds(212, 432, 116, 29);
				tbSL2.setBackground(new Color(215, 228, 242));
				tbSL2.setFont(new Font("Tahoma", Font.PLAIN, 17));
				tbSL2.setColumns(10);
				tbSL2.setVisible(false);
				tbSL2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

				tbSL3 = new JTextField();
				tbSL3.setBounds(213, 524, 116, 29);
				tbSL3.setBackground(new Color(215, 228, 242));
				tbSL3.setFont(new Font("Tahoma", Font.PLAIN, 17));
				tbSL3.setColumns(10);
				tbSL3.setVisible(false);
				tbSL3.setBorder(javax.swing.BorderFactory.createEmptyBorder());

				
				//Button DangKy Event Handler
				btnDangKy = new JButton("ĐĂNG KÝ");
				btnDangKy.setForeground(Color.BLACK);
				btnDangKy.setBounds(210, 396, 158, 42);
				btnDangKy.setBackground(new Color(92,118,169));
				btnDangKy.setFont(new Font("Arial", Font.BOLD, 18));
				
				//Combobox so luong loai vat nuoi Event Handler
				JComboBox cbSL = new JComboBox();
				cbSL.setBounds(212, 246, 60, 34);
				cbSL.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				cbSL.setBackground(new Color(215, 228, 242));
				cbSL.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String selectedItem = (String)cbSL.getSelectedItem();
						if(Integer.parseInt(selectedItem) == 2) {
							cbVN2.setVisible(true);
							tbSL2.setVisible(true);
							lbVN2.setVisible(true);
							lbSL2.setVisible(true);
							btnDangKy.setBounds(210, 480, 158, 42);
							slVatNuoi =2;
						}
						else if(Integer.parseInt(selectedItem) == 3) {
							cbVN2.setVisible(true);
							tbSL2.setVisible(true);
							lbVN2.setVisible(true);
							lbSL2.setVisible(true);
							cbVN3.setVisible(true);
							tbSL3.setVisible(true);
							lbVN3.setVisible(true);
							lbSL3.setVisible(true);
							btnDangKy.setBounds(210, 580, 158, 42);
							slVatNuoi =3;
						}
						else {
							cbVN2.setVisible(false);
							tbSL2.setVisible(false);
							lbVN2.setVisible(false);
							lbSL2.setVisible(false);
							cbVN3.setVisible(false);
							tbSL3.setVisible(false);
							lbVN3.setVisible(false);
							lbSL3.setVisible(false);
							btnDangKy.setBounds(210, 396, 158, 42);
							slVatNuoi = 1;
						}
					}
				});
				
						cbSL.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
						cbSL.setFont(new Font("Tahoma", Font.PLAIN, 17));
						
						JLabel lbHoten_1 = new JLabel("New label");
						lbHoten_1.setBounds(212, 138, 366, 27);
						lbHoten_1.setFont(new Font("Arial", Font.BOLD, 20));
						lbHoten_1.setText(user.getFullname());
						
						JDateChooser datePicker = new JDateChooser();
						datePicker.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent evt) {
								if(datePicker.getDate() != null) {
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
									String date = sdf.format(datePicker.getDate());
									mydate = date;
									flagChooseDate = 1;
								}
							}
						});
						datePicker.setBounds(213, 192, 245, 38);
						datePicker.getCalendarButton().setBackground(new Color(173, 216, 230));
						datePicker.setForeground(SystemColor.windowBorder);
						datePicker.setFont(new Font("Tahoma", Font.PLAIN, 18));
						datePicker.setDateFormatString("yyyy-MM-dd");
						panel_1.setLayout(null);
						panel_1.add(lbHoten);
						panel_1.add(lbSoLuongVN);
						panel_1.add(lbVN1);
						panel_1.add(lbSL1);
						panel_1.add(lbVN2);
						panel_1.add(lbSL2);
						panel_1.add(lbVN3);
						panel_1.add(lbSL3);
						panel_1.add(cbSL);
						panel_1.add(cbVN1);
						panel_1.add(datePicker);
						panel_1.add(lbHoten_1);
						panel_1.add(tbSL1);
						panel_1.add(tbSL2);
						panel_1.add(btnDangKy);
						panel_1.add(cbVN2);
						panel_1.add(cbVN3);
						panel_1.add(tbSL3);
						
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(RegisterTiem.class.getResource("/gambar/animal-register.png")));
						lblNewLabel.setBounds(581, 137, 431, 399);
						panel_1.add(lblNewLabel);
						
						JLabel lblNgyngK = new JLabel("Ngày đăng ký");
						lblNgyngK.setForeground(Color.BLACK);
						lblNgyngK.setFont(new Font("Arial", Font.PLAIN, 19));
						lblNgyngK.setBounds(55, 192, 133, 34);
						panel_1.add(lblNgyngK);
						
						JPanel panel_2 = new JPanel();
						panel_2.setBorder(null);
						panel_2.setBackground(new Color(192,211,230));
						panel_2.setBounds(0, 98, 569, 576);
						panel_1.add(panel_2);
						panel_2.setLayout(null);



		
		//Su kien dang ky teim
		btnDangKy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenVN="";
				String tenVN1= cbVN1.getSelectedItem().toString();
				String tenVN2= cbVN2.getSelectedItem().toString();
				String tenVN3= cbVN3.getSelectedItem().toString();	
				String slVN1 = tbSL1.getText();
				String slVN2 = tbSL2.getText();
				String slVN3 = tbSL3.getText();
				int flag = 1;
				if(slVatNuoi==2) {
					if(tenVN1==tenVN2) {
						JOptionPane.showMessageDialog(null,"Vui long cac loai vat nuoi khong trung nhau!");
						flag = 0;
					}
				}
				else if(slVatNuoi==3) {
					if(tenVN1==tenVN2 || tenVN1==tenVN3 || tenVN2==tenVN3) {
						JOptionPane.showMessageDialog(null,"Vui long cac loai vat nuoi khong trung nhau!");
						flag =0;
					}
				}
				
				if(flag == 1) {
					try {
						int i=1;
						int soLuongVN = 0;
						while(slVatNuoi >0) {
							if(flagChooseDate == 0) {
								JOptionPane.showMessageDialog(null,"Vui long chon ngay dang ky!");
								break;
							}
							if(soLuongVN == 1) {
								if(tenVN == "") {
									JOptionPane.showMessageDialog(null,"Vui long chon ten vat nuoi!");
									break;
								}
							}
							
							if(soLuongVN == 2) {
								if(tenVN == "" || tenVN2 =="") {
									JOptionPane.showMessageDialog(null,"Vui long chon ten vat nuoi!");
									break;
								}
							}
							
							if(soLuongVN == 3) {
								if(tenVN == "" || tenVN2 =="" || tenVN3=="") {
									JOptionPane.showMessageDialog(null,"Vui long chon ten vat nuoi!");
									break;
								}
							}

							if(i==1) {
								tenVN = cbVN1.getSelectedItem().toString();
								try {
									soLuongVN = Integer.parseInt(tbSL1.getText());
								}
								catch(Exception ee) {
									JOptionPane.showMessageDialog(null,"Vui long nhap so luong vat nuoi!");
									break;
								}
							}
							else if(i==2) {
								tenVN = cbVN2.getSelectedItem().toString();;
								try {
									soLuongVN = Integer.parseInt(tbSL2.getText());
								}
								catch(Exception ee) {
									JOptionPane.showMessageDialog(null,"Vui long nhap so luong vat nuoi!");
									break;
								}
							}
							else if(i==3) {
								tenVN = cbVN3.getSelectedItem().toString();;
								try {
									soLuongVN = Integer.parseInt(tbSL3.getText());
								}
								catch(Exception ee) {
									JOptionPane.showMessageDialog(null,"Vui long nhap so luong vat nuoi!");
									break;
								}
							}
							conn = Connect_DB.getSQLServer();
							String query = "insert into DangkiTiem(idHodan,idVatNuoi,idVaccine,Number,Date_register) values (?,?,?,?,?)";
							PreparedStatement pre = conn.prepareStatement(query);
							int idHD = user.getIdHodan();
							String IDVN = Animal.getIDByAnimalName(conn,tenVN);
							pre.setInt(1, idHD);
							pre.setString(2, IDVN);
							pre.setString(3,Vacxin.getIDVaccine(conn,IDVN));
							pre.setInt(4, soLuongVN);
							java.sql.Date sqlDate = java.sql.Date.valueOf( mydate );
							pre.setDate(5, sqlDate);
							int row= pre.executeUpdate();
							slVatNuoi--;
							i++;
							if(row != 0) JOptionPane.showMessageDialog(null,"Thanh cong!");
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	}

}