package com.clinic.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	
	
	
}
