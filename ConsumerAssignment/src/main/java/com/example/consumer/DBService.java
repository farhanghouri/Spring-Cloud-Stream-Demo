package com.example.consumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBService {

	public static void insert(Ticket ticket, int engineerID) {
		try {
			int typeForwardOnly = ResultSet.TYPE_FORWARD_ONLY;
			Connection connection = getDbConnection();
			// create a Statement from the connection
			Statement statement = connection.createStatement();
	
			String data;
			data = "'"+ticket.getNo() +"','"+ ticket.getTitle() +"','"+ ticket.getType() +"','"+ ticket.getStatus() +"',"+ engineerID;
			// insert the data
			statement.executeUpdate("INSERT INTO Tickets (no,title,type,status,engineer_id) " + ""
					+ "VALUES ("+data+")");
			
			
			connection.close();
		} catch(Exception e) {
			e.printStackTrace(); 	
		}
	}
	
	public static Connection getDbConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/springstream","sammy","password");
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		
		return null;
	}
}
