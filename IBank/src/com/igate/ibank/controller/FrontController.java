package com.igate.ibank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();

		RequestDispatcher requestDispatcher=null;
		if(uri.contains("admin"))
		{
			if(uri.contains("admin_login.do"))
			{
				System.out.println("In Front Controller going to adminLogin servlet");
				requestDispatcher=request.getRequestDispatcher("AdminLogin");
				requestDispatcher.forward(request, response);
			}
			if(uri.contains("admin_createAccNewExisting.do"))
			{
				System.out.println("In Front Controller going to CreateAccNewExisting servlet");
				requestDispatcher=request.getRequestDispatcher("CreateAccNewExisting");
				requestDispatcher.forward(request, response);
			}
			
			if(uri.contains("admin_createUser"))
			{
				System.out.println("In Front Controller going to CreateUserAction servlet");
				requestDispatcher=request.getRequestDispatcher("CreateUserAction");
				requestDispatcher.forward(request, response);
			}
			
			if(uri.contains("admin_createAccBtn"))
			{
				
				System.out.println("In Front Controller going to CreateAccountAction servlet");
				requestDispatcher=request.getRequestDispatcher("CreateAccountAction");
				requestDispatcher.forward(request, response);
				
			}
			
			if(uri.contains("admin_displayAccDetails"))
			{
					
				System.out.println("In Front Controller going to DisplayAccountAction servlet");
				requestDispatcher=request.getRequestDispatcher("DisplayAccountAction");
				requestDispatcher.forward(request, response);
				
			}
		}
		else
		{
			//UserCode
			if(uri.contains("login"))
			{
				requestDispatcher=request.getRequestDispatcher("LoginAction");
				requestDispatcher.forward(request, response);
			}
			
			
			
			
			
		}
		
	}

}
