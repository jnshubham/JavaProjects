package com.hotel.dao;

import com.hotel.model.Admin;

public interface AdminDAO {
	public Admin ChkAdminLogin(String adminid, String password);

}
