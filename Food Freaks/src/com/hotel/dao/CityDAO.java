package com.hotel.dao;

import java.util.List;
import java.util.Map;

import com.hotel.model.Cities;

public interface CityDAO {


	public void addData(Cities C);
	public List<Map<String, String>> allState();
}
