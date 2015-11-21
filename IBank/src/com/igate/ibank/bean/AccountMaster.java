package com.igate.ibank.bean;

import java.util.Date;

public class AccountMaster {
	


	long accountId;
	String accountType;
	float accountBalance;
	Date openDate;
	Customer cust ;

	public AccountMaster() {
	
	}

	public AccountMaster(long accountId, String accountType,
			float accountBalance, Date openDate, Customer cust) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
		this.cust = cust;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "AccountMaster [accountId=" + accountId + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance
				+ ", openDate=" + openDate + ", cust=" + cust + "]";
	}

}
	
	