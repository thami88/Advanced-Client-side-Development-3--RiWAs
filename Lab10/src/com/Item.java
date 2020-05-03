package com;

import java.sql.*; 

public class Item {
	
	// Method to Connect Database /------------------------------------------------------------
	
	private Connection connect() {
		
		Connection con = null; 
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost/item_management", "root", "");
			
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
		}
		
		return con;
		
	}

}
