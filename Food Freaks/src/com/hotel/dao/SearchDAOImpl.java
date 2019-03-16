package com.hotel.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.model.Cities;
import com.hotel.model.Dishes;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;
import com.hotel.model.Menus;


@Repository("SearchDAO")
public class SearchDAOImpl implements SearchDAO {

	
	@Autowired
	private SessionFactory sessionFactory;

@Override
public List<Locations> searchList() {
	// TODO Auto-generated method stub
	
	
	Session s=sessionFactory.getCurrentSession();
	
   	Criteria c1=s.createCriteria(Locations.class,"search");
   	c1.setProjection(Projections.projectionList()	
   				.add(Projections.property("locationid"))
   				.add(Projections.property("locationname"))
   				.add(Projections.property("cities"))
   				);
   	List L=c1.list();
   	System.out.println("ffffffffffffffffffffffffffffffffffffff"+L);
   	Iterator i=L.iterator();
   	while(i.hasNext())
   	{   Object rows[] =(Object[])i.next();
   	    /*Cities s1=(Cities)rows[0];*/
   		Cities c=(Cities)rows[2];
   		System.out.println("value:"+","+rows[1]+","+c.getCityname()+","+c.getStates().getStateid()+","+c.getStates().getStatename());
   	}
   List <Locations> S=(List<Locations>)(c1.list());
	return S;
	
	
}

@Override
public List<Hotels> hotels(String locationid) {
	// TODO Auto-generated method stub
	try{
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+locationid);
		
		Session s=sessionFactory.getCurrentSession();
		
	   	Criteria c1=s.createCriteria(Hotels.class,"hotel");
	   	c1.setProjection(Projections.projectionList()	
	   				.add(Projections.property("hotelid"))
	   				.add(Projections.property("hotelname"))
	   				.add(Projections.property("ownername"))
	   				.add(Projections.property("address"))
	   				.add(Projections.property("emailid"))
	   				.add(Projections.property("contactno"))
	   				.add(Projections.property("status"))
	   				);
	   	c1.add(Restrictions.eq("locations.locationid", locationid));
	   	
	   	
	   	List L=c1.list();
	   	System.out.println("ffffffffffffffffffffffffffffffffffffff"+L);
	   	Iterator i=L.iterator();
	   	while(i.hasNext())
	   	{   Object rows[] =(Object[])i.next();
	   		System.out.println("value:"+","+rows[1]+","+rows[0]+","+rows[2]+","+rows[6]);
	   	}
	   List <Hotels> S=(List<Hotels>)(c1.list());
		return S;
		
		}catch(Exception e)
		{
			System.out.println("ccccccccccccccccccccccccccccccccc"+e);
		}
		
		return null;
}

@Override
public List<Menus> hotelMenu(String hotelid) {
	// TODO Auto-generated method stub
	try{
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+hotelid);
		
		Session s=sessionFactory.getCurrentSession();
		
	   	Criteria c1=s.createCriteria(Menus.class,"menu");
	   	c1.add(Restrictions.eq("hotels.hotelid", "111"));
	   	
	   	List<Menus> ME=(List<Menus>) (c1.list());
	   	System.out.println("value:"+","+ME.size());
	   	/*List L=c1.list();
	   	Iterator i=L.iterator();
	   	while(i.hasNext())
	   	{ //  Menus rows[] =(Menus[])i.next();
	   		Object rows[] =(Object[])i.next();
	   		System.out.println("value:"+","+rows[1]+","+rows[0]+","+rows[2]+",");
	   	}*/
	   List <Menus> S=(List<Menus>)(c1.list());
		return S;
		
		}catch(Exception e)
		{
			System.out.println("ccccccccccccccccccccccccccccccccc"+e);
		}
		
		return null;
}


@Override
public List<Dishes> menuDishes(String menuid) {
	// TODO Auto-generated method stub
	try{
		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+menuid);
		
		Session s=sessionFactory.getCurrentSession();
		
	   	Criteria c1=s.createCriteria(Dishes.class,"dish");
	   	c1.add(Restrictions.eq("menus.menuid", menuid));
	   List <Dishes> D=(List<Dishes>)(c1.list());
		return D;
		
		}catch(Exception e)
		{
			System.out.println("ccccccccccccccccccccccccccccccccc"+e);
		}
		
		return null;
}









/*@Override
public void addData(Search S) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().saveOrUpdate(S);
}

@Override
public List<Locations> searchlocation() {
	// TODO Auto-generated method stub

	Session s=sessionFactory.getCurrentSession();
	
   	Criteria c1=s.createCriteria(Locations.class,"location");
   	c1.setProjection(Projections.projectionList()	
   				.add(Projections.property("locationid"))
   				.add(Projections.property("locationname"))
   				.add(Projections.property("cities"))
   				//.add(Projections.property("cities.states"))		   				
   				);
   	
   	List L=c1.list();
   	System.out.println("ffffffffffffffffffffffffffffffffffffff"+L);
   	Iterator i=L.iterator();
   	while(i.hasNext())
   	{   
   		Object rows[] =(Object[])i.next();
   		Cities c=(Cities)rows[2];
   		States st=(States)rows[3];
   		System.out.println("value:"+st.getStatename()+","+c.getCityname());
   	}
   List <Locations> Lt=(List<Locations>)(c1.list());
	return Lt;
	

}*/
}
