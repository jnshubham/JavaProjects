package com.hotel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.hotel.model.Admin;
import com.hotel.service.AdminService;



@Controller
@SessionAttributes("ses")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="down",method=RequestMethod.GET)
    public ModelAndView Down(@ModelAttribute("command") Admin admin,BindingResult result)
	{
		
		return new ModelAndView("AppDownload");
	}

	@RequestMapping(value="adminlogin",method=RequestMethod.GET)
    public ModelAndView MenuView(@ModelAttribute("command") Admin admin,BindingResult result)
	{
		
		return new ModelAndView("AdminLogin");
	}
	
	@RequestMapping(value="free",method=RequestMethod.GET)
    public ModelAndView free(@ModelAttribute("command") Admin admin,BindingResult result)
	{
		
		return new ModelAndView("Free");
	}
	
	@RequestMapping(value="chkadminlogin",method=RequestMethod.POST)
    public ModelAndView ChkAdminLogin(@ModelAttribute("command") Admin admin,BindingResult result)
	{   
		ServletRequestAttributes atr=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession ses=atr.getRequest().getSession();
		ModelAndView mav=new ModelAndView();
		
		Admin a=null;
		
		if(admin.getAdminid()!=null)
		{
		a=adminService.ChkAdminLogin(admin.getAdminid(),admin.getPassword());
		if(a!=null)
		{	mav.setViewName("AdminHome");
		System.out.println(a.getAdminname());
			mav.addObject("ses", a.getAdminname());
			mav.addObject("aid",a.getAdminid());
		
			return mav;
		}
		else
		{
			return new ModelAndView("AdminLogin");
		}
		
	}
	else
	{ 
		return new ModelAndView("adminlogin");
	}
		
		
		
	}
	
	@RequestMapping(value="adminhome",method=RequestMethod.GET)
	public ModelAndView AdminHome()
	{
		
		return new ModelAndView("AdminHome");
	}
	
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public ModelAndView Home()
	{
		
		return new ModelAndView("Homepage");
	}
	
	

}
