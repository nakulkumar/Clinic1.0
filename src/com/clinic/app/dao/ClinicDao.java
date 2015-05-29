package com.clinic.app.dao;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clinic.app.entity.User;


@Repository
public class ClinicDao implements IClinicDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ClinicDao(){
		 
	}
	
	@Override
	public User getdetails() {
		Query query =  sessionFactory.getCurrentSession().createQuery("from User where id=1");
		return (User)query.uniqueResult();
		
	}
	
	
	
}
