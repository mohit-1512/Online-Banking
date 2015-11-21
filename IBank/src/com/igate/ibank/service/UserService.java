/**
 * 
 */
package com.igate.ibank.service;

import java.util.ArrayList;

import com.igate.ibank.bean.User;
import com.igate.ibank.dao.UserDao;
import com.igate.ibank.exception.IbankException;

/**
 * @author trgl1
 *
 */
public class UserService 
{
	
	UserDao userDao;
	public UserService() throws IbankException 
	{
		userDao=new UserDao();
	}
	
	public User addUser(User user) throws IbankException
	{
		return userDao.addUser(user);
	}
	
	public boolean deleteUser(int id) throws IbankException
	{
		return userDao.deleteUser(id);
	}
	public boolean updateUser(int id, User user) throws IbankException
	{
		return userDao.updateUser(id, user);
	}
	public User getUser(long userId) throws IbankException
	{
		return userDao.getUser(userId);
	}
	public int getUserAvailibilty(long userId) throws IbankException
	{
		return userDao.getUserAvailibilty(userId);
	}
	public User getUser(String userid, String password) throws IbankException
	{
		long user_id_long;
		try
		{
			user_id_long=Long.parseLong(userid);
		}
		catch(NumberFormatException e)
		{
			return null;
		}
		return userDao.getUser(user_id_long, password);
	}
	
	public ArrayList<User> getUsers() throws IbankException
	{
		return userDao.getUsers();
	}
	
}
