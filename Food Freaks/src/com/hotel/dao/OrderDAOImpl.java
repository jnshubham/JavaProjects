package com.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import com.hotel.model.Dishes;
import com.hotel.model.OrderReview;

@Repository("OrderDAO")
public class OrderDAOImpl implements OrderDAO {
	
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void addData(OrderReview or) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(or);
		
		
		
	}

	@Override
	public int AutoGenOrderid() {
		// TODO Auto-generated method stub
		int o=(int) sessionFactory.getCurrentSession().createQuery("select max(orderid) from OrderReview").uniqueResult();
		o=o+1;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaauuuuuuuuuuuuuuuutttttttttttttttttooooooooooooooooooooooo"+o);
		
		return o;
	}

	@Override
	public List<OrderReview> orderList() {
		// TODO Auto-generated method stub
		List<OrderReview> oList=sessionFactory.getCurrentSession().createCriteria(OrderReview.class).list();
		return oList;
	}
	
	
	
	
	

	

}
