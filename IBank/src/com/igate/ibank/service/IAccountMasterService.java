package com.igate.ibank.service;

import java.util.List;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.exception.IbankException;

public interface IAccountMasterService {

	public AccountMaster addAccountMaster(AccountMaster am) throws IbankException;
	public boolean updateCustomerBalance(long accountNumber, boolean credDebit,
			float amount) throws IbankException;
	public AccountMaster getAccountDetail(long accountId) throws IbankException;
	
	public List<AccountMaster> getAccountDetailsFrmCustId(long customerId)
			throws IbankException;
	
	
	
}
