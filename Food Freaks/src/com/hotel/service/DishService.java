package com.hotel.service;

import java.util.List;

import com.hotel.model.Dishes;
import com.hotel.model.Menus;

public interface DishService {

	public void addData(Dishes D);
	public List<Dishes> dishList();
	public Dishes updateDish(String dishid);
	public void deleteDish(String dishid);
	public List<Menus> allMenu();
	public int AutoGenDishid();
}
