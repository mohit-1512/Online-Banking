package com.igate.ibank.test;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.Transactions;
import com.igate.ibank.dao.CustomerDao;
import com.igate.ibank.dao.TransactionsDao;
import com.igate.ibank.exception.IbankException;

public class TransactionsDaoTest
{
	TransactionsDao transactionsDao;
	AccountMaster am; 


		@Before
		public void initResources() throws IbankException
		{
			transactionsDao=new TransactionsDao();
			am=new AccountMaster();
		}
		
		@Test
		public void testAddTransactions() throws IbankException
		{
			Transactions ts=new Transactions();
			Date today=new Date();
			ts.setTransactionAmount(789.56f);
			ts.setTransactionDescription("savings");
			ts.setTransactionType("credit");
			am.setAccountId(10008);
			ts.setAccount(am);
			//System.out.println(ts);
			
			boolean actualResult=transactionsDao.addTransactions(ts);
			Assert.assertEquals(true,actualResult);
		}
		
		@Test
		public void testDeleteTransactions()  throws IbankException
		{
			int transactionId=21;
			boolean actualResult=transactionsDao.deleteTransactions(transactionId);
			Assert.assertTrue(actualResult);
		}
		
		@Test
		public void testGetTransactions() throws IbankException
		{
			int transactionId=9;
			ArrayList<Transactions> al=transactionsDao.getTransactions(transactionId);
			System.out.println(al);
			Assert.assertNotNull(al);
			
		}
		@After
		public void release() throws IbankException
		{
			transactionsDao=null;
			am=null;
		}
}