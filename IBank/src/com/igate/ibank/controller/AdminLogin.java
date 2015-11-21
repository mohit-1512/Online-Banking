package com.igate.ibank.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher requestDispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,FileNotFoundException {
		doProcess(request, response);
		//admin_login.jsp
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,FileNotFoundException{
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,FileNotFoundException {
		System.out.println("in loginaction");
		String adminName=request.getParameter("adminIdTxt");
		String adminpasswd=request.getParameter("adminPasswordTxt");
		System.out.println(adminName+" "+adminpasswd);
		if(adminName==null || adminpasswd==null){
			System.out.println("null");
			requestDispatcher = request.getRequestDispatcher("admin_login.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			System.out.println("in not null");
			System.out.println(adminName+" "+adminpasswd);
			FileInputStream fis=new FileInputStream("C:\\Users\\Trgl1\\Desktop\\prj latest\\IBank\\WebContent\\admin.properties");
			Properties prop=new Properties();
			prop.load(fis);
			System.out.println("Prop"+prop.getProperty("adminName")+":"+prop.getProperty("adminPasswd"));
			if( adminName.equals(prop.getProperty("adminName")) && adminpasswd.equals(prop.getProperty("adminPasswd"))){
				response.sendRedirect("admin_createAccNewExisting.do");
			}
			else {
				request.setAttribute("login_admin_error","Invalid Adminname or Password");
				requestDispatcher = request.getRequestDispatcher("admin_login.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}

}
