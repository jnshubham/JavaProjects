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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.hotel.model.Hotels;
import com.hotel.model.Search;
import com.hotel.service.SearchService;
import com.hotel.service.UserService;


@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="cityselect",method=RequestMethod.GET)
    public ModelAndView MenuView(@ModelAttribute("command") Search search,BindingResult result)
	{
		
		return new ModelAndView("SelectCity");
	}
	
	@RequestMapping(value="searchview",method=RequestMethod.GET)
    public ModelAndView SearchView(@ModelAttribute("command") Search search,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("searchList", searchService.searchList());
		return new ModelAndView("Searching",model);
	}

	@RequestMapping(value="/displayHotels", method=RequestMethod.GET)
	public @ResponseBody List<Hotels> fillHotels(String location)
	{  
		List<Hotels> H= searchService.hotels(location);
		System.out.println("dddddddddddddd"+H);
	
		return H;
	}
	
	
	@RequestMapping(value="/openHotel", method=RequestMethod.GET)
	public ModelAndView showHotelMenu(@ModelAttribute("command") Search search,BindingResult result,@RequestParam String hotelid)
	{  
	/*	List<Menus> M= searchService.hotelMenu(hotelid);
		System.out.println("dddddddddddddd"+M);
	*/	Map<String,Object> model=new HashMap<String,Object>();
		model.put("m", searchService.hotelMenu(hotelid));
		return new ModelAndView("HotelMenu",model);
	}
	

	@RequestMapping(value="/openDishes", method=RequestMethod.GET)
	public ModelAndView showMenuDishes(@ModelAttribute("command") Search search,BindingResult result,@RequestParam String menuid)
	{  
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("dishlist", searchService.menuDishes(menuid));
		return new ModelAndView("MenuDishes",model);
	}
	
	
	
	@RequestMapping(value="/add2cart", method=RequestMethod.GET)
	public ModelAndView Add2cart(@ModelAttribute("command") Search search,BindingResult result)
	{  
		
			return new ModelAndView("OrderReview");
	}
	
	
	
	
	
	
}
