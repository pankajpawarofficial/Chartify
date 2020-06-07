package com.chartify.services;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chartify.beans.ChartDataBean;


public class DaoChart {
	
	private ConnectionManager connectionManager;
	private Connection connection = null;
	private ResultSet resultSet = null;
	
	public DaoChart() {
		super();
		connectionManager=new ConnectionManager();
		connection=connectionManager.getConnection();	
		}
	
	public void excelReader(FileInputStream fileInputStream,String projectName){
		ExcelImporter excelImporter=new ExcelImporter();
		ArrayList<ChartDataBean> arrayList=excelImporter.getArrayList(fileInputStream);
		System.out.println(arrayList.size());
		for(ChartDataBean chartDataBean:arrayList){
			chartDataBean.setProjectName(projectName);
		}
		databaseWriter(arrayList);		
	}
	
	public void databaseWriter(ArrayList<ChartDataBean> arrayList) {

		PreparedStatement preparedStatement = null;
		
		 String sql = "INSERT INTO CHARTIFY VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 try {
			preparedStatement=connection.prepareStatement(sql);
			for (int k = 0; k < arrayList.size()-1; k++) 
			{              
		        preparedStatement.setInt(1, arrayList.get(k).getSlNo());
		        preparedStatement.setDouble(2,arrayList.get(k).getDataPoint());
		        preparedStatement.setBoolean(3,arrayList.get(k).isOutlier());
		        preparedStatement.setDouble(4,arrayList.get(k).getuCL3());
		        preparedStatement.setDouble(5,arrayList.get(k).getlCL3());
		        preparedStatement.setDouble(6,arrayList.get(k).getuCL2());
		        preparedStatement.setDouble(7,arrayList.get(k).getlCL2());
		        preparedStatement.setDouble(8,arrayList.get(k).getuCL1());
		        preparedStatement.setDouble(9,arrayList.get(k).getlCL1());
		        preparedStatement.setDouble(10, arrayList.get(k).getMean());
		        preparedStatement.setInt(11,arrayList.get(k).getuSL());
		        preparedStatement.setInt(12,arrayList.get(k).getlSL());
		        preparedStatement.setString(13,arrayList.get(k).getIncidentId());
		        preparedStatement.setString(14,arrayList.get(k).getYear());
		        preparedStatement.setString(15,arrayList.get(k).getQuarter());
		        preparedStatement.setString(16,arrayList.get(k).getProjectName());
		        preparedStatement.executeUpdate();
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ChartDataBean> databaseReader(String projectName) {
		
		ArrayList<ChartDataBean> arrayList=new ArrayList<ChartDataBean>();
		
		Statement statement = null;
		String searchQuery="select Sl_No,Data_Points,Outlier,UCL_3,LCL_3,UCL_2,LCL_2,UCL_1,LCL_1,Mean,USL,LSL,Incident_ID,Year,quarter from CHARTIFY where project_name="+"'B2B'";
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(searchQuery);
			resultSet.next();
			do{	ChartDataBean chartDataBean=new ChartDataBean();
				chartDataBean.setSlNo(resultSet.getInt(1));
				chartDataBean.setDataPoint(resultSet.getDouble(2));
				chartDataBean.setOutlier(resultSet.getBoolean(3));
				chartDataBean.setuCL3(resultSet.getDouble(4));
				chartDataBean.setlCL3(resultSet.getDouble(5));
				chartDataBean.setuCL2(resultSet.getDouble(6));
				chartDataBean.setlCL2(resultSet.getDouble(7));
				chartDataBean.setuCL1(resultSet.getDouble(8));
				chartDataBean.setlCL1(resultSet.getDouble(9));
				chartDataBean.setMean(resultSet.getDouble(10));
				chartDataBean.setuSL(resultSet.getInt(11));
				chartDataBean.setlSL(resultSet.getInt(12));
				chartDataBean.setIncidentId(resultSet.getString(13));
				chartDataBean.setYear(resultSet.getString(14));
				System.out.println(resultSet.getString(14));
				chartDataBean.setQuarter(resultSet.getString(15));
				
				arrayList.add(chartDataBean);
			}while(resultSet.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public ArrayList<String> getQuarters(){
		ArrayList<String> quarters=new ArrayList<String>();
		System.out.println("hi");
		String query="select distinct quarter from CHARTIFY";
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			 statement=connection.createStatement();
			 resultSet=statement.executeQuery(query);
			 resultSet.next();
			 do {
				 quarters.add(resultSet.getString(1));
			 }while(resultSet.next());
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(quarters);
		return quarters;
	}
	
	public ArrayList<String> getYears(){
		System.out.println("hi");
		ArrayList<String> years=new ArrayList<String>();
		String query="select distinct year from chartify_data";
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			 statement=connection.createStatement();
			 resultSet=statement.executeQuery(query);
			 resultSet.next();
			 do {
				 years.add(resultSet.getString(1));
			 }while(resultSet.next());
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(years);
		return years;
	}

}
