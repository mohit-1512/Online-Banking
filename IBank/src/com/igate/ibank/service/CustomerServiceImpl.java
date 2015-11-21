/**
 * 
 */
package com.igate.ibank.service;

import java.util.List;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.dao.CustomerDao;
import com.igate.ibank.exception.IbankException;

/**
 * @author trgl1
 *
 */
public class CustomerServiceImpl implements ICustomerService{
	CustomerDao customerDAO;
	
	@Override
	public Customer addCustomer(Customer customer) throws IbankException {
		customerDAO=new CustomerDao();
		return customerDAO.addCustomer(customer);
	}

	/* (non-Javadoc)
	 * @see com.igate.ibank.service.ICustomerService#deleteCustomer(long)
	 */
	@Override
	public boolean deleteCustomer(long id) throws IbankException {
		customerDAO=new CustomerDao();
		return customerDAO.deleteCustomer(id);
	}

	/* (non-Javadoc)
	 * @see com.igate.ibank.service.ICustomerService#updateCustomer(long, com.igate.ibank.bean.Customer)
	 */
	@Override
	public boolean updateCustomer(long id, Customer customer)
			throws IbankException {
		customerDAO=new CustomerDao();
		return customerDAO.updateCustomer(id, customer);
	}

	

	/* (non-Javadoc)
	 * @see com.igate.ibank.service.ICustomerService#getCustomers()
	 */
	@Override
	public List<Customer> getCustomers() throws IbankException {
		customerDAO=new CustomerDao();
		return customerDAO.getCustomers();
	}

}
