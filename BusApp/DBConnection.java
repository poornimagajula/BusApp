package com.regnant.BusApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection connection= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "Admin@123");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Connection failed check the console");
			e.printStackTrace();
		}
		return connection;
	}
	

}
