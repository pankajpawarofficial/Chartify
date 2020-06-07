package com.chartify.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.chartify.beans.ChartDataBean;

public class ExcelImporter {
	public ArrayList<ChartDataBean> getArrayList(FileInputStream fileInputStream) {
		ArrayList<ChartDataBean> excelData=null;
		XSSFWorkbook xssfWorkbook=null;
		try{
			xssfWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet xssfSheet=xssfWorkbook.getSheetAt(0);
			Row row;
			excelData=new ArrayList<ChartDataBean>(); 

			for (int i = 1; i <= xssfSheet.getLastRowNum(); i++){
				ChartDataBean chartDataBean=new ChartDataBean();
				row = (Row) xssfSheet.getRow(i);
				chartDataBean.setSlNo((int)row.getCell(0).getNumericCellValue());
				chartDataBean.setDataPoint(row.getCell(1).getNumericCellValue());
				String a2 = row.getCell(2).getStringCellValue();
				if(a2.equalsIgnoreCase("yes")) 
					chartDataBean.setOutlier(true);
				else 
					chartDataBean.setOutlier(false);
				chartDataBean.setuCL3(row.getCell(3).getNumericCellValue());
				System.out.println(row.getCell(3).getNumericCellValue());
				chartDataBean.setlCL3(row.getCell(4).getNumericCellValue());
				chartDataBean.setuCL2(row.getCell(5).getNumericCellValue());
				chartDataBean.setlCL2(row.getCell(6).getNumericCellValue());
				chartDataBean.setuCL1(row.getCell(7).getNumericCellValue());
				chartDataBean.setlCL1(row.getCell(8).getNumericCellValue());
				chartDataBean.setMean(row.getCell(9).getNumericCellValue());
				chartDataBean.setuSL((int)row.getCell(10).getNumericCellValue());
				chartDataBean.setlSL((int)row.getCell(11).getNumericCellValue());
				chartDataBean.setIncidentId(row.getCell(12).getStringCellValue());
				chartDataBean.setYear(row.getCell(13).getNumericCellValue()+"");
				chartDataBean.setQuarter(row.getCell(14).getStringCellValue());
				chartDataBean.setProjectName(row.getCell(15).getStringCellValue());
				excelData.add(chartDataBean);
			}
		}catch(IOException e)
		{
			System.out.println(e);
		}
		finally{
			try {
				xssfWorkbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return excelData;
	}

}
