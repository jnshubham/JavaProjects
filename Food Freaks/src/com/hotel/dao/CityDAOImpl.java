package com.hotel.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.model.Cities;

@Repository("CityDAO")
public class CityDAOImpl implements CityDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addData(Cities C) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(C);
	}

	@Override
	public List<Map<String, String>> allState() {
		// TODO Auto-generated method stub
		List<Map<String, String>> S=sessionFactory.getCurrentSession().createQuery("select new map(s.stateid as stateid,s.statename as statename) from States s").list();
		return S;
	}

}
