package com.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.UserDAO;
import com.hotel.model.Cities;
import com.hotel.model.User;


@Service("UserService")
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addData(User U) {
		// TODO Auto-generated method stub
		userDAO.addData(U);
		
	}

	@Transactional
	public List<Map<String, String>> allState() {
		// TODO Auto-generated method stub
		return userDAO.allState();
	}

	@Transactional
	public List<Cities> allCity(String stateid) {
		// TODO Auto-generated method stub
		return userDAO.allCity(stateid);
	}

	@Transactional
	public int AutoGenUserid() {
		// TODO Auto-generated method stub
		return userDAO.AutoGenUserid();
	}

	@Transactional
	public User ChkUserLogin(String userid, String password) {
		// TODO Auto-generated method stub
		return userDAO.ChkUserLogin(userid, password);
	}

	@Transactional
	public String getPassword(String uid) {
		// TODO Auto-generated method stub
		return userDAO.getPassword(uid);
	}

	
	@Transactional
	public User updateUser(String userid) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(userid);
	}

	@Transactional
	public int getCount(String userid) {
		// TODO Auto-generated method stub
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+userid);
		return userDAO.getCount(userid);
	}

	@Transactional
	public void setC(int count, String uid) {
		// TODO Auto-generated method stub
		userDAO.setC(count, uid);
		
	}

	

}
