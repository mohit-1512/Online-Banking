package com.igate.ibank.service;

import java.util.List;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.dao.AccountMasterDao;
import com.igate.ibank.dao.FundTransferDao;
import com.igate.ibank.exception.IbankException;

public class AccountMasterServiceImpl implements IAccountMasterService{
	AccountMasterDao accountMaster=null;
	@Override
	public AccountMaster addAccountMaster(AccountMaster am) throws IbankException {
		accountMaster = new AccountMasterDao();
		return accountMaster.addAccountMaster(am);
	}

	@Override
	public boolean updateCustomerBalance(long accountNumber, boolean credDebit,
			float amount) throws IbankException {
		accountMaster = new AccountMasterDao();
		return accountMaster.updateCustomerBalance(accountNumber, credDebit, amount);
	}

	@Override
	public AccountMaster getAccountDetail(long accountId) throws IbankException {
		accountMaster = new AccountMasterDao();
		return accountMaster.getAccountDetail(accountId);
	}
	@Override
	public List<AccountMaster> getAccountDetailsFrmCustId(long customerId) throws IbankException {
		accountMaster = new AccountMasterDao();
		return accountMaster.getAccountDetailsFrmCustId(customerId);
	}
	
	
	
	
	
}
