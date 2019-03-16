package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.DishDAO;
import com.hotel.model.Dishes;
import com.hotel.model.Menus;



@Service("DishService")
public class DishServiceImpl implements DishService {

	@Autowired
	private DishDAO dishDAO;
	
	@Transactional
	public void addData(Dishes D) {
		// TODO Auto-generated method stub
		dishDAO.addData(D);
		
	}

	@Transactional
	public List<Dishes> dishList() {
		// TODO Auto-generated method stub
		return dishDAO.dishList();
	}

	@Transactional
	public Dishes updateDish(String dishid) {
		// TODO Auto-generated method stub
		return dishDAO.updateDish(dishid);
	}

	@Transactional
	public void deleteDish(String dishid) {
		// TODO Auto-generated method stub
		dishDAO.deleteDish(dishid);
	}
	
	@Transactional
	public List<Menus> allMenu() {
		
		return dishDAO.allMenu();
	}

	@Transactional
	public int AutoGenDishid() {
		// TODO Auto-generated method stub
		return dishDAO.AutoGenDishid();
	}
	
	
	
}
