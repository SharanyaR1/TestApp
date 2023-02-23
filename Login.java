package testapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import testapp.DB;
import testapp.TestJava;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	Connection con=null;
	
	public Login() {
		
		con=(Connection) DB.dbconnect(); //database 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(125, 10, 205, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" USN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(42, 76, 96, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_2.setBounds(42, 155, 127, 32);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(201, 76, 168, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 156, 168, 31);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String usn=textField.getText();
					String pwd=String.valueOf(passwordField.getPassword());
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from signup where usn=? and password=?");
					pst.setString(1,usn);
					pst.setString( 2, pwd);
					ResultSet r=pst.executeQuery();
					if(r.next())
					{  
						Subjects s=new Subjects();
						s.setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Incorrect USN and password");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(157, 227, 106, 32);
		contentPane.add(btnNewButton);
	}
	
}
