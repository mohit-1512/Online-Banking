package com.igate.ibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.Customer;
import com.igate.ibank.bean.Transactions;
import com.igate.ibank.bean.User;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.util.DatabaseUtil;


public class TransactionsDao {
	
		private Connection connection;	
		private DatabaseUtil dbUtil;
		public TransactionsDao() throws IbankException {
			
			dbUtil=DatabaseUtil.getInstance();
		}
		/*
		 * Adds transactions and returns true if successful else returns false
		 */
	
		public boolean addTransactions(Transactions ts) throws IbankException
		{
			
			connection=dbUtil.getConnection();
			boolean status=false;
			try
			{
				String insertQuery="insert into Transactions values (Transactions_sequence.nextVal,?,sysdate,?,?,?)";
				PreparedStatement ps=connection.prepareStatement(insertQuery);
				ps.setString(1,ts.getTransactionDescription());
				ps.setString(2,ts.getTransactionType());
				ps.setFloat(3,ts.getTransactionAmount());
				ps.setLong(4,ts.getAccount().getAccountId());
				
				
				//DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
				int number=ps.executeUpdate();
				if(number>0)
				{
					System.out.println(number+" record is inserted:");
					status= true;
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new IbankException(e.getMessage());
			}
			finally
			{
				dbUtil.releaseConnection();	
			}
			return status;
		}
		

		/*
		 * Delete transactions and returns true if successful else returns false
		 */
		
		public boolean deleteTransactions(int transactionId) throws IbankException
		{
			try
			{
				connection=dbUtil.getConnection();
				String deleteQuery="delete from Transactions where TRANSACTION_ID=?";
				
				PreparedStatement ps=connection.prepareStatement(deleteQuery);
				ps.setInt(1,transactionId);
				
				int number=ps.executeUpdate();
				if(number>0)
				{
					System.out.println(number+" record is deleted:");
					return true;
				}
				System.out.println(number+" record is deleted:");
				
			}
			catch (SQLException e) 
			{
				throw new IbankException(e.getMessage());
			}
			finally
			{
				try 
				{
					connection.close();
					dbUtil.releaseConnection();
				} 
				catch (SQLException e) 
				{
					throw new IbankException(e.getMessage());
				}	
			}	
			return true;
		}
		
		/*
		 *  gives details of transactions  
		 */
		
		public ArrayList<Transactions> getTransactions(int transactionId) throws IbankException
		{
			ArrayList<Transactions> transactionsDetails=new ArrayList<Transactions>();
			AccountMasterDao amd=new AccountMasterDao();
			Transactions ts;
			try
			{
				connection=dbUtil.getConnection();
				String deleteQuery="select * from Transactions where TRANSACTION_ID=?";
				
				PreparedStatement ps=connection.prepareStatement(deleteQuery);
				ps.setInt(1,transactionId);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					AccountMaster am=amd.getAccountDetail(rs.getInt("ACCOUNT_NO"));					
					transactionsDetails.add(new Transactions(rs.getInt("TRANSACTION_ID"), 
					rs.getString("TRAN_DESCRIPTION"), 
					rs.getString("TRANSACTIONTYPE"), 
					rs.getDate("DATEOFTRANSACTION"),
					rs.getFloat("TRANAMOUNT"),am));
				}
				return transactionsDetails;
			}
			
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new IbankException(e.getMessage());
			}
			finally
			{
				//connection.close();
				dbUtil.releaseConnection();	
			}
			
		}//end function
	
}
