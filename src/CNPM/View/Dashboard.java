
package CNPM.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.MatteBorder;

import CNPM.View.QuanLiHoDan;
import CNPM.View.Xemlichtiem;
import CNPM.View.HomePage;
import CNPM.View.RegisterTiem;
import CNPM.Model.Connect_DB;
import CNPM.Model.Hodan;

@SuppressWarnings("serial")
public class Dashboard extends JFrame 
{

	static boolean maximized = true;
	Connection conn = null;
	int xMouse;
	int yMouse;
	Hodan user;
	 int flag =0;

	private JButton btnExit, btnMaximize, btnMinimize, btnNews, btnTimeline;
	private JLabel fullname, jLabel12, jLabel13, jLabel17, jLabel6, jLabel7, jLabel8, jLabel9, lblNewLabel, lblNews,
			lblTimeline, lblfullname, label_1;
	private JPanel jPanel1, jPanel2, jPanel3, jPanel4, pnlBody, pnlHeader, pnlMenu, pnlNews, pnlTimeline, panel;
	private JScrollPane jspTimeline, jspNews;
	private GroupLayout pnlHeaderLayout, pnlMenuLayout, jPanel1Layout, jPanel2Layout, jPanel3Layout, jPanel4Layout,
			pnlTimelineLayout, layout, gl_panel, pnlNewsLayout;
	private JSeparator separator;
	private JPanel jPanel4_1;
	private JLabel lblQunLH;
	private JLabel lblNewLabel_2;
	

	public Dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/gambar/dashboard (2).png")));
		getContentPane().setBackground(SystemColor.activeCaption);
		initComponents();
	}
	
	//Edit by Trang
	public Dashboard(Hodan user) {
		this.user = user;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/gambar/dashboard (2).png")));
		getContentPane().setBackground(SystemColor.activeCaption);
		initComponents();
		//String fullName = getFullName(u);
		fullname.setText(user.getFullname());
	}
	


	private void initComponents() {

		pnlHeader = new JPanel();
		btnExit = new JButton();
		btnMaximize = new JButton();
		btnMinimize = new JButton();
		pnlMenu = new JPanel();
		btnTimeline = new JButton();
		btnTimeline.setText("BẢNG ĐIỀU KHIỂN");
		lblTimeline = new JLabel();
		btnNews = new JButton();
		lblNews = new JLabel();
		jLabel17 = new JLabel();
		
//dangxuat		
		jLabel17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage home = new HomePage();
				home.setVisible(true);
				}
		});
		
		fullname = new JLabel();
		fullname.setHorizontalAlignment(SwingConstants.CENTER);
		fullname.setFont(new Font("Arial", Font.BOLD, 17));
		pnlBody = new JPanel();
		jspTimeline = new JScrollPane();
		pnlTimeline = new JPanel();
		jPanel1 = new JPanel();
//THÔNG TIN
		jPanel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag == 0) {
					QuanLiHoDan ql = new QuanLiHoDan(user);
					ql.setVisible(true);
					flag =1;
				}
				else {
					try {
						conn = Connect_DB.getSQLServer();
						user = Hodan.getHDByID(user.getIdHodan(), conn);
						QuanLiHoDan ql = new QuanLiHoDan(user);
						ql.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		jPanel1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		jPanel1.setBackground(new Color(212, 233, 238));
		//jPanel1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		//jPanel1.setBackground(new Color(212, 233, 238));
		jLabel6 = new JLabel();
		jPanel2 = new JPanel();
//ĐĂNG KÍ TIÊM
		jPanel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hodan userClone = user;
				//if (userClone.getRole().compareTo("Hộ dân")==0)
				//{
				RegisterTiem rgTiem = new RegisterTiem(userClone);
				rgTiem.setVisible(true);
				rgTiem.setTitle("Đăng kí tiêm");
				rgTiem.setLocationRelativeTo(null);
			//	}
			//	else
			//	{
			//		jPanel2.setEnabled(false);
					
			//	}
			}
		});
		
		jPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 153)));
		jPanel2.setBackground(new Color(212, 233, 238));
		jLabel7 = new JLabel();
		jPanel3 = new JPanel();
//XEM LỊCH TIÊM
		jPanel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
					Hodan userClone = user;
					//if (userClone.getRole().compareTo("Hộ dân")==0)
				//{
						Xemlichtiem schedule = new Xemlichtiem(userClone);
						schedule.setVisible(true);
						schedule.setTitle("Xem lịch tiêm");
						schedule.setLocationRelativeTo(null);
					//}
					//else
					//{
					//	jPanel2.setEnabled(false);
						
					//}
			}
		});
		jPanel3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 204)));
		jPanel3.setBackground(new Color(212, 233, 238));
		jLabel8 = new JLabel();
		jLabel13 = new JLabel();
		jPanel4 = new JPanel();
		jPanel4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		jLabel9 = new JLabel();
		pnlNews = new JPanel();
		pnlNews.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Dashboard");
		setUndecorated(true);
		setSize(new Dimension(1000, 600));

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

		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnExit.setIcon(new ImageIcon(getClass().getResource("/gambar/Exit.png")));
		btnExit.setContentAreaFilled(false);
		btnExit.setFocusable(false);
		btnExit.setOpaque(true);
		btnExit.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Exit (2).png")));

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

		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMaximize.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/Maximize (2).png")));
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setFocusable(false);
		btnMaximize.setOpaque(true);
		btnMaximize.setRolloverIcon(new ImageIcon(getClass().getResource("/Gambar/Maximize (2).png")));
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMaximizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMaximizeMouseExited(evt);
			}
		});
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMaximizeActionPerformed(evt);
			}
		});

		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMinimize.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/Minimize (2).png")));
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setFocusable(false);
		btnMinimize.setOpaque(true);
		btnMinimize.setRolloverIcon(new ImageIcon(getClass().getResource("/gambar/Minimize (2).png")));
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

		pnlHeaderLayout = new GroupLayout(pnlHeader);
		pnlHeaderLayout.setHorizontalGroup(
			pnlHeaderLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(pnlHeaderLayout.createSequentialGroup()
					.addContainerGap(839, Short.MAX_VALUE)
					.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit))
		);
		pnlHeaderLayout.setVerticalGroup(
			pnlHeaderLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
					.addGroup(pnlHeaderLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnMaximize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(btnMinimize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		pnlHeader.setLayout(pnlHeaderLayout);

		pnlMenu.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		btnTimeline.setFont(new Font("Arial", Font.BOLD, 16));
		btnTimeline.setForeground(new Color(44, 62, 80));
		btnTimeline.setContentAreaFilled(false);
		btnTimeline.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTimeline.setFocusable(false);
		btnTimeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnTimelineActionPerformed(evt);
			}
		});

		lblTimeline.setBackground(new Color(0, 102, 153));
		lblTimeline.setOpaque(true);

		btnNews.setFont(new Font("Arial", Font.BOLD, 16));
		btnNews.setForeground(new Color(44, 62, 80));
		btnNews.setText("TIN TỨC");
		btnNews.setContentAreaFilled(false);
		btnNews.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNews.setFocusable(false);
		btnNews.setPreferredSize(new Dimension(100, 27));
		btnNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnNewsActionPerformed(evt);
			}
		});

		lblNews.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		lblNews.setOpaque(true);
		pnlBody.add(pnlNews, "card4");
		
		jLabel17.setFont(new Font("Segoe UI", 0, 14));
		jLabel17.setForeground(new Color(52, 152, 219));
		jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel17.setText("Đăng xuất");
		jLabel17.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblfullname = new JLabel("TÀI KHOẢN");
		lblfullname.setFont(new Font("Arial", Font.BOLD, 17));

		pnlMenuLayout = new GroupLayout(pnlMenu);
		pnlMenuLayout.setHorizontalGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING).addGroup(pnlMenuLayout
				.createSequentialGroup().addGap(18).addComponent(lblfullname)
				.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						pnlMenuLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblTimeline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnTimeline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(60)
								.addGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNews, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(pnlMenuLayout.createSequentialGroup().addGap(18)
								.addComponent(fullname, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 538, Short.MAX_VALUE)
								.addComponent(jLabel17).addGap(18)))));
		pnlMenuLayout.setVerticalGroup(pnlMenuLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnlMenuLayout.createSequentialGroup()
						.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(pnlMenuLayout.createSequentialGroup().addGap(10).addComponent(jLabel17)
										.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										pnlMenuLayout.createSequentialGroup().addGap(12)
												.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(fullname, GroupLayout.PREFERRED_SIZE, 26,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblfullname))))
						.addGroup(pnlMenuLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnTimeline)
								.addComponent(btnNews, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(pnlMenuLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTimeline, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))));
		pnlMenu.setLayout(pnlMenuLayout);

		pnlBody.setLayout(new CardLayout());

		jspTimeline.setBorder(null);
		jspTimeline.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnlTimeline.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		//jPanel1.setBackground(new Color(157, 182, 212));
		jPanel1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		//jLabel6.setBackground(new Color(92, 118, 169));
		jLabel6.setBackground(new Color(139, 166, 221));
		jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel6.setForeground(new Color(0, 0, 0));
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setText("Thông tin cá nhân");
		jLabel6.setOpaque(true);
		jLabel12 = new JLabel();

		jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel12.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/hr.png")));

		jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(10).addComponent(jLabel12,
						GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1.setLayout(jPanel1Layout);

		//jPanel2.setBackground(new Color(169, 196, 217));
		jPanel2.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel7.setBackground(new Color(139, 166, 221));
		jLabel7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel7.setForeground(new Color(0, 0, 0));
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setText("Đăng kí lịch tiêm");
		jLabel7.setOpaque(true);

		label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/vaccine (1).png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);

		jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap(34, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		jPanel2.setLayout(jPanel2Layout);

		//jPanel3.setBackground(new Color(193, 215, 226));
		jPanel3.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel8.setBackground(new Color(139, 166, 221));
		jLabel8.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel8.setForeground(new Color(0, 0, 0));
		jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel8.setText("Lịch đã đăng kí");
		jLabel8.setOpaque(true);

		jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel13.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/calendar (1).png")));

		jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE).addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBackground(new Color(212, 233, 238));
		jPanel4.setCursor(new Cursor(Cursor.HAND_CURSOR));

		jLabel9.setBackground(new Color(186, 207, 250));
		jLabel9.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabel9.setForeground(new Color(0, 0, 0));
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setText("Lịch tiêm");
		jLabel9.setOpaque(true);

		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/schedule.png")));

		jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, jPanel4Layout.createSequentialGroup().addGap(19)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addGap(24)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel4.setLayout(jPanel4Layout);
		
		JPanel jPanel5 = new JPanel();
//VACCINE
		jPanel5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Hodan userClone = user;
				if (userClone.getRole().compareTo("Admin")==0)
				{
					Vaccine vc = new Vaccine();
					vc.setVisible(true);
					vc.setTitle("Vaccine");
					vc.setLocationRelativeTo(null);
				}
				else
				{
					jPanel5.setEnabled(false);
				}
			}
		});
		
		jPanel5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		jPanel5.setBackground(new Color(212, 233, 238));
		
		JLabel lblVaccine = new JLabel();
		lblVaccine.setText("Vaccine");
		lblVaccine.setOpaque(true);
		lblVaccine.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaccine.setForeground(Color.BLACK);
		lblVaccine.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblVaccine.setBackground(new Color(186, 207, 250));
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/vaccine (2).png")));
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_jPanel5 = new GroupLayout(jPanel5);
		gl_jPanel5.setHorizontalGroup(
			gl_jPanel5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
				.addComponent(lblVaccine, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(gl_jPanel5.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_jPanel5.setVerticalGroup(
			gl_jPanel5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 238, Short.MAX_VALUE)
				.addGroup(gl_jPanel5.createSequentialGroup()
					.addComponent(lblVaccine, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel5.setLayout(gl_jPanel5);
//QLHD		
		jPanel4_1 = new JPanel();
		jPanel4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		jPanel4_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 102, 255)));
		jPanel4_1.setBackground(new Color(212, 233, 238));
		
		lblQunLH = new JLabel();
		
		lblQunLH.setText("Quản lý hộ dân");
		lblQunLH.setOpaque(true);
		lblQunLH.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLH.setForeground(Color.BLACK);
		lblQunLH.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQunLH.setBackground(new Color(186, 207, 250));
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/gambar/people (1).png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_jPanel4_1 = new GroupLayout(jPanel4_1);
		gl_jPanel4_1.setHorizontalGroup(
			gl_jPanel4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
				.addComponent(lblQunLH, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				.addGroup(gl_jPanel4_1.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_jPanel4_1.setVerticalGroup(
			gl_jPanel4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 231, Short.MAX_VALUE)
				.addGroup(gl_jPanel4_1.createSequentialGroup()
					.addComponent(lblQunLH, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel4_1.setLayout(gl_jPanel4_1);

		pnlTimelineLayout = new GroupLayout(pnlTimeline);
		pnlTimelineLayout.setHorizontalGroup(
			pnlTimelineLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnlTimelineLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(pnlTimelineLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(pnlTimelineLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(pnlTimelineLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(pnlTimelineLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addGroup(pnlTimelineLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel4_1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(72))
		);
		pnlTimelineLayout.setVerticalGroup(
			pnlTimelineLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnlTimelineLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(pnlTimelineLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(pnlTimelineLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel4_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		pnlTimeline.setLayout(pnlTimelineLayout);

		jspTimeline.setViewportView(pnlTimeline);

		pnlBody.add(jspTimeline, "card2");

		pnlNews.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		jspNews = new JScrollPane();
		jspNews.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jspNews.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jspNews.setBorder(null);

		pnlNewsLayout = new GroupLayout(pnlNews);
		pnlNewsLayout.setHorizontalGroup(pnlNewsLayout.createParallelGroup(Alignment.TRAILING).addComponent(jspNews,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE));
		pnlNewsLayout.setVerticalGroup(pnlNewsLayout.createParallelGroup(Alignment.LEADING).addComponent(jspNews,
				GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE));

		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		jspNews.setViewportView(panel);

		separator = new JSeparator();
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(41)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(74)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(352, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		pnlNews.setLayout(pnlNewsLayout);

		pnlBody.add(pnlNews, "card4");

		layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlBody, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
				.addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlBody, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}
	

	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void btnMaximizeMouseEntered(MouseEvent evt) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMaximizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMaximizeActionPerformed(ActionEvent evt) {
		if (maximized) {

			Dashboard.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Dashboard.this.setMaximizedBounds(env.getMaximumWindowBounds());
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

	private void btnNewsActionPerformed(ActionEvent evt) {
		lblNews.setBackground(new Color(0, 102, 153));

		lblTimeline.setBackground(new Color(215, 228, 242));

		pnlBody.removeAll();
		pnlBody.repaint();
		pnlBody.revalidate();
		pnlBody.add(pnlNews);
		pnlBody.repaint();
		pnlBody.revalidate();
	}

	private void btnTimelineActionPerformed(ActionEvent evt) {
		lblTimeline.setBackground(new Color(0, 102, 153));

		lblNews.setBackground(new Color(215, 228, 242));

		pnlBody.removeAll();
		pnlBody.repaint();
		pnlBody.revalidate();
		pnlBody.add(jspTimeline);
		pnlBody.repaint();
		pnlBody.revalidate();
	}

	public static void main(String args[]) {
		
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Dashboard().setVisible(true);
			}
		});
	}
}
