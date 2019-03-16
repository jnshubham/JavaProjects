package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.OrderDAO;
import com.hotel.model.OrderReview;


@Service("OrderService")
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderDAO orderDAO;
	
	
	@Transactional
	public void addData(OrderReview or) {
		// TODO Auto-generated method stub
		
		orderDAO.addData(or);
		
	}


	@Transactional
	public int AutoGenOrderid() {
		// TODO Auto-generated method stub
		return orderDAO.AutoGenOrderid();
	}


	@Transactional
	public List<OrderReview> orderList() {
		// TODO Auto-generated method stub
		return orderDAO.orderList();
	}


	

}
