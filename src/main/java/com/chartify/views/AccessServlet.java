package com.chartify.views;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chartify.beans.UserBean;
import com.chartify.services.UserDao;

/**
 * Servlet implementation class AccessServlet
 */
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		UserBean adminUserBean=new UserBean();
		adminUserBean.setUserName(request.getParameter("adminusername"));
		adminUserBean.setPassword(request.getParameter("adminpassword"));
		
		UserBean newUserBean=new UserBean();
		newUserBean.setUserName(request.getParameter("newusername"));
		newUserBean.setPassword("");
		newUserBean.setAccessType(request.getParameter("select"));
		UserDao userDao=new UserDao();
		adminUserBean=userDao.access(adminUserBean, newUserBean);
		
		if(adminUserBean==null)
			System.out.println("not successfull");
		else {
			System.out.println("successfull");
		}
		
		response.sendRedirect("index.jsp");
	}

}
