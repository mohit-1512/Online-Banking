/**
 * 
 */
package com.igate.ibank.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.Customer;
import com.igate.ibank.dao.AccountMasterDao;
import com.igate.ibank.dao.CustomerDao;
import com.igate.ibank.exception.IbankException;

/**
 * @author trgl1
 *
 */
public class AccountMasterDaoTest {
	AccountMasterDao amd;
	AccountMaster am;
	Customer cust;
	CustomerDao customerDao;
	@Before
	public void initResources() throws IbankException
	{
		customerDao=new CustomerDao();
		amd=new AccountMasterDao();
		
	}
	
	@Ignore
	@Test
	public void addAccountMasterTest() throws IbankException
	{
		am=new AccountMaster();
		cust=new Customer();
		am.setAccountType("Saving");
		am.setAccountBalance(13000f);
		cust.setCustomerId(36);
		am.setCust(cust);
		//System.out.println(cust);
		//System.out.println(am);
		System.out.println(amd.addAccountMaster(am));//Working
		
		//To do for multiple entries
		
		
		
		//Assert.assertTrue(actualResult);
	}
	
	@Ignore
	@Test
	public void updateCustomerBalanceTest() throws IbankException
	{
		long accountNumber=10008l;
		boolean credDebit=true;
		float accountBalance=1000;
//		boolean actualResult=amd.updateCustomerBalance(accountNumber, credDebit, accountBalance);
//		Assert.assertTrue(actualResult);//True if transaction successful
		//To do for debit
		
		accountNumber=10008l;
		credDebit=false;
		accountBalance=1000;
		// delete boolean for entore method
		boolean actualResult=amd.updateCustomerBalance(accountNumber, credDebit, accountBalance);
		System.out.println(actualResult);
		Assert.assertTrue(actualResult);//True if transaction successful else false
	}
	

	@Test
	public void getAccountDetailTest() throws IbankException
	{
		Date d = new Date("11/19/2014");
		java.sql.Date openDate = new java.sql.Date(d.getTime()); 
		am=new AccountMaster();
		cust=customerDao.getCustomer(36);
		am.setAccountId(10008);
		am.setAccountType("Saving");
		am.setAccountBalance(8000f);
		am.setCust(cust);
		am.setOpenDate(openDate);
	//	am.setAccountId();//Set account id which is automatically inserted in db
		
		
		
		long accountId=10008;
		AccountMaster actual=amd.getAccountDetail(accountId);
		System.out.println(actual);
		System.out.println(am);
		Assert.assertEquals(am, actual);//not able to compare objs
		
	}
	

/*	@Test
	public void getAccountDetailsTest() throws IbankException{
		Assert.assertTrue(amd.getAccountDetails().size()>0);
	}*/
	
}
