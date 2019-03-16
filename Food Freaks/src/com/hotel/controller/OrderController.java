package com.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.OrderReview;
import com.hotel.model.User;
import com.hotel.service.OrderService;
import com.hotel.service.UserService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public ModelAndView Checkout(@ModelAttribute("command") OrderReview order,BindingResult result, @RequestParam String amt, String uid, String dishname, String mobileno, String email, String address)
	{  
		
            Map<String,Object> model=new HashMap<String,Object>();
		    int au=orderService.AutoGenOrderid();
		    order.setOrderid(au);
		    order.setAddress(address);
		    order.setAmt(amt);
		    order.setDishname(dishname);
		    order.setEmail(email);
		    order.setMobileno(mobileno);
		    order.setUid(uid);
		    
            orderService.addData(order);
            System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssss"+dishname+","+uid);
		    model.put("data", amt);
			return new ModelAndView("CheckOut",model);
	}
	
	
	@RequestMapping(value="previousorders",method=RequestMethod.GET)
	public ModelAndView preOrder(@ModelAttribute("command") OrderReview order)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("orderList", orderService.orderList());
		return new ModelAndView("PreviousOrders",model);
	}
	
	
	
	@RequestMapping(value="checkfree",method=RequestMethod.GET)
	public ModelAndView checkFree(@ModelAttribute("command") OrderReview order, @RequestParam String amt, String uid, String dishname, String mobileno, String email, String address)
	{
		System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssss"+dishname+","+uid);
		
		//int j=(int) Math.floor(Math.random() * 3);
		int c=userService.getCount(uid);
	//	System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssrrrrrrandom"+j);
	
		
		if(c==10)
			{
				Map<String,Object> model=new HashMap<String,Object>();
			    int au=orderService.AutoGenOrderid();
			    order.setOrderid(au);
			    order.setAddress(address);
			    order.setAmt(amt);
			    order.setDishname(dishname);
			    order.setEmail(email);
			    order.setMobileno(mobileno);
			    order.setUid(uid);
			 
	            orderService.addData(order);
	            
	            userService.setC(0, uid);
	            
	            //user.setCount(0);
	            
			    model.put("data", amt);
				return new ModelAndView("CheckOut",model);
				
			}
			else
			{
				c=c+1;
				userService.setC(c, uid);
			//	user.setCount(c);
				return new ModelAndView("Free");
				
			}
		
		
	}
	

}
