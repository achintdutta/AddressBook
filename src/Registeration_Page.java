import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registeration_Page extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFather;
	private JTextField txtContact;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtPinCode;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registeration_Page frame = new Registeration_Page();
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
	public Registeration_Page() throws Exception {
		setTitle("Address Book");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setBounds(20, 21, 46, 14);
		contentPane.add(Name);
		
		JLabel FatherName = new JLabel("Father");
		FatherName.setBounds(20, 42, 46, 14);
		contentPane.add(FatherName);
		
		JLabel Contact = new JLabel("Contact ");
		Contact.setBounds(20, 63, 57, 14);
		contentPane.add(Contact);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(20, 84, 46, 14);
		contentPane.add(lblStreet);
		
		JLabel City = new JLabel("City");
		City.setBounds(20, 105, 46, 14);
		contentPane.add(City);
		
		JLabel State = new JLabel("State");
		State.setBounds(20, 126, 46, 14);
		contentPane.add(State);
		
		JLabel PinCode = new JLabel("Pin Code");
		PinCode.setBounds(20, 147, 57, 14);
		contentPane.add(PinCode);
		
		JButton Submit = new JButton("Submit");
		Submit.setForeground(Color.BLACK);
		Submit.setBackground(Color.WHITE);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert();
				txtName.setText("");
				txtFather.setText("");
				txtContact.setText("");
				txtStreet.setText("");
				txtCity.setText("");
				txtState.setText("");
				txtPinCode.setText("");
				txtEmail.setText("");
				dispose();
				
				Add_Book window = new Add_Book();
				window.f.setVisible(true);
			}
		});
		Submit.setBounds(285, 215, 89, 23);
		contentPane.add(Submit);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 168, 46, 14);
		contentPane.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setBounds(104, 18, 270, 20);
		contentPane.add(txtName);
		
		txtName.setColumns(10);
		
		txtFather = new JTextField();
		txtFather.setBounds(104, 39, 270, 20);
		contentPane.add(txtFather);
		txtFather.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setBounds(104, 60, 270, 20);
		contentPane.add(txtContact);
		txtContact.setColumns(10);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(104, 81, 270, 20);
		contentPane.add(txtStreet);
		txtStreet.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(104, 102, 270, 20);
		contentPane.add(txtCity);
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(104, 123, 270, 20);
		contentPane.add(txtState);
		txtState.setColumns(10);
		
		txtPinCode = new JTextField();
		txtPinCode.setBounds(104, 144, 270, 20);
		contentPane.add(txtPinCode);
		txtPinCode.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(104, 165, 270, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton Home = new JButton("Home Page");
		Home.setForeground(Color.BLACK);
		Home.setBackground(Color.WHITE);
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Add_Book window = new Add_Book();
				window.f.setVisible(true);
			}
		});
		Home.setBounds(104, 215, 103, 23);
		contentPane.add(Home);
		
	}
	public void Insert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","");
			//Statement stmt=con.createStatement();
			//int r= stmt.executeUpdate("Insert into information values(txtName.getText(), txtFather.getText(), txtContact.getText(), txtStreet.getText(), txtCity.getText(), txtState.getText(), txtPinCode.getText(), txtEmail.getText())"); 
			PreparedStatement s= con.prepareStatement("INSERT into information values(?,?,?,?,?,?,?,?)");
			s.setString(1,txtName.getText());
			s.setString(2,txtFather.getText());
			s.setLong(3,Long.parseLong(txtContact.getText()));
			s.setString(4,txtStreet.getText());
			s.setString(5,txtCity.getText());
			s.setString(6,txtState.getText());
			s.setInt(7,Integer.parseInt(txtPinCode.getText()));
			s.setString(8,txtEmail.getText());
			 
			s.execute();
			JOptionPane.showMessageDialog(null, "saved");
			
			s.close();
			con.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	
	}
}
