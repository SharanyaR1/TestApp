package testapp;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import javax.swing.*;

public class DB {
    static Connection con=null;
    java.sql.PreparedStatement pst;
    public static Connection dbconnect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testapp","root","");
			return con;
			//JOptionPane.showMessageDialog(null,"Connection successful");
			}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		 

	}

	
}
