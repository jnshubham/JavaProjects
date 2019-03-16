package com.hotel.service;

import com.hotel.model.Admin;

public interface AdminService {
	
	public Admin ChkAdminLogin(String adminid, String password);

}
