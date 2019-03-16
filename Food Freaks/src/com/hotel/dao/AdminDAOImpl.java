package com.hotel.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.model.Admin;

@Repository("AdminDAO")
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Admin ChkAdminLogin(String adminid, String password) {
		// TODO Auto-generated method stub
		Admin  Ad=null;
		try{
			Query Q=sessionFactory.getCurrentSession().createQuery("from Admin where adminid='"+adminid+"' and password='"+password+"'");
			Object result=Q.uniqueResult();
			Ad=(Admin) result;
			System.out.print("cccccccccccccccccccccccccccccccccccccccccccc"+adminid);
		}catch(Exception e)
		{
			System.out.println("sssssssssssssssssssssssssssssssss"+e);
		}
		
		
		return Ad;
	}

}
