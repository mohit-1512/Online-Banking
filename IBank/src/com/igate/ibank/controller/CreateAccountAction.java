package com.igate.ibank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.User;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.service.UserService;
import com.igate.ibank.util.Validation;

/**
 * Servlet implementation class CreateAccountAction
 */
public class CreateAccountAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Here in CreateAccountAction get");
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

		System.out.println("in create createAccountAction");
		String accType = request.getParameter("accTypeDDown");
		String openBal = request.getParameter("obalTxt");

		if (accType != null && openBal != null) {
			boolean status = true;

			if (Validation.isTxtBoxEmpty(accType)) {
				status = false;
				request.setAttribute("error_createAccount",
						"Invalid Account Type!");
		requestDispatcher = request
						.getRequestDispatcher("admin_addAccountbttn.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isAmountNegative(openBal)) {
				status = false;
				request.setAttribute("error_createAccount",
						"Opening Balance should not be negative");
				requestDispatcher = request
						.getRequestDispatcher("admin_addAccountbttn.jsp");
				requestDispatcher.forward(request, response);
			}

			if (status) {
				AccountMaster account = new AccountMaster();
				account.setAccountType(accType);
				float opBal = Float.parseFloat(openBal);
				account.setAccountBalance(opBal);
				session = request.getSession(false);
				if (session == null) {
					session = request.getSession(true);
				}
				User user = (User) session.getAttribute("new_user");
				
				account.setCust(user.getCustomer());
				System.out.println("in doprocess create account action;account"+account);
				session.setAttribute("new_account", account);
				response.sendRedirect("admin_displayAccDetails.do");
			} else {
				request.setAttribute("error_createAccount",
						"Invalid Details Entered!");
				requestDispatcher = request
						.getRequestDispatcher("admin_addAccountbttn.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else
		{
		requestDispatcher = request
		.getRequestDispatcher("admin_addAccountbttn.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}
