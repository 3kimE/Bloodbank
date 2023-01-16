package application;

import java.sql.*;

public class Connexionmysql{

	public Connection cn = null;
	
	public static Connection connecxionBD() {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","");

			
			System.out.println("basedonne conected");
			return cn;
			
		}catch(ClassNotFoundException | SQLException e) {
			
			System.out.println("basedonne not conected ");
			
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
} 