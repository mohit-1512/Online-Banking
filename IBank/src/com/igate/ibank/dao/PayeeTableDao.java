package com.igate.ibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.PayeeTable;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.util.DatabaseUtil;

/**
 * @author trgl1
 * @param <Payee>
 *
 */
public class PayeeTableDao {

	private Connection connection;
	private DatabaseUtil dbUtil;
	public PayeeTableDao() throws IbankException {
		dbUtil=DatabaseUtil.getInstance();
	}
	
	
	
	/*
	 * Adds details in PayeeTable and returns true if added
	 */
	public boolean addPayee(PayeeTable payee) throws IbankException
	{
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PayeeTable" +
					"(Payee_Account_Id,Account_Id ,Nick_name)" +
					" values (?,?,?)");
			
			
			preparedStatement.setLong(1, payee.getPayeeAccountId());
			preparedStatement.setLong(2, payee.getAccount().getAccountId());
			preparedStatement.setString(3, payee.getNickName());
			
			return (preparedStatement.executeUpdate()==1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			try {
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
	}
	
	
	
	
	/*
	 * returns the users 
	 */
	public ArrayList<PayeeTable> getPayees(long accountNumber)
			throws IbankException
	{
		ArrayList<PayeeTable> payeeDetails=new ArrayList<PayeeTable>();
		connection=dbUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("Select * FROM PayeeTable WHERE ACCOUNT_ID=?");
			preparedStatement.setLong(1, accountNumber);
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				AccountMaster acc=new AccountMaster();
				acc.setAccountId(rs.getLong("Account_Id"));
				payeeDetails.add(new PayeeTable(rs.getLong("Payee_Account_Id"), acc,rs.getString("Nick_name")));
			}
			
			
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		finally
		{
			dbUtil.releaseConnection();
			
		}
		return payeeDetails;		
		
	}

}

	