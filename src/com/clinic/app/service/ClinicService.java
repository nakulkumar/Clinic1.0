package com.clinic.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinic.app.dao.IClinicDao;
import com.clinic.app.entity.User;

@Service
public class ClinicService implements IClinicService{

	@Autowired
	IClinicDao clinicDao;
	
	public ClinicService(){
		
	}
	
	@Transactional
	@Override
	public User getdetails() {
		return clinicDao.getdetails();
	}

	
	
	
}
