package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.MenuDAO;
import com.hotel.model.Hotels;
import com.hotel.model.Menus;


@Service("MenuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDAO menuDAO;

	@Transactional
	public void addData(Menus M) {
		// TODO Auto-generated method stub
		menuDAO.addData(M);
		
	}

	@Transactional
	public List<Menus> menuList() {
		// TODO Auto-generated method stub
		return menuDAO.menuList();
	}

	@Transactional
	public Menus updateMenu(String menuid) {
		// TODO Auto-generated method stub
		return menuDAO.updateMenu(menuid);
	}

	@Transactional
	public void deleteMenu(String menuid) {
		// TODO Auto-generated method stub
		menuDAO.deleteMenu(menuid);
	}

	@Transactional
	public List<Hotels> allHotels() {
		
		return menuDAO.allHotels();
	}

	@Transactional
	public int AutoGenMenuid() {
		// TODO Auto-generated method stub
		return menuDAO.AutoGenMenuid();
	}

	
	
	

}
