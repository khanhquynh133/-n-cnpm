package CNPM.View;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;

import java.awt.Color;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Register {

	private JFrame frmDangki;
	private JTextField txtfullname, txtdob, txtsdt, txtusername;
	private JPasswordField passwordField, repasswordField;
	private JLabel lblGender, lblFullname, lbldob, lbldiachi, lblSdt, lblusername, lblpass, lblrepass, lblTiKhon,
			lbldangnhap, infor;
	private JButton btnregister, btnExit, btnMaximize;
	private JRadioButton rdbtnNam, rdbtnN, rdbtnkhac;
	private ButtonGroup group;
	private JCheckBox cbShowPassword;
	private JPanel personalinfo, account, pnlHeader;
	private JTextArea textAreaadd;
	static boolean maximize = true;
	int xMouse, yMouse;
	Connection connect = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register register = new Register();
					register.frmDangki.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		frmDangki = new JFrame();
		frmDangki.setUndecorated(true);
		frmDangki.setLocationRelativeTo(null);
		frmDangki.setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/gambar/hr.png")));
		frmDangki.getContentPane().setBackground(SystemColor.activeCaption);
		frmDangki.getContentPane().setLayout(null);
		frmDangki.setTitle("Đăng kí thành viên");
		frmDangki.setBounds(268, 168, 841, 412);
		

		personalinfo = new JPanel();
		personalinfo.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		personalinfo.setBounds(0, 31, 470, 380);
		personalinfo.setLayout(null);

		infor = new JLabel();
		infor.setText("Thông tin cá nhân");
		infor.setHorizontalTextPosition(SwingConstants.CENTER);
		infor.setFont(new Font("Arial", Font.BOLD, 14));
		infor.setHorizontalAlignment(SwingConstants.CENTER);
		infor.setBounds(139, 11, 227, 32);
		personalinfo.add(infor);
		lblFullname = new JLabel();
		lblFullname.setText("Họ và tên");
		lblFullname.setHorizontalAlignment(SwingConstants.LEFT);
		lblFullname.setBounds(52, 69, 68, 21);
		personalinfo.add(lblFullname);

		txtfullname = new JTextField();
		txtfullname.setBorder(null);
		txtfullname.setBounds(163, 66, 219, 27);
		personalinfo.add(txtfullname);
		txtfullname.setColumns(10);

		lblGender = new JLabel();
		lblGender.setText("Giới tính");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setBounds(52, 101, 68, 28);
		personalinfo.add(lblGender);

		rdbtnNam = new JRadioButton();
		rdbtnNam.setText("Nam");
		rdbtnNam.setBounds(173, 106, 60, 23);
		personalinfo.add(rdbtnNam);
		rdbtnNam.setSelected(true);

		rdbtnN = new JRadioButton();
		rdbtnN.setText("Nữ");
		rdbtnN.setBounds(245, 104, 68, 23);
		personalinfo.add(rdbtnN);

		rdbtnkhac = new JRadioButton();
		rdbtnkhac.setText("Khác");
		rdbtnkhac.setBounds(314, 104, 68, 23);
		personalinfo.add(rdbtnkhac);

		group = new ButtonGroup();
		group.add(rdbtnNam);
		group.add(rdbtnN);
		group.add(rdbtnkhac);

		lbldob = new JLabel();
		lbldob.setText("Ngày sinh");
		lbldob.setHorizontalAlignment(SwingConstants.LEFT);
		lbldob.setBounds(52, 140, 77, 24);
		personalinfo.add(lbldob);

		/*
		 * String year[] = new String[150]; for (int j = 0; j <= 100; j++) for (int i =
		 * 1920; i <= 2020; i++) { year[j] = new StringBuffer().append(i).toString(); }
		 */
		/*
		 * String year[] = { "1920", "1921", "1922", "1923", "1924", "1925", "1926",
		 * "1927", "1928","1929", "1930", "1931", "1932", "1933", "1934", "1935",
		 * "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944",
		 * "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953",
		 * "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962",
		 * "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971",
		 * "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980",
		 * "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
		 * "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
		 * "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007",
		 * "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
		 * "2017", "2018", "2019"};
		 */
		textAreaadd = new JTextArea();
		textAreaadd.setBounds(163, 188, 219, 60);
		personalinfo.add(textAreaadd);

		lbldiachi = new JLabel();
		lbldiachi.setText("Địa chỉ");
		lbldiachi.setHorizontalAlignment(SwingConstants.LEFT);
		lbldiachi.setBounds(52, 197, 60, 21);
		personalinfo.add(lbldiachi);
		frmDangki.getContentPane().add(personalinfo);

		lblSdt = new JLabel();
		lblSdt.setText("Số điện thoại");
		lblSdt.setBounds(52, 272, 77, 21);
		personalinfo.add(lblSdt);

		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBorder(null);
		txtsdt.setBounds(163, 270, 219, 27);
		personalinfo.add(txtsdt);

		txtdob = new JTextField();
		txtdob.setBorder(null);
		txtdob.setText("yyyy-MM-DD");
		txtdob.setBounds(163, 142, 219, 27);
		personalinfo.add(txtdob);
		txtdob.setColumns(10);

		account = new JPanel();
		account.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		account.setBorder(new MatteBorder(0, 3, 0, 0, (Color) new Color(0, 0, 0)));
		account.setBounds(470, 31, 370, 380);
		frmDangki.getContentPane().add(account);
		account.setLayout(null);

		lblusername = new JLabel();
		lblusername.setText("Tên đăng nhập");
		lblusername.setHorizontalAlignment(SwingConstants.LEFT);
		lblusername.setBounds(10, 65, 91, 27);
		account.add(lblusername);

		txtusername = new JTextField();
		txtusername.setBorder(null);
		txtusername.setBounds(133, 65, 180, 27);
		account.add(txtusername);
		txtusername.setColumns(10);

		lblpass = new JLabel();
		lblpass.setText("Mật khẩu");
		lblpass.setHorizontalAlignment(SwingConstants.LEFT);
		lblpass.setBounds(10, 126, 66, 22);
		account.add(lblpass);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBounds(133, 124, 180, 27);
		account.add(passwordField);

		lblrepass = new JLabel();
		lblrepass.setText("Nhập lại mật khẩu");
		lblrepass.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepass.setBounds(10, 183, 113, 27);
		account.add(lblrepass);

		repasswordField = new JPasswordField();
		repasswordField.setBorder(null);
		repasswordField.setBounds(133, 183, 180, 27);
		account.add(repasswordField);

		btnregister = new JButton();
		btnregister.setText("Đăng kí");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtusername.getText();
				// String password = passwordField.getText();
				String fullname = txtfullname.getText();
				// String gender = group.getSelection().getActionCommand();
				String Gender = getSelectedButtonText(group);
				// String Gender = group.getSelection().getText().ToString();
				// cai nao đc chọn trong 3 cái radiobutton male female...
				// String Dob = cbyear.getSelectedItem().toString() + "-" +
				// cbmonth.getSelectedItem().toString()+ "-" +
				// cbDay.getSelectedItem().toString() ;
				// java.util.Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(Dob);
				String Dob = txtdob.getText();
				java.util.Date  dob = null;
					try {
						dob = new SimpleDateFormat("dd/MM/yyyy").parse(Dob);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				String phonenumber = txtsdt.getText();
				String address = textAreaadd.getText();

				char getpass[], getrepass[];
				String pass = "";
				String repass = "";
				getpass = passwordField.getPassword();
				getrepass = repasswordField.getPassword();

				repass = String.valueOf(getrepass);
				pass = String.valueOf(getpass);

				if (txtfullname.getText() != null && group.getSelection() != null && txtdob != null
						&& txtsdt.getText() != null && textAreaadd.getText() != null && txtusername.getText() != null
						&& pass != null && repass != null) {
					if (pass.equals(repass)) {
						try {
							String sql = "insert into HoDan(Username, iPassword, Fullname, Gender, PhoneNumber, iAddress,  Dob) values ( ?, ?, ?, ?, ?, ?, ?)";
							PreparedStatement pre = connect.prepareStatement(sql);
							pre.setString(1, username);
							pre.setString(2, pass);
							pre.setString(3, fullname);
							pre.setString(4, Gender);
							pre.setString(5, phonenumber);
							pre.setString(6, address);
							pre.setString(7, Dob);
							pre.execute();
							JOptionPane.showMessageDialog(null, "Successfull Register!");
							Hodan user = new Hodan(username,pass,fullname,Dob,Gender,phonenumber,address);
							Dashboard db = new Dashboard(user);
							db.setVisible(true);
							pre.close();

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "System Error!" + ex);
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Password doesn't match with repassword! Please check again");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill out all the fields!");
				}
			}

		});

		btnregister.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnregister.setBorder(null);
		btnregister.setFont(new Font("Arial", Font.BOLD, 11));
		btnregister.setBounds(186, 270, 91, 27);
		account.add(btnregister);

		lblTiKhon = new JLabel();
		lblTiKhon.setText("Tài khoản");
		lblTiKhon.setFont(new Font("Arial", Font.BOLD, 14));
		lblTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiKhon.setBounds(151, 11, 100, 26);
		account.add(lblTiKhon);

		cbShowPassword = new JCheckBox("Show password");
		cbShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbShowPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);// hien thi mat khau
				} else {
					passwordField.setEchoChar('*');// khong chon showpass
				}
			}
		});
		cbShowPassword.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		cbShowPassword.setBorder(null);
		cbShowPassword.setBounds(133, 217, 144, 23);
		account.add(cbShowPassword);

		lbldangnhap = new JLabel();
		lbldangnhap.setText("Đăng nhập");
		lbldangnhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login logi = new login();
				logi.Show();
			}
		});
		lbldangnhap.setBounds(200, 355, 65, 14);
		account.add(lbldangnhap);

		pnlHeader = new JPanel();
		pnlHeader.setBackground(SystemColor.inactiveCaptionBorder);
		pnlHeader.setBounds(0, 0, 840, 31);
		pnlHeader.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pnlHeaderMousePressed(e);
			}
		});

		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				pnlHeaderMouseDragged(evt);
			}
		});
		frmDangki.getContentPane().add(pnlHeader);

		btnMaximize = new JButton();
		btnMaximize.setBorder(null);
		btnMaximize.setIcon(new ImageIcon(Register.class.getResource("/gambar/Minimize (2).png")));
		btnMaximize.setOpaque(true);
		btnMaximize.setFocusable(false);
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setBackground(SystemColor.inactiveCaptionBorder);
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMinimizeActionPerformed(evt);
			}
		});
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				btnMinimizeMouseEntered(m);
			}

			public void mouseExited(MouseEvent m) {
				btnMinimizeMouseExited(m);
			}
		});

		btnExit = new JButton();
		btnExit.setBorder(null);
		btnExit.setIcon(new ImageIcon(Register.class.getResource("/gambar/Exit.png")));
		btnExit.setOpaque(true);
		btnExit.setFocusable(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBackground(SystemColor.inactiveCaptionBorder);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				btnExitMouseEntered(m);
			}

			public void mouseExited(MouseEvent m) {
				btnExitMouseExited(m);
			}

		});

		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(gl_pnlHeader.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnlHeader.createSequentialGroup().addContainerGap(735, Short.MAX_VALUE)
						.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)));
		gl_pnlHeader.setVerticalGroup(gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnMaximize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE));
		pnlHeader.setLayout(gl_pnlHeader);

	}

	String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (@SuppressWarnings("rawtypes")
		Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(new Color(255, 255, 255));
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		//System.exit(0);
		frmDangki.setVisible(false);
	}

	private void btnMinimizeMouseEntered(MouseEvent evt) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMinimizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(new Color(255, 255, 255));
	}

	private void btnMinimizeActionPerformed(ActionEvent evt) {
		frmDangki.setState(Frame.ICONIFIED);
	}

	private void pnlHeaderMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void pnlHeaderMouseDragged(MouseEvent evt) {
		if (maximize) {
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			frmDangki.setLocation(x - xMouse, y - yMouse);
		}
	}

	public void Show() {
		// TODO Auto-generated method stub
		//frmDangki.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDangki.setVisible(true);
	}
}

/**
 * Initialize the contents of the frame.
 */

/*
 * class RoundedBorder implements Border {
 * 
 * private int radius;
 * 
 * 
 * RoundedBorder(int radius) { this.radius = radius; }
 * 
 * 
 * public Insets getBorderInsets(Component c) { return new Insets(this.radius +
 * 1, this.radius+1, this.radius + 2, this.radius); }
 * 
 * 
 * public boolean isBorderOpaque() { return true; }
 * 
 * 
 * public void paintBorder(Component c, Graphics g, int x, int y, int width, int
 * height) { g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); } }
 */