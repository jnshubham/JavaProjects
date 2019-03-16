package com.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.CityDAO;
import com.hotel.model.Cities;


@Service("CityService")
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDAO cityDAO;

	@Transactional
	public void addData(Cities C) {
		// TODO Auto-generated method stub
		cityDAO.addData(C);
	}

	@Transactional
	public List<Map<String, String>> allState() {
		// TODO Auto-generated method stub
		return cityDAO.allState();
	}

}
