package com.chartify.views;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chartify.services.DaoChart;

/**
 * Servlet implementation class UploadFileForm
 */
public class UploadFileForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		FileInputStream fileInputStream=null;
		String projectName=null;
		 try {
		        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		        for (FileItem item : items) {
		            if (item.isFormField()) {
		                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
		                String fieldName = item.getFieldName();
		                projectName = item.getString();
		                System.out.println(fieldName);
		                System.out.println(projectName);
		            } else {
		                String fieldName = item.getFieldName();
		                fileInputStream= (FileInputStream)item.getInputStream();
		                System.out.println(fieldName);
		            }
		        }
		    } catch (FileUploadException e) {
		    	System.out.println("notworking");
		        throw new ServletException("Cannot parse multipart request.", e);
		    }
		 
		 DaoChart dao=new DaoChart();
		 dao.excelReader(fileInputStream, projectName);
		 response.sendRedirect("chart.jsp");
	}

}
