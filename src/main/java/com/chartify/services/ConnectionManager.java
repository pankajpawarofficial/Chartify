package com.chartify.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private Connection connection;
	private String url;

	public Connection getConnection()
	{

		try
		{
			url = "jdbc:mysql://127.0.0.1:3306/applicationdatabaseschema?useSSL=false&allowPublicKeyRetrieval=true";
			

			Class.forName("com.mysql.jdbc.Driver");

			try
			{            	
				connection = DriverManager.getConnection(url,"root","root"); 

			}

			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}

		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}

		return connection;
	}
}
