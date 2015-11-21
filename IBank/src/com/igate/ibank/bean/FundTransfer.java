package com.igate.ibank.bean;

import java.util.Date;

public class FundTransfer {

	int fundTransferId;
	AccountMaster account;
	long payeeAccountId;
	Date dateOfTransfer;
	float transferAmount;
	
	
	public FundTransfer() {
		
	}

	/*CREATE TABLE Fund_Transfer
	(
		FundTransfer_ID NUMBER,
		Account_ID NUMBER(10),
		Payee_Account_ID NUMBER(10), 
		Date_Of_Transfer DATE, 
		Transfer_Amount NUMBER(15),
		Constraint Fund_Account_cnst FOREIGN KEY (Account_ID) REFERENCES AccountMaster(Account_ID)
	);*/

	public FundTransfer(int fundTransferId, AccountMaster account,
			long payeeAccountId, Date dateOfTransfer, float transferAmount) {
		super();
		this.fundTransferId = fundTransferId;
		this.account = account;
		this.payeeAccountId = payeeAccountId;
		this.dateOfTransfer = dateOfTransfer;
		this.transferAmount = transferAmount;
	}


	public int getFundTransferId() {
		return fundTransferId;
	}


	public void setFundTransferId(int fundTransferId) {
		this.fundTransferId = fundTransferId;
	}


	public AccountMaster getAccount() {
		return account;
	}


	public void setAccount(AccountMaster account) {
		this.account = account;
	}


	public long getPayeeAccountId() {
		return payeeAccountId;
	}


	public void setPayeeAccountId(long payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}


	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}


	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}


	public float getTransferAmount() {
		return transferAmount;
	}


	public void setTransferAmount(float transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Override
	public String toString() {
		return "FundTransfer [fundTransferId=" + fundTransferId + ", account="
				+ account + ", payeeAccountId=" + payeeAccountId
				+ ", dateOfTransfer=" + dateOfTransfer + ", transferAmount="
				+ transferAmount + "]";
	}
	
	
	
	
	
	
	
}
