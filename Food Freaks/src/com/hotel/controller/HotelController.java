package com.hotel.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.hotel.model.Cities;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;
import com.hotel.service.HotelService;

@Controller
public class HotelController {
	
	
	@Autowired
	private HotelService hotelService;
	

	
	@RequestMapping(value="savehotel",method=RequestMethod.POST)
	public ModelAndView saveHotel(@ModelAttribute("command") Hotels hotel,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		hotelService.addData(hotel);
		model.put("autogen", hotelService.AutoGenHotelid());
		model.put("stateList", hotelService.allState());
		model.put("hotelList", hotelService.hotelList());
		return new ModelAndView("Hotels",model);
	}
	
	
	@RequestMapping(value="addhotel",method=RequestMethod.GET)
	public ModelAndView addHotel(@ModelAttribute("command") Hotels hotel,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("autogen", hotelService.AutoGenHotelid());
		model.put("stateList", hotelService.allState());
		model.put("hotelList", hotelService.hotelList());
		return new ModelAndView("Hotels",model);
	}
	
	
	
	
	@RequestMapping(value="edithotel",method=RequestMethod.GET)
	public ModelAndView updateHotel(@ModelAttribute("command") Hotels hotel,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("stateList", hotelService.allState());
		model.put("hotel", hotelService.updateHotel(hotel.getHotelid()));
		model.put("hotelList", hotelService.hotelList());
		return new ModelAndView("Hotels",model);
	}
	
	
	@RequestMapping(value="deletehotel",method=RequestMethod.GET)
	public ModelAndView deleteHotel(@ModelAttribute("command") Hotels hotel,BindingResult result)
	{
		hotelService.deleteHotel(hotel.getHotelid());
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("hotelList", hotelService.hotelList());
		return new ModelAndView("Hotels",model);
	}
	
	
	
	@RequestMapping(value="/displayCity", method=RequestMethod.GET)
	public @ResponseBody List<Cities> fillCity(String state)
	{  
		List<Cities> C= hotelService.allCity(state);
		System.out.println("dddddddddddddd"+C);
	
		return C;
	}
	
	

	@RequestMapping(value="/displayLocations", method=RequestMethod.GET)
	public @ResponseBody List<Locations> fillLocation(String city)
	{  
		List<Locations> L= hotelService.locations(city);
		System.out.println("dddddddddddddd"+L);
	
		return L;
	}
	
	
	
}