package com.hotel.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hotel.model.Cities;
import com.hotel.model.Dishes;
import com.hotel.model.User;


@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public void addData(User U) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(U);
		
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

	@Override
	public int AutoGenUserid() {
		// TODO Auto-generated method stub
		String u=(String)sessionFactory.getCurrentSession().createQuery("select max(userid) from User").uniqueResult();
		int uid;
		uid=Integer.parseInt(u);
		uid=uid+1;
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaauuuuuuuuuuuuuuuutttttttttttttttttooooooooooooooooooooooo"+uid);
		
		return uid;
	}

	@Override
	public User ChkUserLogin(String userid, String password) {
		// TODO Auto-generated method stub
		User  Ud=null;
		try{
			Query Q=sessionFactory.getCurrentSession().createQuery("from User where userid='"+userid+"' and password='"+password+"'");
			Object result=Q.uniqueResult();
			Ud=(User) result;
			System.out.print("cccccccccccccccccccccccccccccccccccccccccccc"+userid);
		}catch(Exception e)
		{
			System.out.println("sssssssssssssssssssssssssssssssss"+e);
		}
		
		
		return Ud;
	
	}

	@Override
	public String getPassword(String uid) {
		// TODO Auto-generated method stub
		String a=(String)sessionFactory.getCurrentSession().createQuery("select password from User where userid="+uid).uniqueResult();
		return a;
	}

	
	

	@Override
	public User updateUser(String userid) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().get(User.class, userid);
	}
	
	
	@Override
	public int getCount(String userid) {
		// TODO Auto-generated method stub
		
		User c=(User) sessionFactory.getCurrentSession().load(User.class, userid);
		
		System.out.println("ddddddddddddddddddddddddddddddddddddd"+c.getCount());
				
		return c.getCount();
	}




	@Override
	public void setC(int count, String uid) {
		// TODO Auto-generated method stub 
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+count+","+uid);
		//sessionFactory.getCurrentSession().createSQLQuery("update into User set count="+count+" where userid='"+uid+"'");		
		Query Q=sessionFactory.getCurrentSession().createQuery("update User u set u.count="+count+" where u.userid="+uid);
		Q.executeUpdate();
	   
	
	  
	
	
	
	}

}
