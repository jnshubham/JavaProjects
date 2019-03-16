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

import com.hotel.model.Dishes;
import com.hotel.model.Menus;
import com.hotel.service.DishService;

@Controller
public class DishController {
	
	
	
	@Autowired
	private DishService dishService;
	
	@RequestMapping(value="dishview",method=RequestMethod.GET)
	public ModelAndView DishView(@ModelAttribute("command") Dishes dish,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("autogen", dishService.AutoGenDishid());
		return new ModelAndView("Dishes",model);
	}
	
	
	@RequestMapping(value="savedish",method=RequestMethod.POST)
	public ModelAndView saveDish(@ModelAttribute("command") Dishes dish,BindingResult result)
	{
		
		String file=dish.getDishname()+"."+dish.getIcon().substring(dish.getIcon().lastIndexOf(".")+1);
		dish.setIcon(file);
		dishService.addData(dish);
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("autogen", dishService.AutoGenDishid());
		return new ModelAndView("redirect:/adddish.html",model);
	}
	
	@RequestMapping(value="adddish",method=RequestMethod.GET)
	public ModelAndView addDish(@ModelAttribute("command") Dishes dish,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("dishList", dishService.dishList());
		model.put("autogen", dishService.AutoGenDishid());
		return new ModelAndView("Dishes",model);
	}
	
	@RequestMapping(value="editdish",method=RequestMethod.GET)
	public ModelAndView updateDish(@ModelAttribute("command") Dishes dish,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("dish", dishService.updateDish(dish.getDishid()));
		model.put("dishList", dishService.dishList());
		return new ModelAndView("Dishes",model);
	}
	
	@RequestMapping(value="deletedish",method=RequestMethod.GET)
	public ModelAndView deleteDish(@ModelAttribute("command") Dishes dish,BindingResult result)
	{
		dishService.deleteDish(dish.getDishid());
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("dishList", dishService.dishList());
		return new ModelAndView("Dishes",model);
	}

	@RequestMapping(value="/showMenus", method=RequestMethod.GET)
	public @ResponseBody List<Menus> menu()
	{  
		List<Menus> M= dishService.allMenu();
		System.out.println("dddddddddddddd"+M);
	
		return M;
	}
	
	
}
