package com.clinic.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
