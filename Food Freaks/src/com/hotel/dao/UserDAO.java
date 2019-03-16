package com.hotel.dao;

import java.util.List;
import java.util.Map;


import com.hotel.model.Cities;
import com.hotel.model.User;

public interface UserDAO {
	
	
	public User ChkUserLogin(String userid, String password);
	public void addData(User U);
	public List<Map<String, String>> allState();
	public List<Cities> allCity(String stateid);
	public int AutoGenUserid();
	public String getPassword(String uid);

	public User updateUser(String userid);
	public int getCount(String userid);
	public  void setC(int count, String uid);
	


}
