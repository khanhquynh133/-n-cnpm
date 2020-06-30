package CNPM.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CNPM.Model.Connect_DB;
import CNPM.Model.Vacxin;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Vaccine extends JFrame {
	private JTable table;
	private JTextField txtvc;
	private JTextField txtname;
	private JTextField txtnum;
	private JTextField txtvn;
	//Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Vaccine frame = new Vaccine();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vaccine() {
		setBounds(100, 100, 775, 529);
		getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 230, 245));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("ID Vaccine ");
		lblNewLabel_1.setForeground(new Color(92, 118, 169));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(64, 116, 112, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblIdVaccine = new JLabel("Vaccine Name ");
		lblIdVaccine.setForeground(new Color(92, 118, 169));
		lblIdVaccine.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIdVaccine.setBounds(64, 157, 142, 24);
		panel.add(lblIdVaccine);
		
		txtvc = new JTextField();
		txtvc.setColumns(10);
		txtvc.setBounds(209, 117, 320, 28);
		panel.add(txtvc);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(209, 156, 320, 28);
		panel.add(txtname);
		
		JLabel lblNumber = new JLabel("Số lượng");
		lblNumber.setForeground(new Color(92, 118, 169));
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNumber.setBounds(64, 196, 112, 24);
		panel.add(lblNumber);
		
		txtnum = new JTextField();
		txtnum.setColumns(10);
		txtnum.setBounds(209, 197, 320, 28);
		panel.add(txtnum);
		
		JLabel lblIdVtNui = new JLabel("ID Vật nuôi ");
		lblIdVtNui.setForeground(new Color(92, 118, 169));
		lblIdVtNui.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIdVtNui.setBounds(64, 237, 127, 24);
		panel.add(lblIdVtNui);
		
		txtvn = new JTextField();
		txtvn.setColumns(10);
		txtvn.setBounds(209, 236, 320, 28);
		panel.add(txtvn);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBounds(0, 0, 1, 1);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(64, 288, 637, 186);
		panel.add(scrollPane);
		
		model.addColumn("ID Vaccine");
		model.addColumn("Tên Vaccine");
		model.addColumn("Số lượng");
		model.addColumn("ID Vật nuôi");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Row = table.getSelectedRow();
				//System.out.print(Row);
	            String idvc = (String) table.getValueAt(Row, 0);
	            //System.out.print(idvc);
	            String name = (String) table.getValueAt(Row, 1);
	            int num = (int) table.getValueAt(Row, 2);
	            String idvn = (String) table.getValueAt(Row, 3);
	            txtvc.setText(idvc);
				txtname.setText(name);
				txtnum.setText(Integer.toString(num));
				txtvn.setText(idvn);
			}
		});
	
		JButton btxem = new JButton("XEM");
		btxem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 
				model.setRowCount(0);
				Connection cn=Connect_DB.getSQLServer();
				PreparedStatement ps=cn.prepareStatement("SELECT * FROM Vaccine_r");
				ResultSet rs=ps.executeQuery();
				while (rs.next()) 
				{
					String idvc=rs.getString("idVaccine");
					String name=rs.getString("Vaccine_name");
					int number=rs.getInt("Number");
					String idvn=rs.getString("idVatNuoi");
					Vacxin vc=new Vacxin(idvc,name,number,idvn);
					//model.addRow(vc);
					model.addRow(new Object[] {idvc,name,number,idvn});
				}
				}
				catch(Exception ee)
				{
				    JOptionPane.showMessageDialog(null,"Error in connect");
				}
			}
		});
		btxem.setForeground(Color.WHITE);
		btxem.setBackground(new Color(92, 118, 169));
		btxem.setFont(new Font("Tahoma", Font.BOLD, 17));
		btxem.setBounds(560, 117, 142, 28);
		btxem.setBorder(null);
		panel.add(btxem);
		
		JButton btedit = new JButton("CHỈNH SỬA");
		btedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{ 
				/*String idvc=txtvc.getText();
				String name=txtname.getText();
				int number=Integer.parseInt(txtnum.getText());
				String idvn=txtvn.getText();*/
				Connection cn=Connect_DB.getSQLServer();
				String sql = "exec UpdateVaccine @idVaccine=? , @Vaccine_name=? , @Number=? , @idVatNuoi=?";
				PreparedStatement ps=cn.prepareStatement(sql);
				ps.setString(1,txtvc.getText() );
				ps.setString(2,txtname.getText());
				ps.setInt(3,Integer.parseInt(txtnum.getText()) );
				ps.setString(4,txtvn.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công");
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btedit.setForeground(Color.WHITE);
		btedit.setBackground(new Color(92, 118, 169));
		btedit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btedit.setBounds(560, 194, 142, 28);
		btedit.setBorder(null);
		panel.add(btedit);
		
		JButton btadd = new JButton("THÊM");
		btadd.setBackground(new Color(92,118,169));
		btadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 
				Connection cn=Connect_DB.getSQLServer();
				String sql = "Insert into Vaccine_r values(?,?,?,?)";
				PreparedStatement ps=cn.prepareStatement(sql);
				ps.setString(1,txtvc.getText() );
				ps.setString(2,txtname.getText());
				ps.setInt(3,Integer.parseInt(txtnum.getText()) );
				ps.setString(4,txtvn.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btadd.setForeground(Color.WHITE);
		btadd.setBackground(new Color(92, 118, 169));
		btadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btadd.setBounds(560, 155, 142, 28);
		btadd.setBorder(null);
		panel.add(btadd);
		
		JButton btclear = new JButton("CLEAR");
		btclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
			}
		});
		btclear.setForeground(Color.WHITE);
		btclear.setBackground(new Color(92, 118, 169));
		btclear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btclear.setBounds(560, 235, 142, 28);
		btclear.setBorder(null);
		panel.add(btclear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(92, 118, 169));
		panel_1.setBounds(0, 0, 761, 93);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("HỆ THỐNG QUẢN LÍ TIÊM CHỦNG GIA SÚC GIA CẦM");
		lblNewLabel_1_1.setBounds(132, 15, 631, 25);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÍ VACCINE");
		lblNewLabel.setBounds(335, 51, 184, 25);
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Vaccine.class.getResource("/gambar/logobty.png")));
		lblNewLabel_2_1.setBounds(10, 0, 88, 83);
		panel_1.add(lblNewLabel_2_1);
		
		
		
		
		
		
		
		
	}
}
