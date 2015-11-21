/**
 * 
 */
package com.igate.ibank.service;

import java.util.List;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.exception.IbankException;

/**
 * @author trgl1
 *
 */
public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws IbankException;
	public boolean deleteCustomer(long id) throws IbankException;
	public boolean updateCustomer(long id, Customer customer) throws IbankException;
	public List<Customer> getCustomers() throws IbankException;
	
}
