/**
 * 
 */
package com.igate.ibank.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.FundTransfer;
import com.igate.ibank.dao.AccountMasterDao;
import com.igate.ibank.dao.FundTransferDao;
import com.igate.ibank.exception.IbankException;

/**
 * @author trgl1
 *
 */
public class FundTransferDaoTest {
	
	FundTransferDao fundtransferDao;
	AccountMasterDao accountMasterDao;

	@Before
	public void initResources() throws IbankException
	{
		fundtransferDao = new FundTransferDao();
		accountMasterDao=new AccountMasterDao();
	}
	
	
	@Test
	public void addFundTransferTest() throws IbankException
	{
		Date today = new Date();
		AccountMaster ac1=accountMasterDao.getAccountDetail(10008);
		
		FundTransfer ft = new FundTransfer();
		ft.setFundTransferId(1);
		ft.setTransferAmount(2000);
		ft.setAccount(ac1);
		ft.setPayeeAccountId(10002);
		ft.setDateOfTransfer(today);
		
		System.out.println(fundtransferDao.addFundTransfer(ft));
		
	}

	@Test
	public void payeeBalanceUpdateTest() throws IbankException{
		
		Date today = new Date();
		AccountMaster ac1=accountMasterDao.getAccountDetail(10041);
		
		FundTransfer ft = new FundTransfer();
		
		ft.setFundTransferId(121);
		ft.setTransferAmount(5000);
		ft.setAccount(ac1);
		ft.setPayeeAccountId(100201);
		ft.setDateOfTransfer(today);
		
		Assert.assertTrue(fundtransferDao.payeeBalanceUpdate(ft));
		
	}

	@Test
	public void fromBalanceUpdateTest() throws IbankException{
		
		Date today = new Date();
		AccountMaster ac1=accountMasterDao.getAccountDetail(10041);
		
		FundTransfer ft = new FundTransfer();
		
		ft.setFundTransferId(43);
		ft.setTransferAmount(5000);
		ft.setAccount(ac1);
		ft.setPayeeAccountId(100244);
		ft.setDateOfTransfer(today);
		
		Assert.assertTrue(fundtransferDao.fromBalanceUpdate(ft));
		
	}
	
	@Test
	public void getFundTransfer() throws IbankException{
		
		List<FundTransfer> list = new ArrayList<FundTransfer>();
		
		FundTransfer ft = new FundTransfer();
		Date today = new Date();
		AccountMaster ac1=accountMasterDao.getAccountDetail(10041);
		ft.setFundTransferId(43);
		ft.setTransferAmount(5000);
		ft.setAccount(ac1);
		ft.setPayeeAccountId(100244);
		ft.setDateOfTransfer(today);
		
		list.add(ft);
		
		Assert.assertNotNull(list);
	}
	
	
	
}
