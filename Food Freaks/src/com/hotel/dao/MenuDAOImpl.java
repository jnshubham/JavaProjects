package com.hotel.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.model.Hotels;
import com.hotel.model.Menus;

@Repository("MenuDAO")
public class MenuDAOImpl implements MenuDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addData(Menus M) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(M);
		
	}

	@Override
	public List<Menus> menuList() {
		// TODO Auto-generated method stub
		List<Menus> mList=sessionFactory.getCurrentSession().createCriteria(Menus.class).list();
		return mList;
	}

	@Override
	public Menus updateMenu(String menuid) {
		// TODO Auto-generated method stub
		return (Menus) sessionFactory.getCurrentSession().get(Menus.class, menuid);
	}

	@Override
	public void deleteMenu(String menuid) {
		// TODO Auto-generated method stub
		Menus menu=(Menus)sessionFactory.getCurrentSession().load(Menus.class, menuid);
		if(null!=menu)
		{
			sessionFactory.getCurrentSession().delete(menu);
		}
		
	}

	@Override
	public List<Hotels> allHotels() {
		// TODO Auto-generated method stub
		List<Hotels> H=sessionFactory.getCurrentSession().createCriteria(Hotels.class).list();
		System.out.print("menuuuuuuuuuuuuuuuuuuu"+H);
		return H;
	}

	@Override
	public int AutoGenMenuid() {
		// TODO Auto-generated method stub
		String m=(String)sessionFactory.getCurrentSession().createQuery("select max(menuid) from Menus").uniqueResult();
		int mid;
		mid=Integer.parseInt(m);
		mid=mid+1;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaauuuuuuuuuuuuuuuutttttttttttttttttooooooooooooooooooooooo"+mid);
		
		return mid;
	}

	
	
	

}
