package com.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.hotel.model.Admin;
import com.hotel.model.Cities;
import com.hotel.model.Dishes;
import com.hotel.model.User;
import com.hotel.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="userhome",method=RequestMethod.GET)
    public ModelAndView Down(@ModelAttribute("command") Admin admin,BindingResult result)
	{
		
		return new ModelAndView("UserHome");
	}
	
	
	
	@RequestMapping(value="userlogin",method=RequestMethod.GET)
    public ModelAndView Userlogin(@ModelAttribute("command") User user,BindingResult result,@RequestParam int chk)
	{
		if(chk==1)
		return new ModelAndView("UserLogin1");
		else
			return new ModelAndView("UserLogin");
	}
	

	@RequestMapping(value="chkuserlogin",method=RequestMethod.POST)
    public ModelAndView ChkUserLogin(@ModelAttribute("command") User user,BindingResult result)
	{  
		
		ServletRequestAttributes atr=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession ses=atr.getRequest().getSession();
		ModelAndView mv=new ModelAndView();
		User u=null;
		if(user.getUserid()!=null)
		{
		u=userService.ChkUserLogin(user.getUserid(),user.getPassword());
		if(u!=null)
		{	
			mv.addObject("ues", user.getUsername());
			mv.addObject("sid",user.getUserid());
			mv.setViewName("UserHome");
			return mv;   
		}
		else
		{
			return new ModelAndView("UserLogin");
		}
			
		}
		else
		{
			return new ModelAndView("UserLogin");
		}
			
	}
	
	
	
	
	
	
	@RequestMapping(value="chkuserlogin1",method=RequestMethod.POST)
    public ModelAndView ChkUserLogin1(@ModelAttribute("command") User user,BindingResult result)
	{  
		
		ServletRequestAttributes atr=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession ses=atr.getRequest().getSession();
		ModelAndView mv=new ModelAndView();
		User u=null;
		if(user.getUserid()!=null)
		{
		u=userService.ChkUserLogin(user.getUserid(),user.getPassword());
		if(u!=null)
		{	
			mv.addObject("ues", user.getUsername());
			mv.addObject("sid",user.getUserid());
			
		   Map<String,Object> model=new HashMap<String,Object>();
			
			System.out.println("uuuuuuuuuuussssssssssseeeeeeeeeeerrrrrrrrrrrrrriiiiiiiiiiiiiiiiddddddddddd"+user.getUserid());
			model.put("user", userService.updateUser(user.getUserid()));
			
		
		
			mv.addAllObjects(model);
			mv.setViewName("OrderReview");
			
			return mv;
			
		//	return new ModelAndView(mv,model);
		}
		else
		{
			return new ModelAndView("UserLogin1");
		}
			
		}
		else
		{
			return new ModelAndView("UserLogin1");
		}
			
	}
	
	
	
	
	
	@RequestMapping(value="userreg",method=RequestMethod.GET)
    public ModelAndView Userreg(@ModelAttribute("command") User user,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("autogen",  userService.AutoGenUserid());
		model.put("stateList", userService.allState());
		
		
		return new ModelAndView("UserRegistration",model);
	}
	
	
	
	
	@RequestMapping(value="saveuser",method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("command") User user,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		userService.addData(user);
		model.put("autogen",  userService.AutoGenUserid());
		model.put("stateList", userService.allState());
		
		return new ModelAndView("UserRegistration",model);
	}
	
	
	
	@RequestMapping(value="/displayCity1", method=RequestMethod.GET)
	public @ResponseBody List<Cities> fillCity(String state)
	{  
		List<Cities> C= userService.allCity(state);
		System.out.println("dddddddddddddd"+C);
	
		return C;
	}
	
	
	
	
	
	

	
	
	
	
	
	@RequestMapping(value="updateuser",method=RequestMethod.GET)
	public ModelAndView updateUser(@ModelAttribute("command") User user,BindingResult result)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("stateList", userService.allState());
		model.put("user", userService.updateUser(user.getUserid()));
		return new ModelAndView("UpdateProfile",model);
	}
	
	
	
	@RequestMapping(value="updateprofile",method=RequestMethod.GET)
    public ModelAndView updateProfile(@ModelAttribute("command") User user)
	{
	
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("stateList", userService.allState());
		model.put("user", userService.updateUser(user.getUserid()));
			return new ModelAndView("UpdateProfile",model);
	}
	
	@RequestMapping(value="userupdate", method=RequestMethod.POST)
	public ModelAndView userup(@ModelAttribute("command") User user)
	{
		
		userService.addData(user);

		return new ModelAndView("UserLogin");
		
	}
	
	
	
	
	
	
	
	
	
	}
	

