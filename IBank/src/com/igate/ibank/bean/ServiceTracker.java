package com.igate.ibank.bean;

import java.util.Date;

public class ServiceTracker {

	 int serviceId;
	 String serviceDescription,serviceStatus;
	 AccountMaster account;
	 Date serviceRaisedDate;
	 
	public ServiceTracker() {
		
	}

	public ServiceTracker(int serviceId, String serviceDescription,
			String serviceStatus, AccountMaster account, Date serviceRaisedDate) {
		super();
		this.serviceId = serviceId;
		this.serviceDescription = serviceDescription;
		this.serviceStatus = serviceStatus;
		this.account = account;
		this.serviceRaisedDate = serviceRaisedDate;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public AccountMaster getAccount() {
		return account;
	}

	public void setAccount(AccountMaster account) {
		this.account = account;
	}

	public Date getServiceRaisedDate() {
		return serviceRaisedDate;
	}

	public void setServiceRaisedDate(Date serviceRaisedDate) {
		this.serviceRaisedDate = serviceRaisedDate;
	}
	
	
	
	
}
