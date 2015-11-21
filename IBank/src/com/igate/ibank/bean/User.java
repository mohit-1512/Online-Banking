package com.igate.ibank.bean;

public class User {

	long userId;
	String loginPassword;
	String secretQuestion;
	String secretQuestionAnswer;
	String transactionPassword;
	String lockStatus;
	
	Customer customer;
	
	public User() {
		
		
	}

	public User(long userId, Customer customer, String loginPassword,
			String secretQuestion,String secretQuestionAnswer, String transactionPassword, String lockStatus) {
		super();
		this.userId = userId;
		this.customer = customer;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretQuestionAnswer = secretQuestionAnswer;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
	}

	public String getSecretQuestionAnswer() {
		return secretQuestionAnswer;
	}

	public void setSecretQuestionAnswer(String secretQuestionAnswer) {
		this.secretQuestionAnswer = secretQuestionAnswer;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginPassword=" + loginPassword
				+ ", secretQuestion=" + secretQuestion
				+ ", secretQuestionAnswer=" + secretQuestionAnswer
				+ ", transactionPassword=" + transactionPassword
				+ ", lockStatus=" + lockStatus + ", customer=" + customer + "]";
	}

	

}
