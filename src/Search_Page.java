import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.lang.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Color;

public class Search_Page extends JFrame {

	private JPanel contentPane;
	private JTextField txt_NameSearch;
	private JTextField text_ContactSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Page f5 = new Search_Page();
					f5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	 public JTable table1;
	 private JButton Home1;
	 private JEditorPane dtrpnEnterYourName;
	 public JButton Delete;
	 public JButton Find;
	public Search_Page() {
		setTitle("Address Pook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_NameSearch = new JTextField();
		txt_NameSearch.setBounds(506, 11, 180, 20);
		contentPane.add(txt_NameSearch);
		txt_NameSearch.setColumns(10);
		
		
		
		 Find = new JButton("Find");
		 Find.setForeground(Color.BLACK);
		 Find.setBackground(Color.WHITE);
		Find.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c= DriverManager.getConnection("jdbc:mysql://localhost/AddressBook","root","");
				PreparedStatement s= c.prepareStatement("SELECT * from information where name=? && Contact=?");
				s.setString(1,txt_NameSearch.getText());
				s.setLong(2,Long.parseLong(text_ContactSearch.getText()));
				ResultSet rs= s.executeQuery();
				
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			//JOptionPane.showMessageDialog(null, rs);
			

				s.close();
				c.close();
			}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					}	
				
				
				
				
				
				
				
				
				
				
				
				
				
				//txt_NameSearch.setText("");
				//result frame=new result();
				//frame.setVisible(true);
				//frame.searching();
			}
		});
		
		
		 //s2=Long.parseLong(text_ContactSearch.getText());
		
		 
		 
		Find.setBounds(506, 84, 89, 26);
		contentPane.add(Find);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(416, 14, 46, 14);
		contentPane.add(lblName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 797, 255);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JLabel lblContact = new JLabel("Contact ");
		lblContact.setBounds(416, 56, 58, 14);
		contentPane.add(lblContact);
		
		text_ContactSearch = new JTextField();
		text_ContactSearch.setBounds(506, 53, 180, 20);
		contentPane.add(text_ContactSearch);
		text_ContactSearch.setColumns(10);
		
		Home1 = new JButton("Home Page");
		Home1.setForeground(Color.BLACK);
		Home1.setBackground(Color.WHITE);
		Home1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Add_Book window = new Add_Book();
				window.f.setVisible(true);
			}
		});
		Home1.setBounds(42, 389, 106, 23);
		contentPane.add(Home1);
		
		dtrpnEnterYourName = new JEditorPane();
		dtrpnEnterYourName.setEditable(false);
		dtrpnEnterYourName.setBackground(Color.LIGHT_GRAY);
		dtrpnEnterYourName.setText("Enter your Name and Contact number to start search");
		dtrpnEnterYourName.setBounds(105, 11, 231, 59);
		contentPane.add(dtrpnEnterYourName);
		
		Delete = new JButton("Delete");
		Delete.setForeground(Color.BLACK);
		Delete.setBackground(Color.WHITE);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c= DriverManager.getConnection("jdbc:mysql://localhost/AddressBook","root","");
				PreparedStatement s= c.prepareStatement("DELETE  from information where name=? && Contact=?");
				s.setString(1,txt_NameSearch.getText());
				s.setLong(2,Long.parseLong(text_ContactSearch.getText()));
				int rs= s.executeUpdate();
				
			//table1.setModel(DbUtils.resultSetToTableModel(rs));
			JOptionPane.showMessageDialog(null, "Information Deleted");
			
			

				s.close();
				c.close();
			}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
					}	
				
			}
		});
		Delete.setBounds(597, 84, 89, 27);
		contentPane.add(Delete);
		
	 
	}
}