/**
 * 
 */
package com.igate.ibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.FundTransfer;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.util.DatabaseUtil;

/**
 * @author trgl1
 *
 */
public class FundTransferDao {
	private Connection connection;
	private DatabaseUtil dbUtil;
	
	
	/**
	 * 
	 */
	public FundTransferDao()  throws IbankException {
		dbUtil=DatabaseUtil.getInstance();
	}
	
	
	/**
	 * Add Entry into Fund_transfer accepts an object of type FundTransfer and return FundTransferId of type int
	 */

	public int addFundTransfer(FundTransfer ft) throws IbankException
	{
		connection=dbUtil.getConnection();
		int rowCount=0;
		int fundTransferId =0;
		AccountMasterDao accountMasterDao = new AccountMasterDao();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement
			("INSERT INTO Fund_Transfer VALUES(Fund_Transfer_sequence.nextval,?,?,sysdate,?)");
	
			preparedStatement.setObject(1, ft.getAccount().getAccountId());
			preparedStatement.setLong(2, ft.getPayeeAccountId());
			preparedStatement.setFloat(3, ft.getTransferAmount());
		 
			long accId = ft.getAccount().getAccountId();
			AccountMaster am = accountMasterDao.getAccountDetail(accId);
			
			if(am.getAccountBalance()-ft.getTransferAmount()<0){ //Check for insufficient balance
			
			rowCount = preparedStatement.executeUpdate();
			
			if(rowCount==1){
				String getTransferId="SELECT max(FundTransfer_ID) FROM Fund_Transfer";
				PreparedStatement getpst=connection.prepareStatement(getTransferId);
				ResultSet rs=getpst.executeQuery();
	
				if(rs.next()){
					fundTransferId =rs.getInt(1);
					payeeBalanceUpdate(ft);
					fromBalanceUpdate(ft);
					
				}
			}
		}
			
			else{
					System.out.println("Insufficient Balance");
					return fundTransferId;
			}
			
		} catch (SQLException e) {
			throw new IbankException(e.getMessage());
		}
		
		finally
		{
			dbUtil.releaseConnection();
		}
	
		return fundTransferId;
	}
			
			
	/**
	 *  updates balance for payeeAccount returns true if updated successfully otherwise returns false 
	 * 
	 */
	
	public boolean payeeBalanceUpdate(FundTransfer ft) throws IbankException{
		
		
		AccountMasterDao accountMasterDao=new  AccountMasterDao();
		if(accountMasterDao.updateCustomerBalance(ft.getPayeeAccountId(), true, ft.getTransferAmount()))
			return true;
		
		return false;
	}
	
	
	/**
	 *  updates balance for fromAccount returns true if updated successfully otherwise returns false 
	 * 
	 */
	
	public boolean fromBalanceUpdate(FundTransfer ft) throws IbankException{
		
		AccountMasterDao accountMasterDao=new  AccountMasterDao();
		
		if(accountMasterDao.updateCustomerBalance(ft.getAccount().getAccountId(), false, ft.getTransferAmount()))
			return true;
		
		return false;
	}
	
	
	public List<FundTransfer> getFundTransfer(){
		
		List<FundTransfer> fundTransferList = new ArrayList<FundTransfer>();
		
		try {
			connection = dbUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * from  fund_transfer");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				FundTransfer ft = new FundTransfer();
				ft.setFundTransferId(rs.getInt("FUNDTRANSFER_ID"));
				AccountMaster account = new AccountMaster(); 
				account.setAccountId(rs.getInt("ACCOUNT_ID"));
				ft.setAccount(account);
				ft.setPayeeAccountId(rs.getInt("PAYEE_ACCOUNT_ID"));
				ft.setDateOfTransfer(rs.getDate(" DATE_OF_TRANSFER"));
				ft.setTransferAmount(rs.getFloat("TRANSFER_AMOUNT"));
				
				fundTransferList.add(ft);
								
			}
			
			
		} catch (IbankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return fundTransferList;
	}
		
public List<FundTransfer> getFundTransfer(int rownum){
		
		List<FundTransfer> fundTransferList = new ArrayList<FundTransfer>();
		
		try {
			connection = dbUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement
			("SELECT * from(SELECT * FROM fund_transferorder by  fundtransfer_id desc) WHERE rownum<"+rownum);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				FundTransfer ft = new FundTransfer();
				ft.setFundTransferId(rs.getInt("FUNDTRANSFER_ID"));
				AccountMaster account = new AccountMaster(); 
				account.setAccountId(rs.getInt("ACCOUNT_ID"));
				ft.setAccount(account);
				ft.setPayeeAccountId(rs.getInt("PAYEE_ACCOUNT_ID"));
				ft.setDateOfTransfer(rs.getDate(" DATE_OF_TRANSFER"));
				ft.setTransferAmount(rs.getFloat("TRANSFER_AMOUNT"));
				
				fundTransferList.add(ft);
								
			}
			
			
		} catch (IbankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return fundTransferList;
	}
	
	
}
	
	
	
	
	
	