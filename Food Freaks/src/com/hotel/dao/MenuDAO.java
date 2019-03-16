package com.hotel.dao;

import java.util.List;

import com.hotel.model.Hotels;
import com.hotel.model.Menus;

public interface MenuDAO {

	public void addData(Menus M);
	public List<Menus> menuList();
	public Menus updateMenu(String menuid);
	public void deleteMenu(String menuid);
	public List<Hotels> allHotels();
	public int AutoGenMenuid();
}
