/**
 * 
 */
package com.igate.ibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.User;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.util.DatabaseUtil;

/**
 * @author trgl1
 *
 */
public class UserDao 
{
	private Connection connection;
	private DatabaseUtil dbUtil;
	public UserDao() throws IbankException {
		dbUtil=DatabaseUtil.getInstance();
	}
	
	
	/*
	 * Adds user and returns true if successful else returns false
	 */
	public User addUser(User user) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO User_Table" +
					"(user_ID,Customer_ID ,login_password, secret_question, Transaction_password, lock_status,SECRET_ANSWER)" +
					" values (user_sequence.NEXTVAL,?,?,?,?,'N',?)");
			
			preparedStatement.setLong(1, user.getCustomer().getCustomerId());
			preparedStatement.setString(2, user.getLoginPassword());
			preparedStatement.setString(3, user.getSecretQuestion());
			preparedStatement.setString(4, user.getTransactionPassword());
			preparedStatement.setString(5, user.getSecretQuestionAnswer());
			//preparedStatement.setString(5,	user.getLockStatus());
			
			
			if(preparedStatement.executeUpdate()>0)
			{
				PreparedStatement selectCustomer=connection.prepareStatement("SELECT * FROM User_Table " +
						" WHERE user_ID=(select max(user_ID) from User_Table)");
				ResultSet rs=selectCustomer.executeQuery();
				rs.next();
				
				user.setUserId(rs.getInt("user_ID"));
				System.out.println(user.getUserId());
				return user;
			}
			else
			{
				throw new IbankException("Unable to create a New Customer"); 
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return user;
		}
		finally
		{
			dbUtil.releaseConnection();
		}
	}
	
	
	
	
	/*
	 * Adds user and returns true if successful else returns false
	 */
	public boolean deleteUser(int id) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM User_Table " +
					"WHERE user_ID = ?");
			
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate()>0);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			dbUtil.releaseConnection();
			
		}
	}
	
	/*
	 * insert an Id to update the user and add changes on the user object
	 */
	public boolean updateUser(long id, User user) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("UPDATE User_Table SET " +
					"Customer_ID = ? ,login_password = ?, secret_question = ?, Transaction_password = ?, lock_status = ? ,SECRET_ANSWER=?" +
					"WHERE ");
			
			preparedStatement.setLong(1, user.getCustomer().getCustomerId());
			preparedStatement.setString(2, user.getLoginPassword());
			preparedStatement.setString(3, user.getSecretQuestion());
			preparedStatement.setString(4, user.getTransactionPassword());
			preparedStatement.setString(5,	 user.getLockStatus());
			return preparedStatement.execute();
			
		} catch (SQLException e) {
			//throw new IbankException("User not updated "+e.getMessage());
			return false;
		}
		finally
		{
			dbUtil.releaseConnection();
			
		}
	}
	
	
	/*
	 * Returns the user of specific Id
	 */
	public User getUser(long userId) throws IbankException
	{
		User user;
		long customerId;
		
		CustomerDao customerDao=new CustomerDao();
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM  user_table " +
					"WHERE USER_ID = ?");
			
			preparedStatement.setLong(1, userId);
			ResultSet rs=preparedStatement.executeQuery();
			rs.next();
			user=new User(rs.getLong("USER_ID"), null, rs.getString("LOGIN_PASSWORD"), rs.getString("SECRET_QUESTION"), rs.getString("SECRET_ANSWER"), rs.getString("TRANSACTION_PASSWORD"),  rs.getString("LOCK_STATUS"));
			customerId=rs.getLong("CUSTOMER_ID");
			user.setCustomer(customerDao.getCustomer(customerId));
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
		}
	
		
		return user;
	}
	
	
	/*
	 * Returns the user of specific Id
	 */
	public int getUserAvailibilty(long userId) throws IbankException
	{
		
		int rowCount;
		CustomerDao customerDao=new CustomerDao();
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select count(*) FROM  user_table " +
					"WHERE USER_ID = ?");
			
			preparedStatement.setLong(1, userId);
			ResultSet rs=preparedStatement.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
		}
	
		
		return rowCount;
	}
	
	
	
	public User getUser(long userId, String password) throws IbankException
	{
		User user;
		int customerId;
		
		CustomerDao customerDao=new CustomerDao();
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM  user_table " +
					"WHERE USER_ID = ? " +
					"AND LOGIN_PASSWORD = ?");
			
			preparedStatement.setLong(1, userId);
			
			ResultSet rs=preparedStatement.executeQuery();
			rs.next();
			user=new User(rs.getInt("USER_ID"), null, rs.getString("LOGIN_PASSWORD"), rs.getString("SECRET_QUESTION"), rs.getString("SECRET_ANSWER") , rs.getString("TRANSACTION_PASSWORD"),  rs.getString("LOCK_STATUS"));
			customerId=rs.getInt("CUSTOMER_ID");
			user.setCustomer(customerDao.getCustomer(customerId));
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
		}
	
		
		return user;
	}
	
	
	/*
	 * returns the users 
	 */
	public ArrayList<User> getUsers() throws IbankException
	{
		User user;
		int customerId;
		
		ArrayList<User> users=new ArrayList<User>();
		CustomerDao customerDao=new CustomerDao();
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM  user_table ");
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				user=new User(rs.getInt("USER_ID"), null, rs.getString("LOGIN_PASSWORD"), rs.getString("SECRET_QUESTION"), rs.getString("SECRET_ANSWER") , rs.getString("TRANSACTION_PASSWORD"),  rs.getString("LOCK_STATUS"));
				customerId=rs.getInt("CUSTOMER_ID");
				user.setCustomer(customerDao.getCustomer(customerId));
				users.add(user);
			}
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
		}
		return users;
	}

}
