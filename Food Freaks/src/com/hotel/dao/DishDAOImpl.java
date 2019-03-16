package com.hotel.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.model.Dishes;
import com.hotel.model.Menus;

@Repository("DishDAO")
public class DishDAOImpl implements DishDAO{
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void addData(Dishes D) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(D);
		
	}

	@Override
	public List<Dishes> dishList() {
		// TODO Auto-generated method stub
		List<Dishes> dList=sessionFactory.getCurrentSession().createCriteria(Dishes.class).list();
		return dList;
	}

	@Override
	public Dishes updateDish(String dishid) {
		// TODO Auto-generated method stub
		return (Dishes) sessionFactory.getCurrentSession().get(Dishes.class, dishid);
		
	}

	@Override
	public void deleteDish(String dishid) {
		// TODO Auto-generated method stub
		Dishes dish=(Dishes)sessionFactory.getCurrentSession().load(Dishes.class, dishid);
		if(null!=dish)
		{
			sessionFactory.getCurrentSession().delete(dish);
		}
	}

	

	@Override
	public List<Menus> allMenu() {
		// TODO Auto-generated method stub
		List<Menus> M=sessionFactory.getCurrentSession().createCriteria(Menus.class).list();
		System.out.print("menuuuuuuuuuuuuuuuuuuu"+M);
		return M;
	}

	@Override
	public int AutoGenDishid() {
		// TODO Auto-generated method stub
		String d=(String)sessionFactory.getCurrentSession().createQuery("select max(dishid) from Dishes").uniqueResult();
		int did;
		did=Integer.parseInt(d);
		did=did+1;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaauuuuuuuuuuuuuuuutttttttttttttttttooooooooooooooooooooooo"+did);
		
		return did;
	}
	
	
	
}
