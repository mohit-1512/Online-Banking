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
 * Servlet implementation class CreateAccNewExisting
 */
public class CreateAccNewExisting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccNewExisting() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			userService = new UserService();

		} catch (IbankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String existingUserTxt = request.getParameter("existingUserTxt");
		System.out.println("existIdtxt:"+existingUserTxt);
		if (existingUserTxt!= null) {
			long existUserId = Long.parseLong(existingUserTxt);
			try {
				int userAvailabilty=0;
				userAvailabilty=userService.getUserAvailibilty(existUserId);
				
				if(userAvailabilty!=1){
					request.setAttribute("error_addExistingAcc",
								"User ID doesnot Exist!");
						requestDispatcher = request
								.getRequestDispatcher("admin_createAccNewExisting.jsp");
						requestDispatcher.forward(request, response);
				}
				
				
				 else {
					User eUser = userService.getUser(existUserId);
					System.out.println("Existin user in createnewexisting"+eUser);
					session = request.getSession(false);
					if (session == null) {
						session = request.getSession(true);
					}
					session.setAttribute("existingUser", eUser);
					response.sendRedirect("admin_displayAccDetails.do");
				}
			} catch (IbankException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			requestDispatcher = request
					.getRequestDispatcher("admin_createAccNewExisting.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}
