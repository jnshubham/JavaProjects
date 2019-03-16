package com.hotel.service;

import java.util.List;

import com.hotel.model.Dishes;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;
import com.hotel.model.Menus;

public interface SearchService {
	
	/*public void addData(Search S);*/
	public List<Locations> searchList();
	/*public List<Locations> searchlocation();*/

	public List<Hotels> hotels(String locationid);
	public List<Menus> hotelMenu(String hotelid);
	public List<Dishes> menuDishes(String menuid);

}
