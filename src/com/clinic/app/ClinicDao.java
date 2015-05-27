package com.clinic.app;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
