package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.SearchDAO;
import com.hotel.model.Dishes;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;
import com.hotel.model.Menus;


@Service("SearchService")
public class SearchServiceImpl implements SearchService{

	
	@Autowired
	private SearchDAO searchDAO;
	
	
	@Transactional
	public List<Locations> searchList() {
		// TODO Auto-generated method stub
		return searchDAO.searchList();
	}


	@Transactional
	public List<Hotels> hotels(String locationid) {
		// TODO Auto-generated method stub
		return searchDAO.hotels(locationid);
	}


	@Transactional
	public List<Menus> hotelMenu(String hotelid) {
		// TODO Auto-generated method stub
		return searchDAO.hotelMenu(hotelid);
	}


	@Transactional
	public List<Dishes> menuDishes(String menuid) {
		// TODO Auto-generated method stub
		return searchDAO.menuDishes(menuid);
	}

/*
	@Transactional
	public void addData(Search S) {
		// TODO Auto-generated method stub
		searchDAO.addData(S);
	}


	@Transactional
	public List<Locations> searchlocation() {
		// TODO Auto-generated method stub
		return searchDAO.searchlocation();
	}*/

}
