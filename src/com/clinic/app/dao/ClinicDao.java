package com.clinic.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clinic.app.Login;
import com.clinic.app.SearchForm;
import com.clinic.app.User;

@Repository
public class ClinicDao implements IClinicDao {

	private static final Logger LOG = LoggerFactory.getLogger(ClinicDao.class);
	
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
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				Login.class);
		cr.add(Restrictions.like("username", username));
		cr.add(Restrictions.like("password", password));
		if (cr.list() == null)
			return null;
		else {
			return (Login) cr.uniqueResult();
		}
	}

	@Override
	public boolean persistPatientDetails(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			System.out.println(user);
			LOG.info("Data inserted into db");
			return true;
		} catch (Exception e) {
			LOG.error("Some error occured while adding data into db",e);
			return false;
		}
	}

	@Override
	public List<User> findPatient(SearchForm search) {
		List<User> patientList=new ArrayList<User>();
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		
		Disjunction orExpression = Restrictions.disjunction();

		orExpression.add(Property.forName("firstname").eq(search.getFirstname()))
        .add(Property.forName("lastname").eq(search.getLastname()))
        .add(Property.forName("mobile").eq(search.getMobile()))
        .add(Property.forName("dependent").eq(search.getDependent()))
        .add(Property.forName("refferedBy").eq(search.getRefferedBy()));

		cr.add(orExpression);
		
		patientList=(List<User>)cr.list();
		
		for(User user:patientList){
			System.out.println(user);
		}
		
		return patientList;
	}
}
