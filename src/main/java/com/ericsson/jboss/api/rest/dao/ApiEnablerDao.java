package com.ericsson.jboss.api.rest.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.ericsson.jboss.api.rest.HelloWorldService;

public class ApiEnablerDao {

	static Connection apienablerConn = null;
	static PreparedStatement apienabelrPrepareStat = null;
	static Logger logger = Logger.getLogger(ApiEnablerDao.class.getSimpleName());
	
	public static void makeJDBCConnection() {
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			log("Congrats - Seems your MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			apienablerConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apienabler", "apiuser", "apiuser");
			if (apienablerConn != null) {
				log("Connection Successful! Enjoy. Now it's time to push data");
			} else {
				log("Failed to make connection!");
			}
		} catch (SQLException e) {
			log("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
 
	public static void addDataToDB(String action) {
		 
		try {
			String insertQueryStatement = "update calldirect set action = ? where ID = 007";
 
			apienabelrPrepareStat = apienablerConn.prepareStatement(insertQueryStatement);
			apienabelrPrepareStat.setString(1, action);
			
			// execute insert SQL statement
			apienabelrPrepareStat.executeUpdate();
			log(action + " upadated successfully");
		} catch (
 
		SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getDataFromDB() {
 
		String action = null;
		try {
			// MySQL Select Query Tutorial
			String getQueryStatement = "SELECT * FROM calldirect";
 
			apienabelrPrepareStat = apienablerConn.prepareStatement(getQueryStatement);
			// Execute the Query, and get a java ResultSet
			ResultSet rs = apienabelrPrepareStat.executeQuery();
 
			// Let's iterate through the java ResultSet
			while (rs.next()) {
				if (rs.getInt("ID") == 007) {
					action = rs.getString("action");
					return action;
				}
				System.out.format("%s\n", action);
			}
		} catch (
 
		SQLException e) {
			e.printStackTrace();
		}
		return action;
 
	}
 
	// Simple log utility
	private static void log(String string) {
		logger.info(string);
 
	}
}
