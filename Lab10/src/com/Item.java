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
			output = "<div class='table-responsive text-center'> <table class='table table-hover'><thead class='black white-text'><tr><th>Item Code</th> <th>Item Name</th><th>Item Price</th>"  
					+ "<th>Item Description</th> <th>Update</th><th>Remove</th></tr></thead>";
			
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
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-warning btn-sm'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger btn-sm' data-itemid='" + itemID + "'>" + "</td></tr>"; 
				
			}
			
			con.close();
			
			// Complete the html table
			output += "</table></div>";
			
			
		} catch (Exception e) {
			
			// Handle exception
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	} // End of Read Method /-----------------------------------------------------------------------------
	
	
	// Insert Method /------------------------------------------------------------------------------------
	
	public String insertItem(String code, String name, String price, String desc) {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if (con == null) {
				
				return "Error while connecting to the database for Inserting.";
				
			}
			
			// Create a prepared statement
			String query = " insert into items (`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`)" + " values (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// Binding Values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, name);
			preparedStmt.setDouble(4, Double.parseDouble(price));
			preparedStmt.setString(5, desc);
			
			// Execute the statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
			
		} catch (Exception e) {
			
			// Handle exception
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}";
			
			System.err.println(e.getMessage());
		}
		
		return output;
		
	} // End of Insert Method /------------------------------------------------------------------------
	
	// Update Method /---------------------------------------------------------------------------------
	
	public String updateItem(String ID, String code, String name, String price, String desc) {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if (con == null) {
				
				return "Error while connecting to the database for Updating.";
				
			}
			
			// Create a prepared statement
			String query = "UPDATE items SET itemCode=?,itemName=?,itemPrice=?,itemDesc=? WHERE itemID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// Binding Values
			preparedStmt.setString(1, code);
			preparedStmt.setString(2, name); 
			preparedStmt.setDouble(3, Double.parseDouble(price));
			preparedStmt.setString(4, desc);
			preparedStmt.setInt(5, Integer.parseInt(ID));
			
			// Execute the statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 
			
		} catch (Exception e) {
			
			// Handle exception
			output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}"; 
			System.err.println(e.getMessage());
		}
		
		return output;
		
	} // End of the Update Method /---------------------------------------------------------------------
	
	
	// Delete Method /----------------------------------------------------------------------------------
	
	public String deleteItem(String itemID) {
		
		String output = "";
		
		try {
			
			Connection con = connect();
			
			if (con == null) {
				
				return "Error while connecting to the database for Deleting.";
				
			}
			
			// Create a Prepared Statement
			String query = "delete from items where itemID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// Binding Values
			preparedStmt.setInt(1, Integer.parseInt(itemID));
			
			// Execute the Statement
			preparedStmt.execute();
			con.close();
			
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
			
			
		} catch (Exception e) {
			
			// Handle exception
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}

}
