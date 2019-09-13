package br.com.deitos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			// load and register JDBC driver for MySQL
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:mysql://192.168.162.28/projetoweb","seq_user","seq_password");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
