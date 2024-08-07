package com.magicbaits.persistence.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "online_store_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "toor";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);
		}catch(SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
