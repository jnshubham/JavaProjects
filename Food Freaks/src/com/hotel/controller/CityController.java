package com.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.hotel.model.Cities;
import com.hotel.service.CityService;



@Controller
public class CityController {

	
	@Autowired
	private CityService cityService;
	
	
	
	
	@RequestMapping(value="cityview",method=RequestMethod.GET)
    public ModelAndView HotelView(@ModelAttribute("command") Cities city,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("stateList", cityService.allState());
		return new ModelAndView("City",model);
	}
	
	@RequestMapping(value="savecity",method=RequestMethod.POST)
	public ModelAndView saveHotel(@ModelAttribute("command") Cities city,BindingResult result)
	{
		cityService.addData(city);
		return new ModelAndView("City");
	}
	
	
	
}
