import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Add_Book {

	public JFrame f;
	public JButton Delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Book window = new Add_Book();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		f = new JFrame();
		f.setAlwaysOnTop(true);
		f.setTitle("Address Book\r\n");
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setBounds(100, 100, 456, 322);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		JButton Register = new JButton("Register");
		Register.setForeground(Color.BLACK);
		Register.setBackground(Color.WHITE);
		Register.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				Registeration_Page Rgstr = null;
				try {
					Rgstr = new Registeration_Page();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Rgstr.setVisible(true);
				
			}
			
		});
		Register.setBounds(153, 25, 111, 45);
		f.getContentPane().add(Register);
		
		JButton Search = new JButton("Search");
		Search.setForeground(Color.BLACK);
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Search_Page srch=new Search_Page();
				srch.setVisible(true);
				srch.Delete.setVisible(false);
			}
		});
		Search.setBackground(Color.WHITE);
		Search.setBounds(153, 81, 111, 45);
		f.getContentPane().add(Search);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		Exit.setBackground(Color.WHITE);
		Exit.setBounds(153, 193, 111, 45);
		f.getContentPane().add(Exit);
		
		 Delete = new JButton("Delete");
		Delete.setBackground(Color.WHITE);
		Delete.setForeground(Color.BLACK);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					f.dispose();
				Search_Page srch=new Search_Page();
				srch.setVisible(true);
				srch.Find.setVisible(false);
			
			}
		});
		Delete.setBounds(153, 137, 111, 45);
		f.getContentPane().add(Delete);
	}
}
