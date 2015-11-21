
package com.igate.ibank.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.PayeeTable;
import com.igate.ibank.dao.PayeeTableDao;
import com.igate.ibank.exception.IbankException;


/**
 * @author trgl1
 *
 */
public class PayeeTableDaoTest {
	PayeeTableDao ptd;
	PayeeTable pt;
	AccountMaster am;
	@Before
	/**
	 * 
	 */
	public void initResource() throws IbankException {
		ptd=new PayeeTableDao();
		pt=new PayeeTable();
		am=new AccountMaster();
	}
	
	@Test
	public void addPayeeTest() throws IbankException{
		am.setAccountId(10020);
		pt.setAccount(am);
		pt.setPayeeAccountId(121411);
		pt.setNickName("Angad");
		Assert.assertEquals(true, ptd.addPayee(pt));
		
		
	}
	@Test
	public void getPayeesTest() throws IbankException{
		Assert.assertTrue(ptd.getPayees(10008).size()>0);
	}
	
	
}
