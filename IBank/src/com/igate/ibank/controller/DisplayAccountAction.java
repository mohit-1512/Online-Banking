package com.igate.ibank.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.User;
import com.igate.ibank.dao.AccountMasterDao;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.service.AccountMasterServiceImpl;
import com.igate.ibank.service.CustomerServiceImpl;
import com.igate.ibank.service.ICustomerService;
import com.igate.ibank.service.UserService;
import com.igate.ibank.util.Validation;

/**
 * Servlet implementation class DisplayAccountAction
 */
public class DisplayAccountAction extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	UserService userService;
	ICustomerService customerService;
	AccountMasterServiceImpl accountMaster;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAccountAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			userService = new UserService();
			customerService = new CustomerServiceImpl();
			accountMaster = new AccountMasterServiceImpl();
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
		System.out.println("In get");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In post");
		doProcess(request, response);
	}

	/**
	 * 
	 */
	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<AccountMaster> accountList=null;
		boolean makesessionObjNull=false;
		session = request.getSession(false);
		if (session == null) {
			session = request.getSession(true);
		}
		User existingUser = (User) session.getAttribute("existingUser");
		User newUser = (User) session.getAttribute("new_user");
		
		boolean executionFlow=true;
		
		if(newUser==null && existingUser==null){//integrate at last
			session.setAttribute("error_finalAccList","Invalid Session");// dont use
			
			requestDispatcher = request
					.getRequestDispatcher("admin_finalAccList.jsp");
			requestDispatcher.forward(request, response);
		}
		
		String accType = request.getParameter("anotheraccTypeDDown");
		String openBal = request.getParameter("anotherobalTxt");
		
			
				if(accType!=null && openBal!=null){
					System.out.println("Herein add another account");
					boolean status = true;

					if (Validation.isTxtBoxEmpty(accType)) {
						status = false;
						request.setAttribute("error_createAccountAgain",
								"Invalid Account Type!");
				requestDispatcher = request
								.getRequestDispatcher("admin_finalAccList.jsp");
						requestDispatcher.forward(request, response);
					}
					if (Validation.isAmountNegative(openBal)) {
						status = false;
						request.setAttribute("error_createAccountAgain",
								"Opening Balance should not be negative");
						requestDispatcher = request
								.getRequestDispatcher("admin_finalAccList.jsp");
						requestDispatcher.forward(request, response);
					}

					if (status) {
						System.out.println("Status true for another account addition");
						AccountMaster account = new AccountMaster();
						account.setAccountType(accType);
						float opBal = Float.parseFloat(openBal);
						account.setAccountBalance(opBal);
						User user=null;
						
						if(newUser==null){
							user=existingUser;		
						}
						if(existingUser==null){
							user=newUser;
							
							}
						try {
							accountList=accountMaster.getAccountDetailsFrmCustId(user.getCustomer().getCustomerId());
							System.out.println("Account List bef iterator"+accountList);
							Iterator<AccountMaster> it=accountList.iterator();
							while (it.hasNext()) {
								System.out.println("Here inside iterotor");
								AccountMaster accountMasterValidate= (AccountMaster) it.next();
								if(accountMasterValidate.getAccountType().equals(accType)){
									executionFlow=false;
									System.out.println("Acc Type Entered:"+accType);
									System.out.println("Acc Type in DB:"+accountMasterValidate.getAccountType());
									request.setAttribute("error_createAccountAgain","Account Already Created");
									requestDispatcher = request
											.getRequestDispatcher("admin_finalAccList.jsp");
									requestDispatcher.forward(request, response);
								}
							}
						} catch (IbankException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(executionFlow){
							System.out.println("User details"+user);
							account.setCust(user.getCustomer());
							System.out.println("in doprocess create account action infinal account list;account"+account);
							session.setAttribute("existingUser",user);
							
							//session.setAttribute("new_user", null);
							session.removeAttribute("new_user");
							System.out.println("New User in add another acc:"+session.getAttribute("new_user"));
							newUser=null;
							existingUser=user;
							session.setAttribute("newaccountAnother", account);
							System.out.println("Done in add another account");
						}
						
					}
					
				}
				
		if(executionFlow){	
			accountList=null;
			
			if (existingUser != null) {
				try {
					System.out.println("Existing User in DisplayAccountAction"+existingUser);
					session.setAttribute("displayUser", existingUser);
					Customer displayCust=existingUser.getCustomer();
					session.setAttribute("displayCustomer", displayCust);
					
					AccountMaster anotherAcc=(AccountMaster) session.getAttribute("newaccountAnother");
					if(anotherAcc!=null){
						AccountMaster anotherAddedAcc=accountMaster.addAccountMaster(anotherAcc);
						System.out.println("Another added account in DisplayAccountAction:"+anotherAddedAcc);
					}
					
					accountList=accountMaster.getAccountDetailsFrmCustId(displayCust.getCustomerId());//used for displaying account
					System.out.println("Account list for existing user"+accountList);
					session.setAttribute("accountDisplay",accountList);
					requestDispatcher = request
					.getRequestDispatcher("admin_finalAccList.jsp");
					requestDispatcher.forward(request, response);
				} catch (IbankException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			if (newUser != null) {
				try {
					System.out.println("Session New User in DisplayAccountAction"+newUser);
					Customer newCustomer = newUser.getCustomer();
					Customer addedCustomer = customerService.addCustomer(newCustomer);
					session.setAttribute("displayCustomer", addedCustomer);//used
					System.out.println("New Added Customer" + addedCustomer);
					User addedUser = userService.addUser(newUser);
					session.setAttribute("displayUser", addedUser);//used
					System.out.println("New Added User in DisplayAccountAction" + addedUser);
					
					AccountMaster newAccount = (AccountMaster) session
							.getAttribute("new_account");
					AccountMaster addedAcc = accountMaster.addAccountMaster(newAccount);
					session.setAttribute("addedAccount", addedAcc);// dont use
					System.out.println("New Added Account in DisplayAccountAction" + addedAcc);
					accountList=accountMaster.getAccountDetailsFrmCustId(addedCustomer.getCustomerId());
					System.out.println("Account list for new user"+accountList);
					session.setAttribute("accountDisplay",accountList);//used for displaying account
					System.out.println("Done in new User");
					requestDispatcher = request.getRequestDispatcher("admin_finalAccList.jsp");
					requestDispatcher.forward(request, response);
				} catch (IbankException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		
		
		
	
		
		
	}

}
