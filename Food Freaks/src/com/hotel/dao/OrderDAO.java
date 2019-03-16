package com.hotel.dao;

import java.util.List;

import com.hotel.model.OrderReview;



public interface OrderDAO {
	
	
	
	public void addData(OrderReview or);
	public int AutoGenOrderid();
	public List<OrderReview> orderList();
	

}
