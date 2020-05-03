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
		
	} // End of DB Connection method /---------------------------------------------------------------------
	
	
	// Read Method /---------------------------------------------------------------------------------------
	
	public String readItems() {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if (con == null) {
				
				return "Error while connecting to the database for reading";
				
			}
			
			//  Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Item Code</th> <th>Item Name</th><th>Item Price</th>"  
					+ "<th>Item Description</th> <th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from items";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// Iterate through the rows in the result set
			while (rs.next()) {
				
				String itemID = Integer.toString(rs.getInt("itemID"));
				String itemCode = rs.getString("itemCode");
				String itemName = rs.getString("itemName");
				String itemPrice = Double.toString(rs.getDouble("itemPrice"));
				String itemDesc = rs.getString("itemDesc");
				
				// Add into the html table
				output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + itemID + "'>" + itemCode + "</td>";
				output += "<td>" + itemName + "</td>";
				output += "<td>" + itemPrice + "</td>";
				output += "<td>" + itemDesc + "</td>"; 
				
				// Update Delete Buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='" + itemID + "'>" + "</td></tr>"; 
				
			}
			
			con.close();
			
			// Complete the html table
			output += "</table>";
			
			
		} catch (Exception e) {
			
			// Handle exception
			output = "Error while reading the items.";
			System.out.println(e.getMessage());
			
		}
		
		return output;
		
	}

}
