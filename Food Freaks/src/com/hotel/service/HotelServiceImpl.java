package com.hotel.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.HotelDAO;
import com.hotel.model.Cities;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;


@Service("HotelService")
public class HotelServiceImpl implements HotelService{
	
	
	@Autowired
	private HotelDAO hotelDAO;

	@Transactional
	public void addData(Hotels H) {
		// TODO Auto-generated method stub
		hotelDAO.addData(H);
		
	}

	@Transactional
	public List<Map<String, String>> allState() {
		// TODO Auto-generated method stub
		return hotelDAO.allState();
	}

	@Transactional
	public List<Cities> allCity(String stateid) {
		// TODO Auto-generated method stub
		return hotelDAO.allCity(stateid);
	}

	@Transactional
	public List<Hotels> hotelList() {
		// TODO Auto-generated method stub
		return hotelDAO.hotelList();
	}
	
	/*@Transactional
	 * public List<Hotels> hotelList() {
		// TODO Auto-generated method stub
		return hotelDAO.hotelList();
	}*/

	@Transactional
	public Hotels updateHotel(String hotelid) {
		// TODO Auto-generated method stub
		return hotelDAO.updateHotel(hotelid);
	}

	@Transactional
	public void deleteHotel(String hotelid) {
		// TODO Auto-generated method stub
		hotelDAO.deleteHotel(hotelid);
	}

	@Transactional
	public List<Locations> locations(String cityid) {
		// TODO Auto-generated method stub
		return hotelDAO.locations(cityid);
	}

	@Transactional
	public int AutoGenHotelid() {
		// TODO Auto-generated method stub
		return hotelDAO.AutoGenHotelid();
	}

	
	

}
