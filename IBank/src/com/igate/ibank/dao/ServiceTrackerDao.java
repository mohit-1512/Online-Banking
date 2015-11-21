package com.igate.ibank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.igate.ibank.bean.AccountMaster;
import com.igate.ibank.bean.ServiceTracker;
import com.igate.ibank.bean.User;
import com.igate.ibank.exception.IbankException;
import com.igate.ibank.util.DatabaseUtil;


public class ServiceTrackerDao {

		private Connection connection;
		private DatabaseUtil dbUtil;
			
			public  ServiceTrackerDao() throws IbankException {
				dbUtil=DatabaseUtil.getInstance();
			}
			
			/*
			 * Adds transactions and returns true if successful else returns false
			*/
		
			public boolean getServiceRequest(ServiceTracker st) throws IbankException
			{
				connection= dbUtil.getConnection();
				try 
				{
					String insertQuery="insert into Service_Tracker values(service_sequence.nextval,?,?,sysdate,?)";
					PreparedStatement ps=connection.prepareStatement(insertQuery);
					ps.setString(1,st.getServiceDescription());
					ps.setLong(2,st.getAccount().getAccountId());
					ps.setString(3,st.getServiceStatus());
					
					
					//DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
					int number=ps.executeUpdate();
					if(number>0)
					{
						System.out.println(number+" row is inserted:");
						return true;
					}
					return false;
				}
				catch (SQLException e) 
				{
					throw new IbankException(e.getMessage());
				}
				finally
				{
					dbUtil.releaseConnection();
				}
			}
			
			/*
			 * Delete transactions and returns true if successful else returns false
			 */
			public boolean deleteServiceRequest(int serviceId) throws IbankException
			{
				connection= dbUtil.getConnection();
				try
				{
					String deleteQuery="delete from Service_Tracker where SERVICE_ID=?";
					PreparedStatement ps=connection.prepareStatement(deleteQuery);
					ps.setInt(1,serviceId);
				
					//DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
					int number=ps.executeUpdate();
					if(number>0)
					{
						System.out.println(number+" record is deleted:");
						return true;
					}
					return false;
				} 
				catch (SQLException e)
				{
					throw new IbankException(e.getMessage());
				}
				finally
				{
					dbUtil.releaseConnection();
				}
			
			}
			
			public boolean updateServiceRequest(int serviceId,String status) throws IbankException
			{
				
				connection= dbUtil.getConnection();
				try
				{
					String updateQuery="update Service_Tracker  set SERVICE_STATUS=? "+
							"where  SERVICE_ID=?";
					PreparedStatement ps=connection.prepareStatement(updateQuery);
					ps.setString(1,status);
					ps.setInt(2,serviceId);
					//DEBUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
					int number=ps.executeUpdate();
					if(number>0)
					{
						System.out.println(number+" record is updated:");
						return true;
					}
					return false;
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
					} 
					catch (SQLException e)
					{
						throw new IbankException(e.getMessage());
					}
					dbUtil.releaseConnection();
				}
			}
			
			public ArrayList<ServiceTracker> getServiceRequestDetails(int serviceId) throws IbankException
			{
				ServiceTracker serviceTracker;
				ArrayList<ServiceTracker>  serviceDetails=new ArrayList<ServiceTracker>();
				try
				{
					connection= dbUtil.getConnection();
					String selectQuery="select * from Service_Tracker  where service_Id=?";
					
					PreparedStatement ps=connection.prepareStatement(selectQuery);
					ps.setInt(1,serviceId);
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						/*ud=new User(rs.getInt(1),rs.getString(2),rs.getString(3)
								,rs.getString(4),rs.getString(5),rs.getString(6));
						service.add(ud);*/
						AccountMaster am=new AccountMaster();
						am.setAccountId(rs.getLong(4));
						serviceDetails.add(new ServiceTracker(rs.getInt(1),rs.getString(2),
						rs.getString(3),am,rs.getDate(5)));
						
					}
					return serviceDetails;
					
				}
				catch (SQLException e) 
				{
					//e.printStackTrace();
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
				
			}
			
}
