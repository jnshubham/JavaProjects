package com.hotel.service;

import java.util.List;
import java.util.Map;

import com.hotel.model.Cities;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;

public interface HotelService {
	
	public void addData(Hotels H);
	//public List<Map<String, String>> hotelList();
	public List<Hotels> hotelList();
	public Hotels updateHotel(String hotelid);
	public void deleteHotel(String hotelid);
	public List<Map<String, String>> allState();
	public List<Cities> allCity(String stateid);
	public List<Locations> locations(String cityid);
	
	public int AutoGenHotelid();
	

}
