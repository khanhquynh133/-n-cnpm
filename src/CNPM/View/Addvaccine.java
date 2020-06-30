package CNPM.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CNPM.Model.Connect_DB;
import CNPM.Model.Vacxin;
import Management.Connect;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Addvaccine extends JFrame {

	private JPanel contentPane;
	private JTextField txtvc;
	private JTextField txtname;
	private JTextField txtnum;
	private JTextField txtvn;
	Connection connect = null;
	PreparedStatement pre;
	ResultSet rs;
	Statement sta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addvaccine frame = new Addvaccine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addvaccine() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Vaccine ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(23, 39, 112, 24);
		panel.add(lblNewLabel);
		
		JLabel lblIdVaccine = new JLabel("Vaccine Name ");
		lblIdVaccine.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIdVaccine.setBounds(23, 74, 142, 24);
		panel.add(lblIdVaccine);
		
		JLabel lblNumber = new JLabel("Number ");
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNumber.setBounds(23, 109, 112, 24);
		panel.add(lblNumber);
		
		JLabel lblIdVtNui = new JLabel("ID V\u1EADt nu\u00F4i ");
		lblIdVtNui.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIdVtNui.setBounds(25, 145, 127, 24);
		panel.add(lblIdVtNui);
		
		txtvc = new JTextField();
		txtvc.setBounds(161, 38, 236, 28);
		panel.add(txtvc);
		txtvc.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(161, 75, 236, 28);
		panel.add(txtname);
		
		txtnum = new JTextField();
		txtnum.setColumns(10);
		txtnum.setBounds(161, 108, 236, 28);
		panel.add(txtnum);
		
		txtvn = new JTextField();
		txtvn.setColumns(10);
		txtvn.setBounds(161, 144, 236, 28);
		panel.add(txtvn);
		
		JButton btadd = new JButton("ADD");
		btadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String idvc=txtvc.getText();
				String name=txtvc.getText();
				int number=Integer.parseInt(txtnum.getText());
				String idvn=txtvn.getText();
				

				if (txtvc.getText() != null && txtname.getText() != null && txtnum.getText() != null
						&& txtvn.getText() != null ) {

					try {
						connect=Connect_DB.getSQLServer();
						String sql = "insert into Vaccine_r(idVaccine,Vaccine_name,Number,idVatNuoi) values ( ?, ?, ?, ?)";
						pre = connect.prepareStatement(sql);
						Vacxin vc;
						ArrayList<Vacxin> vclist = new ArrayList<Vacxin>();
						vc = new Vacxin(idvc,name,number,idvn);
						vclist.add(vc);
						
						pre.setString(1, vclist.get(0).getIdVaccine());
						pre.setString(2, vclist.get(0).getTenvaccine());
						pre.setInt(3, vclist.get(0).getSoluong());
						pre.setString(4, vclist.get(0).getIdVatnuoi());
					
						pre.execute();
						JOptionPane.showMessageDialog(null, " Successfully!");
						// Show_userlist();
						pre.close();

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "System Error!" + ex);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill out all the fields!");
				}*/
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
		btadd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btadd.setBounds(105, 194, 89, 23);
		panel.add(btadd);
		
		JButton btclear = new JButton("CLEAR");
		btclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btclear)
				{
					txtvc.setText("");
					txtname.setText("");
					txtnum.setText("");
					txtvn.setText("");
				}
			}
		});
		btclear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btclear.setBounds(240, 193, 101, 23);
		panel.add(btclear);
		
		
	}
}
