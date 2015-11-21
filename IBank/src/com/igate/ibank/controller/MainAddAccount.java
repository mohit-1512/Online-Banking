package com.igate.ibank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.ibank.bean.User;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.service.AccountMasterServiceImpl;
import com.igate.ibank.service.CustomerServiceImpl;
import com.igate.ibank.service.UserService;

/**
 * Servlet implementation class MainAddAccount
 */
public class MainAddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	HttpSession session;
	RequestDispatcher requestDispatcher;
	UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainAddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String existingUserId = request.getParameter("exitingUserTxt");
		
		if (existingUserId != null){
			
			session = request.getSession(false);
			if (session == null) {
				session = request.getSession(true);
			}
			long existUserId=Long.parseLong(existingUserId);
			User retrievedExistingUser=null;
			try {
				retrievedExistingUser = userService.getUser(existUserId);
			} catch (IbankException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(retrievedExistingUser!=null){
				session.setAttribute("existingUser",retrievedExistingUser);
				response.sendRedirect("admin_displayAccDetails.do");
			}
			else {
				session.setAttribute("error_addExistingAcc", "User Doesnot Exist");
				requestDispatcher = request
				.getRequestDispatcher("admin_createAccNewExisting.jsp");
				requestDispatcher.forward(request, response);
				
			}
			
		}
		else {
			requestDispatcher = request
			.getRequestDispatcher("admin_createAccNewExisting.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
