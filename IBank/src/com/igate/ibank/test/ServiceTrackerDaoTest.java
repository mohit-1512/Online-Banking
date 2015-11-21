package com.igate.ibank.test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.ServiceTracker;
import com.igate.ibank.dao.ServiceTrackerDao;
import com.igate.ibank.dao.TransactionsDao;
import com.igate.ibank.exception.IbankException;

public class ServiceTrackerDaoTest 
{
	ServiceTrackerDao 	serviceTrackerDao;
	AccountMaster am; 
	
	@Before
	public void initResources() throws IbankException
	{
		serviceTrackerDao=new ServiceTrackerDao();
		am=new AccountMaster();
	}

	@Test
	public void testGetServiceRequest() throws IbankException
	{
		ServiceTracker st=new ServiceTracker();
		//st.setServiceId(123);
		am.setAccountId(10008);
		st.setAccount(am);
		st.setServiceDescription("test");
		st.setServiceStatus("passed");
		
		boolean actualResult=serviceTrackerDao.getServiceRequest(st);
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void  deleteServiceRequest() throws IbankException
	{
		int serviceId=3;
		boolean actualResult=serviceTrackerDao.deleteServiceRequest(serviceId);
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void testUpdateServiceRequest() throws IbankException
	{
		int serviceId=3;
		String serviceStatus="passed";
		boolean actualResult=serviceTrackerDao.updateServiceRequest(serviceId,serviceStatus);
		Assert.assertTrue(actualResult);
	}
	
	@Test
	public void testGetServiceRequestDetails() throws IbankException
	{
		int serviceId=2;
		ArrayList<ServiceTracker> al=serviceTrackerDao.getServiceRequestDetails(serviceId);
		Assert.assertNotNull(al);
	}
	
	@After
	public void release() throws IbankException
	{
		serviceTrackerDao=null;
		am=null;
	}
}

