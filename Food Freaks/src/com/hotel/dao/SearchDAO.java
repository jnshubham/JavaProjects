package com.hotel.dao;

import java.util.List;

import com.hotel.model.Dishes;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;
import com.hotel.model.Menus;


public interface SearchDAO {
	
	/*public void addData(Search S);*/
	public List<Locations> searchList();
    
	public List<Hotels> hotels(String locationid);
	public List<Menus> hotelMenu(String hotelid);
	public List<Dishes> menuDishes(String menuid);
	
	
	/*public List<Locations> searchlocation();
*/
}
