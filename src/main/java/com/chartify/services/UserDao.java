package com.chartify.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chartify.beans.UserBean;

public class UserDao {
	
	private ConnectionManager connectionManager;
	private Connection currentCon = null;
	private ResultSet resultSet = null;  

	public UserDao() {
		super();
		connectionManager=new ConnectionManager();
		currentCon=connectionManager.getConnection();
	}

	public UserBean login(UserBean bean) {

		//preparing some objects for connection 
		Statement statement = null;    

		String username = bean.getUserName();    
		String password = bean.getPassword();   

		String searchQuery ="select * from USERS_DETAILS where username='"+username+"' AND password='"+password+"'";

		// "System.out.println" prints in the console; Normally used to trace the process
		System.out.println("Your user name is " + username);          
		System.out.println("Your password is " + password);
		System.out.println("Query: "+searchQuery);
		System.out.println(searchQuery);
		try 
		{	//connect to DB 
			statement=currentCon.createStatement();
			resultSet = statement.executeQuery(searchQuery);	        
			System.out.println(resultSet);
			boolean more=resultSet.next();
			// if user does not exist set the isValid variable to false
			
			if(!more){
				return null;
			}
			else 
				return bean;
			
		} 

		catch (Exception ex) 
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{
			if (resultSet != null)	{
				try {
					resultSet.close();
				} catch (Exception e) {}
				resultSet = null;
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {}
				statement = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
	return null;
	}

	public UserBean access(UserBean adminUserBean, UserBean newUserBean) {
		
		Statement statement=null;
		PreparedStatement preparedStatement=null;
		
		String adminUserName=adminUserBean.getUserName();
		String adminPassword=adminUserBean.getPassword();
		String newUserName=newUserBean.getUserName();
		String newUserPassword=newUserBean.getPassword();
		String newUserAccessType=newUserBean.getAccessType();
		
		System.out.println(adminUserName);
		System.out.println(adminPassword);
		System.out.println(newUserName);
		System.out.println(newUserAccessType);
		
		String searchQuery="select * from users_details where username='"+adminUserName+"' AND password='"+adminPassword+"' AND privilege="+"'admin"+"'";
		String insertQuery="insert into users_details(username, password, privilege) values(?,?,?)"; 
		System.out.println(searchQuery);
		System.out.println(insertQuery);
		try {
			statement=currentCon.createStatement();
			resultSet=statement.executeQuery(searchQuery);
			
			if(resultSet.next()){
				preparedStatement=currentCon.prepareStatement(insertQuery);
				preparedStatement.setString(1, newUserName);
				preparedStatement.setString(2, newUserPassword);
				preparedStatement.setString(3, newUserAccessType);
				
				preparedStatement.executeUpdate();
				
				
				boolean more=resultSet.next();
				
				if(!more){
					return null;
				}
				else 
					return adminUserBean;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
