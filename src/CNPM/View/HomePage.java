package CNPM.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.SystemColor;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

//	private JFrame frmHome;
	private JPanel panel, pnlHeader;
	private JButton btnExit, btnMinimize, btnMaximize;
	private boolean maximized = true;
	int xMouse, yMouse;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomePage().setVisible(true);
			}
		});
	}

	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/gambar/home.png")));
		getContentPane().setBackground(SystemColor.activeCaption);
		initialize();
		
	}

	private void initialize() {


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Homepage");
		setUndecorated(true);
		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBounds(0, 29, 999, 573);
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));

		JLabel lblHompage = new JLabel();
		lblHompage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblHompage.setBounds(226, 156, 696, 386);
		lblHompage.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHompage.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		lblHompage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHompage.setIcon(
				new ImageIcon(HomePage.class.getResource("/gambar/imageonline-co-whitebackgroundremoved.png")));

		JLabel lblLogin = new JLabel("Đăng nhập");
		lblLogin.setBounds(814, 29, 75, 24);
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login Login = new login();
				Login.Show();
			}
		});
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JLabel lblRegister = new JLabel("Đăng kí");
		lblRegister.setBounds(902, 30, 75, 24);
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register register = new Register();
				register.Show();
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JTextPane txtpntitle = new JTextPane();
		txtpntitle.setBounds(259, 84, 586, 36);
		txtpntitle.setEditable(false);
		txtpntitle.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		txtpntitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtpntitle.setText("HỆ THỐNG QUẢN LÍ TIÊM CHỦNG CHO GIA SÚC GIA CẦM");

		 pnlHeader = new JPanel();
		 pnlHeader.setBounds(0, 0, 1000, 29);
		pnlHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHeaderMousePressed(e);
			}

			public void mouseDragged(MouseEvent e) {
				pnlHeaderMouseDragged(e);
			}
		});

		pnlHeader.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));

		btnMinimize = new JButton();
		btnMinimize.setIcon(new ImageIcon(HomePage.class.getResource("/gambar/Minimize (2).png")));
		btnMinimize.setOpaque(true);
		btnMinimize.setFocusable(false);
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
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
		btnMaximize.setIcon(new ImageIcon(HomePage.class.getResource("/gambar/Maximize (2).png")));
		btnMaximize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMaximizeActionPerformed(evt);
			}
		});
		btnMaximize.setOpaque(true);
		btnMaximize.setFocusable(false);
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMaximizeMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btnMaximizeMouseExited(evt);
			}

		});
		
		btnExit = new JButton();
		btnExit.setIcon(new ImageIcon(HomePage.class.getResource("/gambar/Exit.png")));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitActionPerformed(e);
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExitMouseEntered(e);
			}

			public void mouseExited(MouseEvent evt) {
				btnExitMouseExited(evt);
			}

		});
		btnExit.setOpaque(true);
		btnExit.setFocusable(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlHeader.createSequentialGroup().addContainerGap(671, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_pnlHeader.setVerticalGroup(gl_pnlHeader.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlHeader
				.createSequentialGroup()
				.addGroup(gl_pnlHeader.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMaximize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMinimize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
				.addContainerGap()));
		pnlHeader.setLayout(gl_pnlHeader);
		panel.setLayout(null);
		panel.add(lblLogin);
		panel.add(lblRegister);
		panel.add(txtpntitle);
		panel.add(lblHompage);
		getContentPane().setLayout(null);
		getContentPane().add(pnlHeader);
		getContentPane().add(panel);
		
		lblNewLabel = new JLabel("TRÊN ĐỊA BÀN THÀNH PHỐ ĐÀ NẴNG");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(361, 119, 398, 30);
		panel.add(lblNewLabel);
	}

	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(new Color(255, 255, 255));
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void btnMaximizeMouseEntered(MouseEvent evt) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMaximizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(new Color(255, 255, 255));
	}

	private void btnMaximizeActionPerformed(ActionEvent evt) {
		if (maximized) {

			HomePage.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			HomePage.this.setMaximizedBounds(env.getMaximumWindowBounds());
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
		btnMinimize.setBackground(new Color(255, 255, 255));
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
}
