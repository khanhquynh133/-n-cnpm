package CNPM.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class EditInfo extends JFrame {
	JPanel pnlHeader;
	JButton btnExit, btnMinimize, btnMaximize;
	static boolean maximized = true;
	int xMouse, yMouse;
	private JPanel panel;
	private JPanel Panel_info;
	private JPanel panel_Show;
	private DefaultTableModel tablemodel;
	private JTable table;
	private JTextField txtFullname, txtDob, txtAddress, txtSdt, txtUsername;
	private JPasswordField passwordField;
	private JButton btnDelete, btnAdd, btnUpdate;
	private JLabel lblFullname, lblDob, lblAddress, lblUsername, lblPassword, lblGender, lblPhone;
	private JRadioButton rdbtnNam, rdbtnNu, rdbtnKhac;
	private ButtonGroup groupGender;
	Connection connect = null;
	PreparedStatement pre;
	ResultSet rs;
	Statement sta;
	private JButton btnXem;

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EditInfo().setVisible(true);
			}
		});
	}

	public EditInfo() {
		try {
			connect = Connect_DB.getSQLServer();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		initComponent();

	}
	public EditInfo(ArrayList<Hodan> user) {
		//Hodan hodan;
		for(Hodan hodan: user) {
			txtFullname.setText(hodan.getFullname());
			txtAddress.setText(hodan.getAddress());
			txtDob.setText(hodan.getDob());
			txtSdt.setText(hodan.getPhonenumber());
			txtUsername.setText(hodan.getUsername());
			passwordField.setText(hodan.getPassword());
			String gender = hodan.getGender();
			getButton(gender).setSelected(true);
			
			//groupGender.setSelected(m, b);
			
		}
		
	}
	

	// ViewSelectedRowJFrame viewSelectedRow = new ViewSelectedRowJFrame();
	// SelectedRowsJFrameForm selectedRowsJFrameForm = new SelectedRowsJFrameForm();
	private void initComponent() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Edit Pesonal Information");
		getContentPane().setBackground(SystemColor.activeCaption);
		pnlHeader = new JPanel();
		pnlHeader.setBackground(SystemColor.inactiveCaptionBorder);
		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent m) {
				pnlHeaderMouseDragged(m);
			}
		});
		pnlHeader.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent m) {
				pnlHeaderMousePressed(m);
			}
		});

		btnMinimize = new JButton();
		btnMinimize.setBorder(null);
		btnMinimize.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/Minimize (2).png")));
		btnMinimize.setOpaque(true);
		btnMinimize.setFocusable(false);
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBackground(SystemColor.inactiveCaptionBorder);
		btnMinimize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMinimizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMinimizeMouseExited(evt);
			}
		});
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMinimizeActionPerformed(evt);
			}
		});
		btnMaximize = new JButton();
		btnMaximize.setBorder(null);
		btnMaximize.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/Maximize (2).png")));
		btnMaximize.setOpaque(true);
		btnMaximize.setFocusable(false);
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setBackground(SystemColor.inactiveCaptionBorder);
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				btnMaximizeMouseEntered(m);
			}

			public void mouseExited(MouseEvent m) {
				btnMaximizeMouseExited(m);
			}

		});
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMaximizeActionPerformed(evt);
			}
		});

		btnExit = new JButton();
		btnExit.setBorder(null);
		btnExit.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/Exit.png")));
		btnExit.setOpaque(true);
		btnExit.setFocusable(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnExitMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnExitMouseExited(evt);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});

		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlHeader.createSequentialGroup().addContainerGap(572, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)));
		gl_pnlHeader.setVerticalGroup(gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnMinimize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(btnMaximize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE));
		pnlHeader.setLayout(gl_pnlHeader);

		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		Panel_info = new JPanel();
		Panel_info.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		Panel_info.setBackground(UIManager.getColor("inactiveCaption"));

		panel_Show = new JPanel();
		panel_Show.setBorder(null);
		panel_Show.setBackground(SystemColor.inactiveCaption);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(Panel_info, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(455, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup().addGap(434).addComponent(panel_Show,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_Show, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
								.addComponent(Panel_info, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
						.addContainerGap()));

		lblFullname = new JLabel();
		lblFullname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblFullname.setText("Họ và tên");

		lblGender = new JLabel();
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblGender.setText("Giới tính");

		lblDob = new JLabel();
		lblDob.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDob.setText("Ngày sinh");

		lblAddress = new JLabel();
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAddress.setText("Địa chỉ");

		lblPhone = new JLabel();
		lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPhone.setText("Số điện thoại");

		lblUsername = new JLabel();
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUsername.setText("Tên đăng nhập");

		lblPassword = new JLabel();
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPassword.setText("Mật khẩu");

		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBorder(null);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(UIManager.getColor("inactiveCaption"));

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(UIManager.getColor("inactiveCaption"));

		rdbtnKhac = new JRadioButton("Khác");
		rdbtnKhac.setBackground(UIManager.getColor("inactiveCaption"));
		groupGender = new ButtonGroup();
		groupGender.add(rdbtnNu);
		groupGender.add(rdbtnNam);
		groupGender.add(rdbtnKhac);

		txtDob = new JTextField();
		txtDob.setColumns(10);
		txtDob.setBorder(null);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBorder(null);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBorder(null);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);

		passwordField = new JPasswordField();

		btnUpdate = new JButton();
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		btnUpdate.setText("Cập nhật");
		btnUpdate.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		btnUpdate.setBorder(null);

		btnAdd = new JButton();
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = txtUsername.getText();
				String fullname = txtFullname.getText();
				String Gender = getSelectedButtonText(groupGender);
				String Dob = txtDob.getText();
				String phonenumber = txtSdt.getText();
				String address = txtAddress.getText();

				char getpass[];
				String pass = "";
				getpass = passwordField.getPassword();
				pass = String.valueOf(getpass);
				String role = "Ho dan"; 

				if (txtFullname.getText() != null && groupGender.getSelection() != null && txtDob != null
						&& txtSdt.getText() != null && txtAddress.getText() != null && txtUsername.getText() != null
						&& pass != null) {

					try {
						String sql = "insert into Person(Username, iPassword, Fullname, Gender, PhoneNumber, iAddress,  Dob, irole) values ( ?, ?, ?, ?, ?, ?, ?, ?)";
						pre = connect.prepareStatement(sql);
						Hodan user;
						ArrayList<Hodan> userlist = new ArrayList<Hodan>();
						user = new Hodan(username, pass, fullname, Gender, phonenumber, address, Dob, role);
						userlist.add(user);
						
						pre.setString(1, userlist.get(0).getUsername());
						pre.setString(2, userlist.get(0).getPassword());
						pre.setString(3, userlist.get(0).getFullname());
						pre.setString(4, userlist.get(0).getGender());
						pre.setString(5, userlist.get(0).getPhonenumber());
						pre.setString(6, userlist.get(0).getAddress());
						pre.setString(7, userlist.get(0).getDob());
						pre.setString(8, userlist.get(0).getRole());
						
						pre.execute();
						JOptionPane.showMessageDialog(null, "Successfully!");
						tablemodel.setRowCount(0);
						Show_userlist();
						pre.close();

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "System Error!" + ex);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill out all the fields!");
				}
			}
		});
		btnAdd.setText("Thêm");
		btnAdd.setBorder(null);
		btnAdd.setBackground(SystemColor.activeCaption);

		btnDelete = new JButton();
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				String ID = model.getValueAt(1, 0).toString();
				fillTextfield();
				try {
					String sql1 = "Delete from Person where idHodan = '" + ID + "'";
					pre = connect.prepareStatement(sql1);
					pre.execute();
					
					JOptionPane.showMessageDialog(null, "Delete sucessfully!");
					tablemodel.setRowCount(0);
					Show_userlist();
					pre.close();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnDelete.setText("Xóa");
		btnDelete.setBorder(null);
		btnDelete.setBackground(SystemColor.activeCaption);

		btnXem = new JButton();
		btnXem.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnXem.addActionListener(new ActionListener() {
			private int clicked;

			public void actionPerformed(ActionEvent e) {
				Show_userlist();
				clicked++;
				if (clicked > 1) {
					tablemodel.setRowCount(0);
					Show_userlist();
				}
			}
		});
		btnXem.setText("Xem");
		btnXem.setBorder(null);
		btnXem.setBackground(SystemColor.activeCaption);
		
		JButton btnHy = new JButton();
		btnHy.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFullname.setText("");
				txtSdt.setText("");
				txtAddress.setText("");
				txtDob.setText("");
				txtUsername.setText("");
				passwordField.setText("");
				rdbtnKhac.setSelected(false);
				rdbtnNam.setSelected(false);
				rdbtnNu.setSelected(false);
				
			}
		});
		btnHy.setText("Hủy");
		btnHy.setBorder(null);
		btnHy.setBackground(SystemColor.activeCaption);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					passwordField.setEchoChar((char)0);
			}
		});
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/icons8-eye-24.png")));
		GroupLayout gl_Panel_info = new GroupLayout(Panel_info);
		gl_Panel_info.setHorizontalGroup(
			gl_Panel_info.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Panel_info.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblFullname, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(lblPhone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDob, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Panel_info.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_Panel_info.createSequentialGroup()
								.addComponent(rdbtnNam, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnNu, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(rdbtnKhac, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_info.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(gl_Panel_info.createSequentialGroup()
					.addGap(30)
					.addComponent(btnXem, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHy, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		gl_Panel_info.setVerticalGroup(
			gl_Panel_info.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_info.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFullname, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnKhac)
						.addComponent(rdbtnNu)
						.addComponent(rdbtnNam))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDob, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_Panel_info.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXem, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHy, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Panel_info.setLayout(gl_Panel_info);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));

		GroupLayout gl_panel_Show = new GroupLayout(panel_Show);
		gl_panel_Show.setHorizontalGroup(
			gl_panel_Show.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Show.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
					.addGap(13))
		);
		gl_panel_Show.setVerticalGroup(
			gl_panel_Show.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Show.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		
		tablemodel = new DefaultTableModel(); 
		table = new JTable(tablemodel);
		table.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fillTextfield();
		
			}
		});
		tablemodel.addColumn("ID");
		tablemodel.addColumn("Tên đăng nhập");
		tablemodel.addColumn("Mật khẩu");
		tablemodel.addColumn("Họ và tên");
		tablemodel.addColumn("Giới tính");
		tablemodel.addColumn("Số điện thoại");
		tablemodel.addColumn("Địa chỉ");
		tablemodel.addColumn("Ngày sinh");

		scrollPane.setViewportView(table);

		panel_Show.setLayout(gl_panel_Show);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
				.addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(panel,
										GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
								.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(0)));
		getContentPane().setLayout(groupLayout);
		initComponents();

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

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 478);
		setUndecorated(true);
	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

	private void btnMaximizeMouseEntered(MouseEvent m) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMaximizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMaximizeActionPerformed(ActionEvent evt) {
		if (maximized) {

			EditInfo.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			EditInfo.this.setMaximizedBounds(env.getMaximumWindowBounds());
			maximized = false;
		} else {
			setExtendedState(JFrame.NORMAL);
			maximized = true;
		}
	}

	private void btnMinimizeMouseEntered(MouseEvent evt) {
		btnMinimize.setBackground(new Color(229, 229, 229));
	}

	private void btnMinimizeMouseExited(MouseEvent evt) {
		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMinimizeActionPerformed(ActionEvent evt) {
		this.setState(Frame.ICONIFIED);
	}

	private void pnlHeaderMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void pnlHeaderMouseDragged(MouseEvent evt) {
		if (maximized) {
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			this.setLocation(x - xMouse, y - yMouse);
		}
	}

	public void UpdateTable() {
		String sql = "select * from Person";
		try {
			pre = connect.prepareStatement(sql);
			rs = pre.executeQuery();

		} catch (Exception ex) {

		}

	}
// where irole like 'Ho dan'
	public ArrayList<Hodan> UserList() {
		ArrayList<Hodan> user = new ArrayList<Hodan>();
		try {
			String sql = "select idHoDan, Username, iPassword, Fullname, Gender, PhoneNumber, iAddress, Dob from Person where irole like 'Ho dan' ";
			sta = connect.createStatement();
			rs = sta.executeQuery(sql);
			Hodan userlist;
			while (rs.next()) {
				userlist = new Hodan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
				user.add(userlist);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return user;
	}

	public void Show_userlist() {
		ArrayList<Hodan> list = UserList();
		tablemodel = (DefaultTableModel) table.getModel();

		Object[] row = new Object[8];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getIdHodan();
			row[1] = list.get(i).getUsername();
			row[2] = list.get(i).getPassword();
			row[3] = list.get(i).getFullname();
			row[4] = list.get(i).getGender();
			row[5] = list.get(i).getPhonenumber();
			row[6] = list.get(i).getAddress();
			row[7] = list.get(i).getDob();
			tablemodel.addRow(row); // them du lieu hang
		}
	}

	public JRadioButton getButton(String Text) {
		switch (Text) {
		case "Nữ":
			return rdbtnNu;
		case "Nam":
			return rdbtnNam;
		}
		return rdbtnKhac;

	}
	public ArrayList<Hodan> FindHodan(int idHodan){
		ArrayList<Hodan> userlist = new ArrayList<Hodan>();
		Hodan user;
		int row = table.getSelectedRow();
		user = new Hodan((String)table.getValueAt(row,0), (String)table.getValueAt(row,1), (String)table.getValueAt(row,2), 
				(String)table.getValueAt(row,3), (String)table.getValueAt(row,4), (String)table.getValueAt(row,5), 
				(String)table.getValueAt(row,6), (String)table.getValueAt(row,7));
		
		userlist.add(user);
		
		return userlist;
	}
	
	
	public void fillTextfield() {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		txtFullname.setText(model.getValueAt(i, 3).toString());
		txtAddress.setText(model.getValueAt(i, 6).toString());
		txtUsername.setText(model.getValueAt(i, 1).toString());
		txtSdt.setText(model.getValueAt(i, 5).toString());
		txtDob.setText(model.getValueAt(i, 7).toString());
		String gender = model.getValueAt(i, 4).toString();
		String password  = model.getValueAt(i, 2).toString();
		passwordField.setText(password);
		
		if(gender.equals("Nam")) {
			rdbtnNam.setSelected(true);
		}
		else if(gender.equals("Nữ")) {
			rdbtnNu.setSelected(true);
		}
		else {
			rdbtnKhac.setSelected(true);
		}
		
	}
	public void updateData() {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		int ID = Integer.parseInt(model.getValueAt(i, 0).toString());
		String fullname = txtFullname.getText();
		String username = txtUsername.getText();
		String sdt = txtSdt.getText();
		String gender = getSelectedButtonText(groupGender);
		String address = txtAddress.getText();
		char getpass[];
		String pass = "";
		getpass = passwordField.getPassword();
		pass = String.valueOf(getpass);
		try {
		String sql = "update Person set Username = ?, iPassword = ?, Fullname = ?, Gender = ?, PhoneNumber = ?, iAddress = ? where idHodan = " + ID;
		
		pre = connect.prepareStatement(sql);
		
		pre.setString(1, username);
		pre.setString(2, pass);
		pre.setString(3, fullname);
		pre.setString(4, gender);
		pre.setString(5, sdt);
		pre.setString(6, address);
		
		pre.execute();
		
		JOptionPane.showMessageDialog(null, "Update successfully");
		tablemodel.setRowCount(0);
		Show_userlist();
		
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Can not update!");
		}
		
	}
}