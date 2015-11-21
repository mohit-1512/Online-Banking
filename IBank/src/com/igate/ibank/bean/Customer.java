package com.igate.ibank.bean;

public class Customer {

	long customerId;
	String customerName;
	String email;
	String address;
	String pancard;
	long mobile;
	
	public Customer() {
		
	}

	public Customer(long customerId, String customerName, String email,
			String address, String pancard, long mobile) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobile = mobile;
	}

	
	
	
	

	public long getCustomerId() {
		return customerId;
	}

	

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		
		Customer c=(Customer)o;
		
		if(this.getCustomerId()==c.getCustomerId() 
				&& this.getCustomerName().equals(c.getCustomerName()) 
				&& this.getEmail().equals(c.getEmail()) && this.getPancard().equals(c.getPancard()))
		{
			return true;
		}
		return false;
		
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", email=" + email + ", address=" + address
				+ ", pancard=" + pancard + "]";
	}
	
	
	
	
}
