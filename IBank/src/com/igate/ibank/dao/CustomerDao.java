/**
 * 
 */
package com.igate.ibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.util.DatabaseUtil;

/**
 * @author Angad
 *
 */
public class CustomerDao 
{
	private Connection connection;
	private DatabaseUtil dbUtil;
	public CustomerDao() throws IbankException {
		dbUtil=DatabaseUtil.getInstance();
	}
	
	
	/*
	 * Adds user and returns true if successful else returns false
	 */
	public Customer addCustomer(Customer customer) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO Customer" +
					"( CUSTOMER_ID,CUSTOMER_NAME ,EMAIL, ADDRESS, PANCARD )" +
					" values (Customer_sequence.NEXTVAL,?,?,?,?)");
			
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getEmail());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setString(4, customer.getPancard());
			
			if(preparedStatement.executeUpdate()>0)
			{
				PreparedStatement selectCustomer=connection.prepareStatement("SELECT * FROM Customer " +
						" WHERE CUSTOMER_ID=(select max(CUSTOMER_ID) from customer)");
				ResultSet rs=selectCustomer.executeQuery();
				rs.next();
				
				customer.setCustomerId(rs.getLong("CUSTOMER_ID"));
		/*		customer.setAddress(rs.getString("ADDRESS"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setPancard(rs.getString("PANCARD"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));*/
				return customer;
			}
			else
			{
				throw new IbankException("Unable to create a New Customer"); 
			}
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
		}
	}
	
	
	/*
	 * Adds user and returns true if successful else returns false
	 */
	public boolean deleteCustomer(long id) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Customer " +
					"WHERE CUSTOMER_ID = ?");
			
			preparedStatement.setLong(1, id);
			return (preparedStatement.executeUpdate()>0);
			
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
			
		}
	}
	
	/*
	 * Update an Id to update the user and add changes on the user object
	 */
	public boolean updateCustomer(long id, Customer customer) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("UPDATE Customer SET " +
					"CUSTOMER_NAME = ?, EMAIL = ?, ADDRESS = ?, PANCARD = ?, mobile = ? " +
					"WHERE CUSTOMER_ID = ?");
			
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getEmail());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setString(4, customer.getPancard());
			preparedStatement.setLong(5, customer.getMobile());
			preparedStatement.setLong(6, id);
			return (preparedStatement.executeUpdate()>0);
			
		} catch (SQLException e) {
			throw new IbankException("User not updated "+e.getMessage());
			
		}
		finally
		{
			dbUtil.releaseConnection();
			
		}
	}
	
	public boolean updateCustomer(Customer customer) throws IbankException
	{
		return updateCustomer(customer.getCustomerId(),customer);
	}
	
	
	/*
	 * Returns the user of specific Id
	 */
	public Customer getCustomer(long id) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM Customer " +
					"WHERE CUSTOMER_ID = ?");
			
			preparedStatement.setLong(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			rs.next();
			Customer customer=new Customer(rs.getLong("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("EMAIL"), rs.getString("ADDRESS"), rs.getString("PANCARD"),rs.getLong("mobile"));
			return customer;
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		
		
		//donot close connection as the connection would be used by other files
	}
	
	
	
	/*
	 * returns the users 
	 */
	public List<Customer> getCustomers() throws IbankException
	{
		ArrayList<Customer> customers=new ArrayList<Customer>();
		
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM Customer ");
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				customers.add(new Customer(rs.getLong("CUSTOMER_ID"), rs.getString("CUSTOMER_NAME"), rs.getString("EMAIL"), rs.getString("ADDRESS"), rs.getString("PANCARD"),rs.getLong("mobile")));
			}
			return customers;
			
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
			
		}
		
	}

}
