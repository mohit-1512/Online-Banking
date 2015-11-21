package com.igate.ibank.bean;

import java.util.Date;

public class Transactions {
	
	
	int transactionId;
	String transactionDescription;
	String transactionType;
	Date DateOfTransaction;
	float transactionAmount;
	AccountMaster account;
	
	
	public Transactions() {
		
	}
	
	
	/*CREATE TABLE Transactions
	(
		Transaction_ID NUMBER PRIMARY KEY,
		Tran_description VARCHAR2(100),
		DateofTransaction DATE NOT NULL,
		TransactionType VARCHAR2(1) NOT NULL,   
		TranAmount NUMBER(15) NOT NULL, -- > 0
		Account_No NUMBER(10) NOT NULL,
		CONSTRAINT transaction_cnst check (TransactionType  in ('credit','debit')),
		Constraint Account_Transaction_cnst FOREIGN KEY (Account_No) REFERENCES AccountMaster(Account_ID)
	);*/



	public Transactions(int transactionId, String transactionDescription,
			String transactionType, Date dateOfTransaction,
			float transactionAmount, AccountMaster account) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		DateOfTransaction = dateOfTransaction;
		this.transactionAmount = transactionAmount;
		this.account = account;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public String getTransactionDescription() {
		return transactionDescription;
	}


	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public Date getDateOfTransaction() {
		return DateOfTransaction;
	}


	public void setDateOfTransaction(Date dateOfTransaction) {
		DateOfTransaction = dateOfTransaction;
	}


	public float getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public AccountMaster getAccount() {
		return account;
	}


	public void setAccount(AccountMaster account) {
		this.account = account;
	}
	
	
	

}
