package com.chartify.beans;

public class ChartDataBean {
	
	private int slNo;
	private double dataPoint;
	private boolean	outlier;
	private double uCL1;
	private double lCL1;
	private double uCL2;
	private double lCL2;
	private double uCL3;
	private double lCL3;
	private double mean;
	private int uSL;
	private int lSL;
	private String incidentId;
	private String rootCause;
	private String correctiveActionPlanned;
	private String responsibility;
	private String targetClosureDate;
	private String actualClosureDate;
	private String status;
	private String week;
	private String projectName;
	private String userName;
	private String year;
	private String quarter;
	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	public double getDataPoint() {
		return dataPoint;
	}
	public void setDataPoint(double dataPoint) {
		this.dataPoint = dataPoint;
	}
	public boolean isOutlier() {
		return outlier;
	}
	public void setOutlier(boolean outlier) {
		this.outlier = outlier;
	}
	public double getuCL1() {
		return uCL1;
	}
	public void setuCL1(double uCL1) {
		this.uCL1 = uCL1;
	}
	public double getlCL1() {
		return lCL1;
	}
	public void setlCL1(double lCL1) {
		this.lCL1 = lCL1;
	}
	public double getuCL2() {
		return uCL2;
	}
	public void setuCL2(double uCL2) {
		this.uCL2 = uCL2;
	}
	public double getlCL2() {
		return lCL2;
	}
	public void setlCL2(double lCL2) {
		this.lCL2 = lCL2;
	}
	public double getuCL3() {
		return uCL3;
	}
	public void setuCL3(double uCL3) {
		this.uCL3 = uCL3;
	}
	public double getlCL3() {
		return lCL3;
	}
	public void setlCL3(double lCL3) {
		this.lCL3 = lCL3;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public int getuSL() {
		return uSL;
	}
	public void setuSL(int uSL) {
		this.uSL = uSL;
	}
	public int getlSL() {
		return lSL;
	}
	public void setlSL(int lSL) {
		this.lSL = lSL;
	}
	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	public String getCorrectiveActionPlanned() {
		return correctiveActionPlanned;
	}
	public void setCorrectiveActionPlanned(String correctiveActionPlanned) {
		this.correctiveActionPlanned = correctiveActionPlanned;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getTargetClosureDate() {
		return targetClosureDate;
	}
	public void setTargetClosureDate(String targetClosureDate) {
		this.targetClosureDate = targetClosureDate;
	}
	public String getActualClosureDate() {
		return actualClosureDate;
	}
	public void setActualClosureDate(String actualClosureDate) {
		this.actualClosureDate = actualClosureDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
