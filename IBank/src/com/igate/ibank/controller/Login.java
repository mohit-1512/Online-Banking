package com.igate.ibank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.ibank.bean.User;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.service.UserService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	RequestDispatcher requestDispatcher;
	UserService userService;
	HttpSession session;
    public Login() {
        super();
        
        // TODO Auto-generated constructor stub`
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	try {
			userService=new UserService();
		} catch (IbankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestDispatcher=request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String userid = request.getParameter("useridTxt");
			String password = request.getParameter("passwordTxt");

			if (userid != null && password != null && !userid.trim().equals("")
					&& !password.trim().equals("")) {
				
				User user = userService.getUser(userid, password);

				if (user != null) 
				{
					//requestDispatcher=request.getRequestDispatcher("Home");
					//requestDispatcher.forward(request, response);
					session=request.getSession(false);
					if(session==null)
					{
						session=request.getSession(true);
					}
					
					session.setAttribute("user", user);
					response.sendRedirect("Home");
				}
				else
				{
					request.setAttribute("login_error", "Invalid Username or Password!");
					requestDispatcher=request.getRequestDispatcher("login.jsp");
					requestDispatcher.forward(request, response);
				}

			}
			else
			{
				request.setAttribute("login_error", "Invalid Username or Password!");
				requestDispatcher=request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (IbankException e) {
			request.setAttribute("login_error", "Invalid Username or Password!");
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
