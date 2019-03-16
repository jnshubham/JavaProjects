package com.hotel.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.model.Cities;
import com.hotel.model.Hotels;
import com.hotel.model.Locations;

@Repository("HotelDAO")
public class HotelDAOImpl implements HotelDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void addData(Hotels H) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(H);
		
	}
	


	@Override
	public List<Map<String, String>> allState() {
		// TODO Auto-generated method stub
		List<Map<String, String>> S=sessionFactory.getCurrentSession().createQuery("select new map(s.stateid as stateid,s.statename as statename) from States s").list();
		return S;
	}


	@Override
	public List<Cities> allCity(String stateid) {
		// TODO Auto-generated method stub
		try{
			
		List<Cities> C=sessionFactory.getCurrentSession().createQuery("select c.cityid as cityid,c.cityname as cityname from Cities c where c.states.stateid="+stateid+"").list();
		return C;
		}catch(Exception e)
		{
			System.out.println("ccccccccccccccccccccccccccccccccc"+e);
		}
		
		return null;
	
	}

	
/*	@Override
	public List<Map<String, String>> hotelList() {
		// TODO Auto-generated method stub
		List<Map<String, String>> hList=sessionFactory.getCurrentSession().createQuery("select new map(h.hotelid,h.hotelname,h.address,(select s.statename from States s where h.state=s.stateid), (select c.cityname from Cities c where h.city=c.cityid),h.locationname,h.pin,h.latitude,h.emailid,h.contactno,h.ownername,h.status) from Hotels h").list();
		System.out.println(hList);
		return hList;
		}
*/
	
	
	
	/* 
		@Override
		  public List<Hotels> hotelList() {
		// TODO Auto-generated method stub
		List<Hotels> hList=sessionFactory.getCurrentSession().createCriteria(Hotels.class).list();
		return hList;
	}

	*/
	

	
	 @Override
	public List<Hotels> hotelList() {
		// TODO Auto-generated method stub
				 Session s=sessionFactory.getCurrentSession();
				
				   	Criteria c1=s.createCriteria(Hotels.class,"hotels");
				   	c1.setProjection(Projections.projectionList()	
				   				.add(Projections.property("hotelid"))
				   				.add(Projections.property("hotelname"))
				   				.add(Projections.property("address"))
				   				.add(Projections.property("cities"))
				   				.add(Projections.property("locations"))
				   				.add(Projections.property("pin"))
				   				.add(Projections.property("latitude"))
				   				.add(Projections.property("emailid"))
				   				.add(Projections.property("contactno"))
				   				.add(Projections.property("ownername"))
				   				.add(Projections.property("status"))
				   				
				   				//.add(Projections.property("cities.states.statename"))		   				
				   				);
				   //	c1.add(Restrictions.eq("cities.cityid", "cityid"));
				 //  	c1.add(Restrictions.eq("cities.stateid", "cities.states.stateid"));
				   	List L=c1.list();
				   	System.out.println("ffffffffffffffffffffffffffffffffffffff"+L);
				   	Iterator i=L.iterator();
				   	while(i.hasNext())
				   	{   Object rows[] =(Object[])i.next();
				   		Cities c=(Cities)rows[3];
				   		System.out.println("value:"+rows[0]+","+c.getCityname());
				   	}
				   List <Hotels> H=(List<Hotels>)(c1.list());
					return H;
		 
		 
		 
		 
		 
		 
		 
		 /*
		 Session s=sessionFactory.getCurrentSession();
		   //	Criteria c1= s.createCriteria(Hotels.class,"hotel");
		  	//Criteria c2=s.createCriteria(States.class,"state");
		   	Criteria c3=s.createCriteria(Cities.class,"city");
		//  c3.createCriteria("states");
		   	c3.setProjection(Projections.projectionList()
		   			   			
		   				.add(Projections.property("cityname"))
		   				.add(Projections.property("states.stateid"))
		   				
		   				);
		  // 	c3.add(Restrictions.eq("states.stateid", "1"));
		   	List L=c3.list();
		   	System.out.println("ffffffffffffffffffffffffffffffffffffff"+L);
		   	Iterator i=L.iterator();
		   	while(i.hasNext())
		   	{   Object rows[] =(Object[])i.next();
		   	          // Cities c=(Cities)rows[0];
		   	         //  States k=(States)rows[1];
		   		System.out.println("value:"+rows[0]+","+rows[1]);
		   		//System.out.println(rows[0]+","+k.getStatename()+","+k.getStateid());
		   	}
		   	
		 
		//List<Hotels> hList=sessionFactory.getCurrentSession().createQuery("select h.hotelid,h.hotelname,h.address,(select s.statename from States s where h.state=s.stateid), (select c.cityname from Cities c where h.city=c.cityid),h.locationname,h.pin,h.latitude,h.emailid,h.contactno,h.ownername,h.status from Hotels h").list();
		//System.out.println(hList);
	   return c3.list();
		
		 
		 */
		 
		 
	} 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  /*
	@Override
	  public List<Hotels> hotelList() {
	// TODO Auto-generated method stub
	List<Hotels> hList=sessionFactory.getCurrentSession().createCriteria(Hotels.class).list();
	return hList;
}*/


	@Override
	public Hotels updateHotel(String hotelid) {
		// TODO Auto-generated method stub
		return (Hotels) sessionFactory.getCurrentSession().get(Hotels.class, hotelid);
		
	}


	@Override
	public void deleteHotel(String hotelid) {
		// TODO Auto-generated method stub
		Hotels hotel=(Hotels)sessionFactory.getCurrentSession().load(Hotels.class, hotelid);
		if(null!=hotel)
		{
			sessionFactory.getCurrentSession().delete(hotel);
		}
		
	}



	@Override
	public List<Locations> locations(String cityid) {
		// TODO Auto-generated method stub
		try{
			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+cityid);
			List<Locations> C=sessionFactory.getCurrentSession().createQuery("select l.locationid as locationid,l.locationname as locationname from Locations l where l.cities.cityid="+cityid+"").list();
			return C;
			}catch(Exception e)
			{
				System.out.println("ccccccccccccccccccccccccccccccccc"+e);
			}
			
			return null;
	}



	@Override
	public int AutoGenHotelid() {
		// TODO Auto-generated method stub
		String h=(String)sessionFactory.getCurrentSession().createQuery("select max(hotelid) from Hotels").uniqueResult();
		int hid;
		hid=Integer.parseInt(h);
		hid=hid+1;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaauuuuuuuuuuuuuuuutttttttttttttttttooooooooooooooooooooooo"+hid);
		
		return hid;
	}


	

	
}
