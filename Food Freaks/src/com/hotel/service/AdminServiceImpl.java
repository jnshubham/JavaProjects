package com.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.AdminDAO;
import com.hotel.model.Admin;


@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Transactional
	public Admin ChkAdminLogin(String adminid, String password) {
		// TODO Auto-generated method stub
		return adminDAO.ChkAdminLogin(adminid, password);
	}

}
