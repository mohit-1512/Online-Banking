/**
 * 
 */
package com.igate.ibank.test;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.User;
import com.igate.ibank.dao.CustomerDao;
import com.igate.ibank.dao.UserDao;
import com.igate.ibank.exception.IbankException;

/**
 * @author trgl1
 *
 */
public class UserDaoTest 
{
	UserDao userDao;
	CustomerDao customerDao;
	@Before
	public void initResources() throws IbankException
	{
		userDao=new UserDao();
		customerDao=new CustomerDao();
	}
	
	@Ignore
	@Test
	public void addUserTest() throws IbankException
	{
		User user=new User();
		
		Customer customer=new Customer();
		customer.setCustomerName("ASR");
		customer.setAddress("aaa");
		customer.setEmail("a@b.com");
		customer.setPancard("a343c");
		customerDao.addCustomer(customer);
		
		user.setCustomer(customer);
		user.setLockStatus("N");
		user.setLoginPassword("aaa");
		user.setSecretQuestion("dasdsa");
		user.setTransactionPassword("idk");
		userDao.addUser(user);
	}
	
	@Ignore
	@Test
	public void getUserTest() throws IbankException
	{
		User u=userDao.getUser(4);
		System.out.println(u);
	}
	
	
	@Test
	public void getUsersTest() throws IbankException
	{
		ArrayList<User> u=userDao.getUsers();
		System.out.println(u);
	}
	
	
	
	
}
