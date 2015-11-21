/**
 * 
 */
package com.igate.ibank.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.dao.CustomerDao;
import com.igate.ibank.exception.IbankException;

/**
 * @author Angad
 *
 */
public class CustomerDaoTest 
{
	
	CustomerDao customerDao;
	
	@Before
	public void initResources() throws IbankException
	{
		customerDao=new CustomerDao();
	}
	@Ignore
	@Test
	public void addCustomerTest() throws IbankException
	{
		Customer c=new Customer();
		c.setCustomerName("Angad");
		c.setEmail("getangad@gmail.com");
		c.setAddress("Bharuch");
		c.setPancard("213asd");
		Customer customer=customerDao.addCustomer(c);
		System.out.println(c.getCustomerId());
		//Assert.assertTrue(actualResult);
	}
	
	@Ignore
	@Test
	public void deleteUserTest() throws IbankException
	{
		int id=20;
		boolean actualResult=customerDao.deleteCustomer(id);
		Assert.assertTrue(actualResult);
	}
	
	@Ignore
	@Test
	public void updateUserTest() throws IbankException
	{
		int id=13;
		Customer c=new Customer();
		c.setCustomerName("Jay");
		c.setEmail("jay@gmail.com");
		c.setAddress("jay hay");
		c.setPancard("sd5435");
		boolean actualResult=customerDao.updateCustomer(id,c);
		Assert.assertTrue(actualResult);
	}

	@Test
	public void getCustomerTest() throws IbankException
	{
		Customer expectedCustomer=new Customer();
		expectedCustomer.setCustomerId(26);
		expectedCustomer.setCustomerName("Angad");
		expectedCustomer.setEmail("getangad@gmail.com");
		expectedCustomer.setAddress("Bharuch");
		expectedCustomer.setPancard("213asd");
		
		Customer actualCustomer=customerDao.getCustomer(26);
		System.out.println(actualCustomer);
		System.out.println(expectedCustomer);
		Assert.assertEquals(expectedCustomer, actualCustomer);
	}

	@Test
	public void getCustomersTest() throws IbankException
	{
		Assert.assertTrue(customerDao.getCustomers().size()>0);
	}
	

}
