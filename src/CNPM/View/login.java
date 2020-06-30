package CNPM.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;

import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;

import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;

public class login {

	private JFrame frmLogin;

	private JButton btnExitt, btnminimize, btnlogin, btncancel;

	static boolean maximized = true;
	int xMouse, yMouse;
	Connection connect = null;

	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblNewLabel, lblsignin, lblusername, lblmatkhau, lblnewacc;
	private JCheckBox chckbxShowPassword;
	private JPanel panel, pnlHeader;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public login() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setBounds(342, 192, 700, 350);// getContentPane().
		frmLogin.setTitle("Đăng nhập");
		frmLogin.getContentPane().setBackground(SystemColor.activeCaption);
		frmLogin.setUndecorated(true);
//		frmLogin.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/gambar/people.png")));

		lblsignin = new JLabel();
		lblsignin.setForeground(Color.WHITE);
		lblsignin.setText("Đăng nhập");
		lblsignin.setBackground(Color.LIGHT_GRAY);
		lblsignin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblsignin.setHorizontalAlignment(SwingConstants.CENTER);

		lblusername = new JLabel();
		lblusername.setForeground(Color.WHITE);
		lblusername.setText("Tên đăng nhập");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);

		lblmatkhau = new JLabel();
		lblmatkhau.setForeground(Color.WHITE);
		lblmatkhau.setText("Mật khẩu");
		lblmatkhau.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblmatkhau.setHorizontalAlignment(SwingConstants.CENTER);

		btnlogin = new JButton();
		btnlogin.setText("Đăng nhập");
		btnlogin.setFocusable(false);
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 16)); // NOI18N
		
		btnlogin.setForeground(Color.WHITE);
		btnlogin.setContentAreaFilled(false);
		btnlogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "select * from dbo.Person where Username = ? and iPassword= ?";
					PreparedStatement pre = connect.prepareStatement(url);
					Hodan user = null;
					char getpass[];
					String password = "";
					getpass = passwordField.getPassword();
					password = String.valueOf(getpass);

					pre.setString(1, txtUsername.getText());
					pre.setString(2, password);
					ResultSet rs = pre.executeQuery();
					int count = 0;
					while (rs.next()) {
						count++;
						int idUser = rs.getInt("idUser");
						String Username = rs.getString("Username");
						String iPassword = rs.getString("iPassword");
						String Fullname = rs.getString("Fullname");
						String Gender = rs.getString("Gender");
						String PhoneNumber = rs.getString("PhoneNumber");
						String iAddress = rs.getString("iAddress");
						String date =  rs.getString("Dob");
						String irole = rs.getString("irole");
						//String iVatnuoi = rs.getString("iVatnuoi");
						user = new Hodan(idUser,Username,iPassword,Fullname,date,Gender,PhoneNumber,iAddress,irole);

					}
					if (count >0) {
						Dashboard db = new Dashboard(user);
						db.setVisible(true);
						frmLogin.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect username/password!");
					}
					rs.close();
					pre.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "System error! " + ex);
				}
			}
		});

		btnlogin.setBackground(new Color(255, 255, 255));
		btnlogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		
		btnlogin.setFont(new Font("Segoe UI", Font.BOLD, 12));

		btncancel = new JButton();
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false);
			}
		});
		btncancel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		btncancel.setText("Hủy");
		btncancel.setFocusable(false);
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 12)); // NOI18N
		btncancel.setForeground(Color.WHITE);
		btncancel.setContentAreaFilled(false);
		btncancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblnewacc = new JLabel();
		lblnewacc.setForeground(Color.WHITE);
		lblnewacc.setText("Đăng kí tài khoản mới");
		lblnewacc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblnewacc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLogin.dispose();
				Register regist = new Register();
				regist.Show();

			}
		});
		lblnewacc.setHorizontalAlignment(SwingConstants.CENTER);

		chckbxShowPassword = new JCheckBox("Show password");
		chckbxShowPassword.setForeground(Color.WHITE);
		chckbxShowPassword.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});

		pnlHeader = new JPanel();
		pnlHeader.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				pnlHeaderMouseDragged(evt);
			}
		});
		pnlHeader.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				pnlHeaderMousePressed(evt);
			}
		});
		btnExitt = new JButton();
		btnExitt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExitt.setBorder(null);

		btnminimize = new JButton();
		btnminimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnminimize.setBorder(null);
		btnminimize.setOpaque(true);
		btnminimize.setFocusable(false);
		btnminimize.setContentAreaFilled(false);
		//btnminimize.setBackground(Color.WHITE);
		
		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(
			gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlHeader.createSequentialGroup()
					.addContainerGap(580, Short.MAX_VALUE)
					.addComponent(btnminimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExitt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnlHeader.setVerticalGroup(
			gl_pnlHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHeader.createSequentialGroup()
					.addGroup(gl_pnlHeader.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExitt, 0, 0, Short.MAX_VALUE)
						.addComponent(btnminimize, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlHeader.setLayout(gl_pnlHeader);
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(22)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(82).addComponent(lblsignin,
								GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblusername, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblmatkhau, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addGap(34).addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 184,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(106).addComponent(chckbxShowPassword,
								GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(65)
								.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGap(33)
								.addComponent(btncancel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(102).addComponent(lblnewacc,
								GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
				.addGap(49).addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblsignin, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE).addGap(20)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(lblusername,
										GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblmatkhau, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE))
						.addGap(23).addComponent(chckbxShowPassword).addGap(22)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(1).addComponent(btnlogin,
										GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addComponent(btncancel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(10).addComponent(lblnewacc, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))));
		panel.setLayout(gl_panel);

		frmLogin.getContentPane().setLayout(groupLayout);

		btnExitt.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnExitt.setIcon(new ImageIcon(login.class.getResource("/gambar/Exit.png"))); // NOI18N
		btnExitt.setContentAreaFilled(false);
		btnExitt.setFocusable(false);
		btnExitt.setOpaque(true);
		btnExitt.setRolloverIcon(null); // NOI18N
		btnExitt.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnExitMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnExitMouseExited(evt);
			}
		});
		btnExitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});

		btnminimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnminimize.setIcon(new ImageIcon(login.class.getResource("/gambar/Minimize (2).png"))); // NOI18N
		btnminimize.setContentAreaFilled(false);
		btnminimize.setFocusable(false);
		btnminimize.setOpaque(true);
		btnminimize.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Minimize (2).png")));
		btnminimize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMinimizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMinimizeMouseExited(evt);
			}
		});
		btnminimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMinimizeActionPerformed(evt);
			}
		});

	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExitt.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExitt.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		//System.exit(0);
		frmLogin.setVisible(false);
	}

	private void btnMinimizeMouseEntered(MouseEvent evt) {
		btnminimize.setBackground(new Color(229, 229, 229));
	}

	private void btnMinimizeMouseExited(MouseEvent evt) {
		btnminimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMinimizeActionPerformed(ActionEvent evt) {
		frmLogin.setState(Frame.ICONIFIED);
	}

	private void pnlHeaderMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void pnlHeaderMouseDragged(MouseEvent evt) {
		if (maximized) {
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			frmLogin.setLocation(x - xMouse, y - yMouse);
		}
	}

	public void Show() {
		//frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setVisible(true);

	}
}
