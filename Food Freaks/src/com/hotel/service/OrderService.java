package com.hotel.service;

import java.util.List;

import com.hotel.model.OrderReview;

public interface OrderService {

	
	
	public void addData(OrderReview or);
	public int AutoGenOrderid();
	public List<OrderReview> orderList();
	
}
