package com.clinic.app;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClinicDao implements IClinicDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User getdetails() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where id=1");
		return (User) query.uniqueResult();

	}

	@Override
	public Login validateLogin(String username, String password) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Login.class);
		cr.add(Restrictions.like("username", username));
		cr.add(Restrictions.like("password", password));
		if(cr.list()==null)
			return null;
		else {
			return (Login)cr.uniqueResult();
		}
	}
}
