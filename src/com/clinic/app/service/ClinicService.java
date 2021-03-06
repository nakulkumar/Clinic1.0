package com.clinic.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinic.app.dao.IClinicDao;
import com.clinic.app.entity.Login;
import com.clinic.app.entity.SearchForm;
import com.clinic.app.entity.User;

@Service
public class ClinicService implements IClinicService{

	@Autowired
	IClinicDao clinicDao;
	
	@Transactional
	@Override
	public User getdetails() {
		return clinicDao.getdetails();
	}

	@Transactional(readOnly=true)
	@Override
	public Login validateLogin(Login login) {
		return clinicDao.validateLogin(login.getUsername(),login.getPassword());
	}

	@Transactional
	@Override
	public boolean persistPatientDetails(User user) {
        return clinicDao.persistPatientDetails(user);
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findPatient(SearchForm search) {
		return clinicDao.findPatient(search);
	}
}
