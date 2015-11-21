/**
 * 
 */
package com.igate.ibank.util;


import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.igate.ibank.exception.IbankException;




/**
 * @author Angad
 *
 */
public class DatabaseUtil 
{
	private static Connection connection;
	
	
	private static DatabaseUtil dbutil;
	private Connection con;
	
		private DatabaseUtil() 
		{
			
		}
		
		public static DatabaseUtil getInstance() throws IbankException
		{
			if(dbutil==null)
			{
				dbutil=new DatabaseUtil();
			}
			return dbutil;
		}
		
		public Connection getConnection() throws IbankException
		{
			try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/OracleDS");
			if(con==null || con.isClosed())
			{
					con=ds.getConnection();
			}
		
		} catch (SQLException e) {
			throw new IbankException("SQL Exception in getting database Connection "+e.getMessage());
			
		} catch (NamingException e) {
			throw new IbankException("Naming Exception in getting database Connection "+e.getMessage());
		}
		return con;
		
		}
		
		public void releaseConnection() throws IbankException
		{
			try {
			//	if(con!=null && !con.isClosed())
				con.close();
			} catch (SQLException e) {
				throw new IbankException("Exception in closing the connection "+e.getMessage());
			}
			
		}
	}
