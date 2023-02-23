package testapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import testapp.DB;
import testapp.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Signup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public  JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	Connection con=null;
	public Signup() {
		
		con=(Connection) DB.dbconnect(); //database 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 39));
		lblNewLabel.setBounds(59, 10, 343, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(34, 75, 150, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_2.setBounds(34, 140, 130, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("USN");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_3.setBounds(34, 206, 125, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_4.setBounds(34, 265, 129, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email ID");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_5.setBounds(34, 335, 129, 27);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(215, 80, 187, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(215, 145, 187, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(215, 203, 187, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(215, 335, 187, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 268, 187, 35);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("SIGNUP");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String first=textField.getText();
					String last=textField_1.getText();
					String usn=textField_2.getText();
					String password=passwordField.getText();
					String emailid=textField_3.getText();
					
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into signup(firstname,lastname,usn,password,emailid) values(?,?,?,?,?)");
					pst.setString(1, first);
					pst.setString(2, last);
					pst.setString(3, usn);
					pst.setString(4, password);
					pst.setString(5, emailid);
					pst.executeUpdate();
					 
					JOptionPane.showMessageDialog(null, "SUCCESSFULLY REGISTERED");
					textField.setText("");  //after we click signup the fields should go blank
					textField_1.setText("");
					textField_2.setText("");
					passwordField.setText("");
					textField_3.setText("");
					
				
		         }
				catch (Exception e1) {
				      System.out.println("Something went wrong.");
				    } finally {
				      System.out.println("The 'try catch' is finished.");
				    }
			}
		});
			
	
		btnNewButton.setBounds(59, 418, 125, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(266, 418, 115, 35);
		contentPane.add(btnNewButton_1);
	}
}
