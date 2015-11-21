package com.igate.ibank.bean;

public class PayeeTable {

	long payeeAccountId;
	AccountMaster account;
	String nickName;
	
	public PayeeTable() {
	
	}
	
	
	/*CREATE TABLE PayeeTable
	(
		Payee_Account_Id NUMBER PRIMARY KEY, 
		Account_Id NUMBER NOT NULL,
		Nick_name VARCHAR2(40),
		Constraint Payee_Account_cnst FOREIGN KEY (Account_ID) REFERENCES AccountMaster(Account_ID)
	);*/

	public PayeeTable(long payeeAccountId, AccountMaster account, String nickName) {
		super();
		this.payeeAccountId = payeeAccountId;
		this.account = account;
		this.nickName = nickName;
	}

	public long getPayeeAccountId() {
		return payeeAccountId;
	}

	public void setPayeeAccountId(long payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}

	public AccountMaster getAccount() {
		return account;
	}

	public void setAccount(AccountMaster account) {
		this.account = account;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
	
}
