package com.scale.framework.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostgresSqlConnection {

	private static final Logger log = LogManager.getLogger(PostgresSqlConnection.class);
	private String dataBase, user, password, port, server;
	ConfigurationReader reader = new ConfigurationReader();

	public PostgresSqlConnection() {
		port = reader.postgressqlPort();
		dataBase = reader.postgressqlDataBaseName();
		user = reader.postgressqlUser();
		server = reader.postgressqlServer();
		password = reader.postgressqlPassword();
		//log.info("Trying to connect postgresDb....");
	}

	public Connection getConnections() {

		Connection connection = null;
		boolean err_flag=false;
		try {
			Class.forName("org.postgresql.Driver");
			String connectionString = "jdbc:postgresql://" + server +
					":" + port + "/" + dataBase;
			connection = DriverManager.getConnection(connectionString, user, password);
			log.info(connection);
		} catch (Exception e) {
			err_flag=true;
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			//System.exit(0); // System.exit(0) crashes SureFire Plugin
		}
		if(!err_flag){
		log.info("Opened database successfully");}
		return connection;
	}

	public ResultSet getData(String query) {
		Statement statement;
		ResultSet resultSet = null;
		try {
			statement = getConnections().createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return resultSet;		
	}
	
	public void closeConnection() {
		try {
			getConnections().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Connection closed .. .");
	}
}