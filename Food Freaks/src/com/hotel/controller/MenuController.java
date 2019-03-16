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

import com.hotel.model.Hotels;
import com.hotel.model.Menus;
import com.hotel.service.MenuService;



@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	
	@RequestMapping(value="menuview",method=RequestMethod.GET)
    public ModelAndView MenuView(@ModelAttribute("command") Menus menu,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("autogen", menuService.AutoGenMenuid());
		return new ModelAndView("Menu",model);
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
    public ModelAndView saveMenu(@ModelAttribute("command") Menus menu,BindingResult result)
	{
		System.out.print("ttttttttttttttttttttttttttttttttttttttt"+menu);
		String file=menu.getMenuname()+"."+menu.getIcon().substring(menu.getIcon().lastIndexOf(".")+1);
		menu.setIcon(file);
		menuService.addData(menu);
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("autogen", menuService.AutoGenMenuid());
		return new ModelAndView("redirect:/add.html",model);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public ModelAndView addMenu(@ModelAttribute("command") Menus menu,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("menuList", menuService.menuList());
		model.put("autogen", menuService.AutoGenMenuid());
		return new ModelAndView("Menu",model);
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
    public ModelAndView updateMenu(@ModelAttribute("command") Menus menu,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("menu", menuService.updateMenu(menu.getMenuid()));
		model.put("menuList", menuService.menuList());
		return new ModelAndView("Menu",model);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
    public ModelAndView deleteMenu(@ModelAttribute("command") Menus menu,BindingResult result)
	{
		menuService.deleteMenu(menu.getMenuid());
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("menuList", menuService.menuList());
		return new ModelAndView("Menu",model);
	}
	
	@RequestMapping(value="/showHotels", method=RequestMethod.GET)
	public @ResponseBody List<Hotels> hotel()
	{  
		List<Hotels> H= menuService.allHotels();
		System.out.println("dddddddddddddd"+H);
	
		return H;
	}
	

}
