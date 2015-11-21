package com.igate.ibank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.User;
import com.igate.ibank.util.Validation;
import com.sun.xml.internal.ws.client.SenderException;

public class CreateUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;


	public CreateUserAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		requestDispatcher = request
				.getRequestDispatcher("admin_TkCustDetails.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in create user createUserAction");
		String fname = request.getParameter("fnTxt");
		String mname = request.getParameter("mdnameTxt");
		String lname = request.getParameter("lnTxt");
		String address = request.getParameter("addTxtarea");
		String mobStr = request.getParameter("mobTxt");

		String email = request.getParameter("emailTxt");
		String pan = request.getParameter("panTxt");
		String password = request.getParameter("passTxt");
		String confirmPassword = request.getParameter("confirmPassTxt");
		String transactionPassword = request.getParameter("transPassTxt");
		String confirmTransactionPassword = request
				.getParameter("confirmTransPassTxt");
		String secretQuestion = request.getParameter("secquesTxtarea");
		String secretQuestionAnswer = request.getParameter("secquesAnsTxtarea");
		boolean status = true;

		if (fname != null && mname != null && lname != null && address != null
				&& mobStr != null && email != null && pan != null
				&& password != null && confirmPassword != null
				&& transactionPassword != null
				&& confirmTransactionPassword != null && secretQuestion != null && secretQuestionAnswer != null) {
			System.out.println("here in if of create user action");

			if (Validation.isTxtBoxEmpty(fname)) {
				status = false;
				request.setAttribute("error_createUser",
						"First Name should not be empty!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isTxtBoxEmpty(mname)) {
				status = false;
				request.setAttribute("error_createUser",
						"Middle Name should not be empty!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isTxtBoxEmpty(lname)) {
				status = false;
				request.setAttribute("error_createUser",
						"Last Name should not be empty!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isTxtBoxEmpty(address)) {
				status = false;
				request.setAttribute("error_createUser",
						"Address should not be empty!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!Validation.isPhoneNumValid(mobStr)) {
				status = false;
				request.setAttribute("error_createUser",
						"Invalid Phone Number!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isTxtBoxEmpty(email)) {
				status = false;
				request.setAttribute("error_createUser",
						"Invalid Email Address!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!Validation.isPANValid(pan)) {
				status = false;
				request.setAttribute("error_createUser", "Invalid PAN!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!Validation.isTxtStringRangeValid(6, 0, password)) {
				status = false;
				request.setAttribute("error_createUser",
						"Password Should have atleast 6 characters!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!Validation.isTxtStringRangeValid(6, 0, confirmPassword)) {
				status = false;
				request.setAttribute("error_createUser",
						"Confirmed Password Should have atleast 6 characters!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!Validation.isTxtStringRangeValid(6, 0, transactionPassword)) {
				status = false;
				request.setAttribute("error_createUser",
						"Transaction Password Should have atleast 6 characters!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!Validation.isTxtStringRangeValid(6, 0,
					confirmTransactionPassword)) {
				status = false;
				request.setAttribute("error_createUser",
						"Confirmed Transaction Password Should have atleast 6 characters!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!password.equals(confirmPassword)) {
				status = false;
				request.setAttribute("error_createUser",
						"Password And Confirmed Password Should Match!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (!transactionPassword.equals(confirmTransactionPassword)) {
				status = false;
				request.setAttribute("error_createUser",
						"Transaction Password And Confirmed Transaction Password Should Match!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isTxtBoxEmpty(secretQuestion)) {
				status = false;
				request.setAttribute("error_createUser",
						"Secret Question Shouldnot be blank!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			if (Validation.isTxtBoxEmpty(secretQuestionAnswer)) {
				status = false;
				request.setAttribute("error_createUser",
						"Answer Shouldnot be blank!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}
			//
			// if(!Validation.isTxtBoxEmpty(fname) &&
			// !Validation.isTxtBoxEmpty(mname) &&
			// !Validation.isTxtBoxEmpty(lname)
			// && !Validation.isTxtBoxEmpty(address) &&
			// Validation.isPhoneNumValid(mobileNum)
			// && !Validation.isTxtBoxEmpty(email) && Validation.isPANValid(pan)
			// && !Validation.isTxtStringRangeValid(6, 0, password) &&
			// !Validation.isTxtBoxEmpty(confirmPassword)
			// && password.equals(confirmPassword)
			// && !Validation.isTxtBoxEmpty(transactionPassword) &&
			// !Validation.isTxtBoxEmpty(confirmTransactionPassword)
			// && transactionPassword.equals(confirmTransactionPassword)
			// && !Validation.isTxtBoxEmpty(secretQuestion))

			System.out.println(status);
			if (status) {

				// check password pattern in validation;now only checking for
				// empty
				String fullName = fname + " " + mname + " " + lname;
				Customer customer = new Customer();
				customer.setCustomerName(fullName);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setPancard(pan);
				long mobileNum = Long.parseLong(mobStr);
				customer.setMobile(mobileNum);

				User user = new User();
				user.setLoginPassword(password);
				user.setSecretQuestion(secretQuestion);
				user.setSecretQuestionAnswer(secretQuestionAnswer);
				user.setTransactionPassword(transactionPassword);
				user.setCustomer(customer);
				System.out.println("Cust" + customer);
				System.out.println("user" + user);
				session = request.getSession(false);
				if (session == null) {
					session = request.getSession(true);
				}

				session.setAttribute("new_user", user);
				response.sendRedirect("admin_createAccBtn.do");

			} else {
				request.setAttribute("error_createUser",
						"Invalid Details Entered!");
				requestDispatcher = request
						.getRequestDispatcher("admin_TkCustDetails.jsp");
				requestDispatcher.forward(request, response);
			}

		} else {
			System.out.println("here in else of create user action");
			requestDispatcher = request
					.getRequestDispatcher("admin_TkCustDetails.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
